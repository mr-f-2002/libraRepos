package com.example.demo11;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    @FXML
    private Button signUp;
    @FXML
    private Label loginError, signupError;
    @FXML
    private TextField username, firstName, sUsername, lastName, sId, dept, email;
    @FXML
    private PasswordField password, sPassword, sRepassword;
    @FXML
    private Stage stage;
    private Scene scene;
    @FXML
    protected void signupBtn(ActionEvent event) throws IOException {  // signup button in login page
        System.out.println("UP");
        Parent root = FXMLLoader.load(getClass().getResource("signup.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void loginBtn(ActionEvent event) throws IOException{
        if(username.getText().isBlank() == true || password.getText().isBlank() == true) {
            loginError.setText("Wrong username or password!!");
        }else {
            String usrname = username.getText();
            String pass = password.getText();
            if(usrname.equals("admin") && pass.equals("123")){
                welcomePage(event);
                /*
                    For now, I used hardcoded values, in real scene
                    usrname and pass needs to be checked in database
                */
            } else{
                loginError.setText("Wrong username or password!!");
            }
        }
    }
    @FXML
    protected void signup(){   //signup button in signup page
        System.out.println("signup Button Pressed");
        String fn = firstName.getText();
        String ln = lastName.getText();
        String id = sId.getText();
        String department = dept.getText();
        String mail = email.getText();
        String username = sUsername.getText();
        String pas1 = sPassword.getText();
        String pas2 = sRepassword.getText();
        if(pas1.equals(pas2)==false) {
            signupError.setText("Password must be identical for both fields!");
        }
        else {
            /*
              check if the username already exists or not
              if exists,
                    signupError.setText("Username Already Exists");
              if not,
                    Insert the user information in the DATABASE
             */
        }
    }
    @FXML
    protected void signupcancel(ActionEvent event) throws IOException{
        System.out.println("Cancel Button Pressed!!");
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void welcomePage(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("welcomepage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}