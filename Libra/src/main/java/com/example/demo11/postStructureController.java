package com.example.demo11;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class postStructureController implements Initializable {

    @FXML
    private VBox container;

    @FXML
    private TextField postContent;

    @FXML
    private Label postuser;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    void set(setter str){
        postuser.setText(str.getUserName());
        postContent.setText(str.getPostContent());
    }
}
