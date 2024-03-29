package com.example.demo11;

import Model.postUnit;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

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
    public TextField searchbar;
    public static String USERID;
    public static String USERNAME;

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
        homepage(event, USERNAME, USERID);
    }

    @FXML
    void loadProfile(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("profile.fxml"));
        root = loader.load();
        Profile pp = loader.getController();
        pp.initialize(null, null, userId.getText());
        pp.setData(USERNAME, USERID);
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setResizable(false);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void loadToolsPage(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("tools.fxml"));
        Parent root = loader.load();
        Tools tt = loader.getController();
        tt.setData(USERNAME, USERID);
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
       // stage.setResizable(false);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void searchPost(ActionEvent event) throws IOException {
        String keyword = searchbar.getText();

        if(!keyword.isEmpty()) {
            container.getChildren().clear();

            List<postUnit> ll = new ArrayList<>(JDBC.searchPost(keyword));

            int n = ll.size();


            if(n==0){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("errortext.fxml"));

                try {
                    Label lab = loader.load();
                    lab.setText("No Search Result Found!");
                    container.getChildren().add(lab);
                    String title="ALERT";
                    String message="NO SEARCH RESULT FOUND\n";
                    TrayNotification tray=new TrayNotification();
                    AnimationType type= AnimationType.POPUP;
                    tray.setAnimationType(type);
                    tray.setTitle(title);
                    tray.setMessage(message);
                tray.setNotificationType(NotificationType.ERROR);
                    tray.showAndDismiss(Duration.seconds(1));
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
    }

    @FXML
    void setData(String s, String s2) {
        userName.setText(s);
        userId.setText(s2);
        USERNAME = s;
        USERID = s2;
        System.out.println("the user id now is -> " + USERID);
    }

    public void showconfirm(){
        FXMLLoader labelloader = new FXMLLoader(getClass().getResource("errortext.fxml"));

        try {
            Label lab1 = labelloader.load();
            lab1.setText("Your post has been uploaded!");
            container.getChildren().add(lab1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void initialize(URL url, ResourceBundle resourceBundle, String user_name, String user_id){
        USERNAME = user_name;
        USERID = user_id;
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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    public void homepage(ActionEvent event, String s1, String s2) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("welcomepage.fxml"));
        Parent root = loader.load();
        welcomepageController wc = loader.getController();
        wc.initialize(null, null, USERNAME, USERID);
        wc.setData(s1, s2);
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setResizable(false);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void profilepage(ActionEvent event,  String s1, String s2) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("profile.fxml"));
        root = loader.load();
        Profile pp = loader.getController();
        pp.initialize(null, null, USERID);
        pp.setData(s1, s2);
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setResizable(false);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private AnchorPane upp;
    public void detect(MouseEvent mouseEvent) {
        System.out.println("detected");
        TranslateTransition tt = new TranslateTransition();
        tt.setNode(upp);
        tt.setDuration(Duration.seconds(0.3));
        tt.setByX(180);
        tt.setAutoReverse(true);
        tt.play();
    }
    public void detectt(MouseEvent mouseEvent) {
        System.out.println("detected");
        TranslateTransition tt = new TranslateTransition();
        tt.setNode(upp);
        tt.setDuration(Duration.seconds(0.3));
        tt.setByX(-180);
        tt.setAutoReverse(true);
        tt.play();
    }
}

