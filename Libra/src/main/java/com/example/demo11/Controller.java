package com.example.demo11;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.SQLException;

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
    private Parent root;
    @FXML
    protected void signupBtn(ActionEvent event) throws IOException {  // signup button in login page
        System.out.println("UP");
        Parent root = FXMLLoader.load(getClass().getResource("signup.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setResizable(false);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void loginBtn(ActionEvent event) throws IOException, SQLException {


        if(username.getText().isBlank() == true || password.getText().isBlank() == true) {
            loginError.setText("Wrong username or password!!");
        }else {
            String usrname = username.getText();
            String pass = password.getText();
            if(JDBC.checkEntry(usrname, pass) == true) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("welcomepage.fxml"));
                root = loader.load();
                welcomepageController wc = loader.getController();
                String userID = JDBC.getUserId(username.getText());
                wc.initialize(null, null, username.getText(), userID);
                wc.setData(username.getText(), userID);
                stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                stage.setResizable(false);
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else{
                loginError.setText("Wrong username or password!!");
            }
        }
    }

    @FXML
    protected void signup(ActionEvent event) throws SQLException, IOException {   //signup button in signup page
        System.out.println("Signup Button Pressed");
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
            if(JDBC.checkUsernameAndMail(username, mail) == false)
                signupError.setText("username or email already exists");
            else if(UTILITY.checkStudentId(id) == false)
                signupError.setText("Student ID can contain numbers only!");
            else if(UTILITY.checkEmail(mail) == false)
                signupError.setText("Invalid email !!!");
            else if(UTILITY.checkUsername(username)==false)
                signupError.setText("username can contain only lowercase letters, numbers and underscore symbol");
            else if(UTILITY.checkPassword(pas1) == false)
                signupError.setText("Password is not Strong Enough!");
            else {
                pas1 = UTILITY.encrypt(pas1);
                JDBC.EnterData(fn, ln, id, department, mail, username, pas1);
                Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setResizable(false);
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        }
    }
    @FXML
    protected void signupcancel(ActionEvent event) throws IOException{
        System.out.println("Cancel Button Pressed!!");
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Sign Up Cancellation");
        alert.setContentText("Do you want to quit signing up?");
        if(alert.showAndWait().get() == ButtonType.OK) {
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setResizable(false);
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }



}