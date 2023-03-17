package com.example.demo11;

import Model.postUnit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Structure implements Initializable {
    @FXML private Label category;
    @FXML private Label cmntCount;
    @FXML private Label date;
    @FXML private ToggleButton dislikeBtn;
    @FXML private Label dislikeCount;
    @FXML private ImageView dislikeImg;
    @FXML private ToggleButton likeBtn;
    @FXML private Label likeCount;
    @FXML private ImageView likeImg;
    @FXML private TextArea post_body;
    @FXML private Label user_id;
    @FXML private Label postId;
    public static String userID;
    @FXML
    void openCmntWindow(ActionEvent event) {

    }


    @FXML
    void dislikeBtnClick(ActionEvent event) {
        if(dislikeBtn.isSelected()==true)
        {
            Image image = new Image("C:\\Users\\Nahin\\Desktop\\libraRepos\\Libra\\src\\main\\resources\\com\\example\\demo11\\dislikeFill.png");
            dislikeImg.setImage(image);
            JDBC.insertDislike(user_id.getText(), postId.getText());
        }
        else {
            Image image = new Image("C:\\Users\\Nahin\\Desktop\\libraRepos\\Libra\\src\\main\\resources\\com\\example\\demo11\\dislike.png");
            dislikeImg.setImage(image);
        }
        Image img = new Image("C:\\Users\\Nahin\\Desktop\\libraRepos\\Libra\\src\\main\\resources\\com\\example\\demo11\\like.png");
        likeImg.setImage(img);
    }

    @FXML
    void likeBtnClick(ActionEvent event) throws IOException {
        if(likeBtn.isSelected()==true)
        {
            Image image = new Image("C:\\Users\\Nahin\\Desktop\\libraRepos\\Libra\\src\\main\\resources\\com\\example\\demo11\\likeFill.png");
            likeImg.setImage(image);
            System.out.println(postId.getText());
            //System.out.println("the post ID is : " + this.postId.getText());
            JDBC.insertLike(userID, postId.getText());
        }
        else {
            Image image = new Image("C:\\Users\\Nahin\\Desktop\\libraRepos\\Libra\\src\\main\\resources\\com\\example\\demo11\\like.png");
            likeImg.setImage(image);
        }
        Image img = new Image("C:\\Users\\Nahin\\Desktop\\libraRepos\\Libra\\src\\main\\resources\\com\\example\\demo11\\dislike.png");
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
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
