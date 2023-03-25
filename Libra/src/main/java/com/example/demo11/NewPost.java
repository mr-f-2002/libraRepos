package com.example.demo11;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class NewPost implements Initializable {
    @FXML private Button addBtn;
    @FXML private Button cancelBtn;
    @FXML private ChoiceBox<String> category;
    @FXML private VBox container;
    @FXML private TextArea postArea;
    @FXML private Label userName;
    @FXML private Label userId;
    @FXML private Parent root;
    @FXML private Stage stage;
    @FXML private Scene scene;
    private String[] categories = {"Hostel","Politics","Canteen","Rocket","Faculty","Confession","Others"};
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        category.getItems().addAll(categories);
        category.setValue("Others");
    }

    public void setData(String text, String userID) {
        userName.setText(text);
        userId.setText(userID);
    }

    @FXML
    void cencelPost(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("New Post Upload Cancellation");
        alert.setContentText("Do you want to leave without posting?");
        if(alert.showAndWait().get() == ButtonType.OK) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("welcomepage.fxml"));
            root = loader.load();
            welcomepageController wc = loader.getController();
            wc.initialize (null,null,userName.getText(),userId.getText());
            wc.setData(userName.getText(), userId.getText());
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stage.setResizable(false);
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    void insertPost(ActionEvent event) {
        String postBODY = postArea.getText();
        String userID = userId.getText();
        String categoryNAME = category.getValue() ;
        String postId = UTILITY.generateString();
        LocalDateTime currentDate = LocalDateTime.now();
        JDBC.insertNewPost(postId, postBODY, currentDate, userID, categoryNAME);
        System.out.println(postId +" "+ userID +" "+ postBODY +" "+ categoryNAME +" "+ currentDate);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("welcomepage.fxml"));

        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        welcomepageController wc = loader.getController();
        wc.initialize(null,null,userName.getText(), userId.getText() );
        wc.setData(userName.getText(), userId.getText());

        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setResizable(false);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        wc.showconfirm();
        wc.initialize(null, null, userName.getText(), userId.getText());
    }
}
