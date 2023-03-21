package com.example.demo11;
import Model.postUnit;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

public class welcomepageController implements Initializable{
    @FXML
    private VBox container;
    @FXML
    private Label userId, userName;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;

    @FXML
    void addPost(ActionEvent event) throws IOException {
        System.out.println("UP");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("newPost.fxml"));
        Parent root = loader.load();
        NewPost np = loader.getController();
        np.setData(userName.getText(), userId.getText());

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void loadHome(ActionEvent event) throws IOException {
        homepage(event);
    }

    @FXML
    void loadProfile(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("profile.fxml"));
        root = loader.load();
        Profile pp = loader.getController();
        pp.initialize(null, null, userId.getText());
        pp.setData(userName.getText(), userId.getText());
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setResizable(false);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void searchPost(ActionEvent event) {
    }

    @FXML
    void setData(String s, String s2) {
        userName.setText(s);
        userId.setText(s2);
        Structure.userID = s2;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<postUnit> ll = new ArrayList<>(JDBC.allPost());
        int n = ll.size();
        for(int i=0; i<n; i++) {
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
    @FXML
    public void homepage(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("welcomepage.fxml"));
        Parent root = loader.load();
        welcomepageController wc = loader.getController();
        wc.setData(userName.getText(), userId.getText());
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setResizable(false);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}

