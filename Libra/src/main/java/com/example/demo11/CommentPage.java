package com.example.demo11;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CommentPage implements Initializable {
    private String userid = Structure.userID;
    public static String postid;
    @FXML
    private TextArea cmntBody;


    @FXML
    private VBox container;

    @FXML
    void uploadCmnt(ActionEvent event) {
        System.out.println("post that I want to insert comment to -> "+postid);
        System.out.println("user that I want to comment as -> "+userid);
        JDBC.insertComment(userid, postid, cmntBody.getText());
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
            Label comment = new Label(ll.get(i).getValue());
            comment.setStyle("-fx-text-fill : white;" +
                             "-fx-font-size : 15");
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
