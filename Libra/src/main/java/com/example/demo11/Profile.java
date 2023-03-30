package com.example.demo11;

import Model.postUnit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Profile implements Initializable {
    @FXML
    private Button addPost;
    @FXML
    private VBox container;
    @FXML
    private Button myProfile;
    @FXML
    private Label userId;
    @FXML
    private Label userName;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;


    @FXML
    void addPost(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("newPost.fxml"));
        Parent root = loader.load();
        NewPost np = loader.getController();
        np.setData(userName.getText(), userId.getText());

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setResizable(false);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    @FXML
    void loadHome(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("welcomepage.fxml"));
        Parent root = loader.load();
        welcomepageController wc = loader.getController();
        wc.initialize(null, null, welcomepageController.USERNAME, welcomepageController.USERID);
        wc.setData(userName.getText(), userId.getText());

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setResizable(false);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    @FXML void setData(String userNAME, String userID){
        userName.setText(userNAME);
        userId.setText(userID);
    }



    @FXML
    void logout(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        Parent root = loader.load();
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setResizable(false);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void seeSavedPost(ActionEvent event) throws IOException {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("welcomepage.fxml"));
//        Parent root = null;
//        try {
//            root = loader.load();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        welcomepageController wc = loader.getController();
//        wc.initialize(null, null, welcomepageController.USERNAME, welcomepageController.USERID);
//        wc.setData(userName.getText(), userId.getText());
        JDBC.MysavedPost(userId.getText());

        container.getChildren().clear();

        List<postUnit> ll = new ArrayList<>(JDBC.numberofsaved(userId.getText()));

        int n = ll.size();



        if(n==0){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("errortext.fxml"));

            try {
                Label lab = loader.load();
                lab.setText("No Search Result Found!");
                container.getChildren().add(lab);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("structure.fxml"));
            try {
                VBox vBox = loader.load();
                Structure ss = loader.getController();
                ss.settingData(ll.get(i));
                container.getChildren().add(vBox);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }



//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        stage.setResizable(false);
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();



    public void initialize(URL url, ResourceBundle resourceBundle, String userId) {
        List<postUnit> list = new ArrayList<>(JDBC.myPost(userId));
        for(int i=0; i<list.size(); i++){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("profstructure.fxml"));
            try {
                VBox vBox = loader.load();
                Structure ss = loader.getController();
                ss.settingData(list.get(i));
                container.getChildren().add(vBox);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
