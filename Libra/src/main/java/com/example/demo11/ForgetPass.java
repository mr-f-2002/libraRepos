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

import javax.mail.MessagingException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ForgetPass implements Initializable {

    @FXML
    private TextField emailField;

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
    void sendMail(ActionEvent event) throws IOException, MessagingException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("otp1.fxml"));
        Parent rt = loader.load();
        Otp1 otp1 = loader.getController();
        otp1.initialize(null, null);
        otp1.setData(emailField.getText());

        Stage stg = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stg.setResizable(false);
        Scene scn = new Scene(rt);
        stg.setScene(scn);
        stg.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
