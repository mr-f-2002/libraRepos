package com.example.demo11;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class NewPost {

    @FXML
    private Button addPost;

    @FXML
    private VBox container;

    @FXML
    private Button home;

    @FXML
    private Button myProfile;

    @FXML
    private Label userName;

    private Parent root;
    private Stage stage;
    private Scene scene;

    @FXML
    void addPost(ActionEvent event) {

    }

    @FXML
    void loadHome(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("welcomepage.fxml"));
        root = loader.load();
        welcomepageController wc = loader.getController();
        wc.setData(userName.getText());

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void loadProfile(ActionEvent event) {

    }

    public void setData(String uname){
        this.userName.setText(uname);
    }

}
