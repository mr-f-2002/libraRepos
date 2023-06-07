package com.example.demo11;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.Pair;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CommentPage implements Initializable {
    private String userid = welcomepageController.USERID;
    public static String postid;
    @FXML
    private TextArea cmntBody;
    @FXML
    private VBox container;

    @FXML
    void uploadCmnt(ActionEvent event) {
        if(cmntBody.getText().length()==0){
            String title="FAILED";
            String message="COMMENT CANNOT BE EMPTY\n";
            TrayNotification tray=new TrayNotification();
            AnimationType type= AnimationType.POPUP;
            tray.setAnimationType(type);
            tray.setTitle(title);
            tray.setMessage(message);
            tray.setNotificationType(NotificationType.WARNING);
            tray.showAndDismiss(Duration.seconds(1));
            return;
        }
        JDBC.insertComment(userid, postid, cmntBody.getText());
        String title="CONFIRMATION";
        String message=" YOUR COMMENT HAS BEEN UPLOADED\n ";
        TrayNotification tray=new TrayNotification();
        AnimationType type= AnimationType.POPUP;
        tray.setAnimationType(type);
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss(Duration.seconds(1));
        //System.out.println("post that I want to insert comment to -> "+postid);
        //System.out.println("user that I want to comment as -> "+userid);
        System.out.println("Comment inserted");
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

    public void initialize(URL url, ResourceBundle resourceBundle, String pID){
        List<Pair<String, String>> ll = JDBC.fetchComments(pID);
        System.out.println(ll.size());
        System.out.println(postid);
        for(int i=0; i<ll.size(); i++){
            Label userid = new Label(ll.get(i).getKey());
            userid.setStyle("-fx-text-fill : white;" +
                            "-fx-font-size : 18");
            TextArea comment = new TextArea(ll.get(i).getValue());
            comment.setStyle("-fx-font-size : 15");
            comment.setEditable(false);
            comment.setFocusTraversable(false);
            comment.setWrapText(true);

            VBox vBox = new VBox();
            vBox.getChildren().add(userid);
            vBox.getChildren().add(comment);
            vBox.setStyle("-fx-background-color : gray;");
            vBox.setPadding(new Insets(10));
            container.getChildren().add(vBox);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
