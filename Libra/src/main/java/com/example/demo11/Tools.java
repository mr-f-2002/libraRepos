package com.example.demo11;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Tools implements Initializable {


    @FXML
    private Label userId;

    @FXML
    private Label userName;

    @FXML
    private WebView webview;

    @FXML
    private TextField URL;


    private WebEngine webEngine;

    @FXML
    void addPost(ActionEvent event) {

    }

    @FXML
    void loadGoogle(ActionEvent event) {
        webEngine.load("http://google.com");
    }

    @FXML
    void loadHome(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("welcomepage.fxml"));
        Parent root = loader.load();
        welcomepageController wc = loader.getController();
        wc.initialize(null, null, userName.getText(), userId.getText());
        wc.setData(userName.getText(), userId.getText());
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setResizable(false);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void loadStackOverflow(ActionEvent event) {
        webEngine.load("https://stackoverflow.com/");
    }

    @FXML
    void loadProfile(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("profile.fxml"));
        Parent root = loader.load();
        Profile pp = loader.getController();
        pp.initialize(null, null, userId.getText());
        pp.setData(userName.getText(), userId.getText());
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setResizable(false);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void loadWord(ActionEvent event) {
        webEngine.load("https://www.office.com/?auth=1");
    }

    @FXML
    void loadGFG(ActionEvent event){
        webEngine.load("https://www.geeksforgeeks.org/");
    }

    @FXML
    void loadCompiler(ActionEvent event){
        webEngine.load("https://www.programiz.com/cpp-programming/online-compiler/");
    }

    @FXML
    void loadGPT(ActionEvent event){
        webEngine.load("https://chat.openai.com/chat");
    }

    @FXML
    void loadURL(ActionEvent event) {
        webEngine.load("http://" + URL.getText());
    }



    void setData(String username, String userid){
        userName.setText(username);
        userId.setText(userid);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        webEngine = webview.getEngine();
        webEngine.load("http://library.iutoic-dhaka.edu/main/");
    }
}
