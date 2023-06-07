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

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ResetPass implements Initializable {

    @FXML
    private TextField passField;

    @FXML
    private TextField passField1;
    String Mail;

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

    @FXML
    void updatePass(ActionEvent event) throws IOException {
        String pas1 = passField.getText();
        String pas2 = passField1.getText();
        if(pas1.equals(pas2)){
            String password = UTILITY.encrypt(pas1);
            JDBC.updatePassword(Mail, password);
            String title="Password Reset Successfully";
            TrayNotification tray=new TrayNotification();
            AnimationType type= AnimationType.POPUP;
            tray.setAnimationType(type);
            tray.setTitle(title);
            tray.setNotificationType(NotificationType.SUCCESS);
            tray.showAndDismiss(Duration.seconds(1));
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
            Parent rt = loader.load();
            Stage stg = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stg.setResizable(false);
            Scene scn = new Scene(rt);
            stg.setScene(scn);
            stg.show();
        }
        else{
            String title="Password Reset Failed";
            String message="Password must be identical for both field\n";
            TrayNotification tray=new TrayNotification();
            AnimationType type= AnimationType.POPUP;
            tray.setAnimationType(type);
            tray.setTitle(title);
            tray.setMessage(message);
            tray.setNotificationType(NotificationType.ERROR);
            tray.showAndDismiss(Duration.seconds(1));
        }
    }
    void setData(String mail){
        Mail = mail;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
