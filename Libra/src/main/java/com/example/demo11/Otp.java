package com.example.demo11;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

import javax.mail.MessagingException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Otp implements Initializable {
    private String fn;
    private String ln;
    private String id;
    private String department;
    private String mail;
    private String username;
    private String pas1;
    private String givenOtp;

    @FXML
    private TextField otpField;


    @FXML
    void checkOTP(ActionEvent event) throws SQLException, IOException, MessagingException{
        String enteredOtp = otpField.getText();
        String gOtp = givenOtp;
        System.out.println(enteredOtp);
        System.out.println(gOtp);

        if(enteredOtp.equals(gOtp)){
            JDBC.EnterData(fn, ln, id, department, mail, username, pas1);
            String title="Sign In Successful";
            String message="Sign In Successful\n";
            TrayNotification tray=new TrayNotification();
            AnimationType type= AnimationType.POPUP;
            tray.setAnimationType(type);
            tray.setTitle(title);
            tray.setMessage(message);
            tray.setNotificationType(NotificationType.SUCCESS);
            tray.showAndDismiss(Duration.seconds(1));
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setResizable(false);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else{
            String title="Sign In Failed";
            String message="OTP doesn't match";
            TrayNotification tray=new TrayNotification();
            AnimationType type= AnimationType.POPUP;
            tray.setAnimationType(type);
            tray.setTitle(title);
            tray.setMessage(message);
            tray.setNotificationType(NotificationType.SUCCESS);
            tray.showAndDismiss(Duration.seconds(1));
        }
    }

    @FXML
    void otpCncl(ActionEvent event) throws IOException {
        System.out.println("Cancel Button Pressed!!");
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Sign Up Cancellation");
        alert.setContentText("Do you want to cancel signing up?");
        if(alert.showAndWait().get() == ButtonType.OK) {
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setResizable(false);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    public void setData(String Fn, String Ln, String Id, String Department, String Mail, String Username, String Pas1) throws MessagingException {
        fn = Fn;
        ln = Ln;
        id = Id;
        department = Department;
        mail = Mail;
        username = Username;
        pas1 = Pas1;
        givenOtp = UTILITY.generateOtp();
        UTILITY.sendOTP(givenOtp, Mail);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
