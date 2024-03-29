package com.example.demo11;

import Model.postUnit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Structure implements Initializable {
    public Button unsave;
    @FXML
    private Label category;
    @FXML
    private Label cmntCount;
    @FXML
    private Button deleteBtn1;
    @FXML
    private Label date;
    @FXML
    private ToggleButton dislikeBtn;
    @FXML
    private Label dislikeCount;
    @FXML
    private ImageView dislikeImg;
    @FXML
    private ToggleButton likeBtn;
    @FXML
    private Button savebutton;
    @FXML
    private Label likeCount;
    @FXML
    private ImageView likeImg;
    @FXML
    private TextArea post_body;
    @FXML
    private Label user_id;
    @FXML
    private Label postId;

    @FXML
    void onclicksave(ActionEvent event) {

        String title="SAVED CONFIRM";
        String message=""+"'"+postId.getText()+"'"+" POST ID HAS BEEN SAVED\n ";
        TrayNotification tray=new TrayNotification();
        AnimationType type= AnimationType.POPUP;
        tray.setAnimationType(type);
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss(Duration.seconds(2));
        System.out.println(welcomepageController.USERID);
         JDBC.savingpost(welcomepageController.USERID,postId.getText());
    }

    @FXML
     void unsaveButton(ActionEvent actionEvent) {
        JDBC.unsavingPost(postId.getText());


    }
    @FXML
    void opendeleteWindow(ActionEvent event) throws IOException {
        String title="DELETE CONFIRM";
        String message=""+"'"+postId.getText()+"'"+" POST ID HAS BEEN DELETED\n ";
        TrayNotification tray=new TrayNotification();
        AnimationType type= AnimationType.POPUP;
        tray.setAnimationType(type);
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss(Duration.seconds(2));
        System.out.println("hi");
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Deleting Post");
        alert.setContentText("Do you want to delete the post?");
        if(alert.showAndWait().get() == ButtonType.OK) {
            JDBC.deletingPost(postId.getText());
            FXMLLoader loader = new FXMLLoader(getClass().getResource("profile.fxml"));
            Parent root = loader.load();
            welcomepageController wc = new welcomepageController();
            wc.profilepage(event, welcomepageController.USERNAME, welcomepageController.USERID);
        }


    }
    @FXML
    void openCmntWindow(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("commentPage.fxml"));
        Parent root = loader.load();
        CommentPage cp = loader.getController();
        cp.initialize(null, null, postId.getText());
        CommentPage.postid =  postId.getText();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void dislikeBtnClick(ActionEvent event) throws IOException {
        String title="CONFIRM";
        String message="YOU HAVE REACTED IN THE POST\n"+"POST ID:"+"'"+postId+"'";
        TrayNotification tray=new TrayNotification();
        AnimationType type= AnimationType.POPUP;
        tray.setAnimationType(type);
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss(Duration.seconds(1));
        if(dislikeBtn.isSelected()==true)
        {
            Image image = new Image(UTILITY.getDisikeFillImg());
            dislikeImg.setImage(image);
            JDBC.insertDislike(welcomepageController.USERID, postId.getText());
            welcomepageController wc = new welcomepageController();
            wc.homepage(event, welcomepageController.USERNAME, welcomepageController.USERID);
        }
        else {
            Image image = new Image(UTILITY.getDislikeImg());
            dislikeImg.setImage(image);
        }
        Image img = new Image(UTILITY.getLikeImg());
        likeImg.setImage(img);
    }


    @FXML
    void likeBtnClick(ActionEvent event) throws IOException {
        String title="CONFIRM";
        String message="YOU HAVE REACTED IN THE POST\n"+"POST ID:"+"'"+postId+"'";
        TrayNotification tray=new TrayNotification();
        AnimationType type= AnimationType.POPUP;
        tray.setAnimationType(type);
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss(Duration.seconds(1));
        if(likeBtn.isSelected()==true)
        {
            Image image = new Image(UTILITY.getLikeFillImg());
            likeImg.setImage(image);
            System.out.println(postId.getText());
            JDBC.insertLike(welcomepageController.USERID, postId.getText());

            welcomepageController wc = new welcomepageController();
            wc.homepage(event, welcomepageController.USERNAME, welcomepageController.USERID);
        }
        else {
            Image image = new Image(UTILITY.getLikeImg());
            likeImg.setImage(image);
        }
        Image img = new Image(UTILITY.getDislikeImg());
        dislikeImg.setImage(img);
    }


    public void settingData(postUnit p){
        user_id.setText(p.getUserid());
        category.setText(p.getCategory());
        date.setText(p.getDate());
        post_body.setText(p.getPostBody());
        likeCount.setText(String.valueOf(p.getLikeCount()));
        dislikeCount.setText(String.valueOf(p.getDislikeCount()));
        cmntCount.setText(String.valueOf(p.getCmntCount()));
        postId.setText(p.getPostId());
        Image image = new Image(p.getLikeImgUrl());
        likeImg.setImage(image);
        Image image1 = new Image(p.getDislikeImgUrl());
        dislikeImg.setImage(image1);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }



}
