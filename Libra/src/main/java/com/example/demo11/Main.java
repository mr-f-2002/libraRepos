package com.example.demo11;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.mail.MessagingException;
import java.sql.Connection;

public class Main extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login.fxml"));

        Scene scene = new Scene(fxmlLoader.load());

        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws MessagingException {

        Connection con = connection.fastconnect();
        launch(args);
        //Controller.initialized();

    }
}

