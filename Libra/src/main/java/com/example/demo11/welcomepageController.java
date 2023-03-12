package com.example.demo11;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class welcomepageController implements Initializable {

    @FXML
    private Button addPost;

    @FXML
    private VBox container;

    @FXML
    private Button home;

    @FXML
    private Button myProfile;

    @FXML
    private TextField searchBar;

    @FXML
    private Button searchBtn;

    @FXML
    private Label userName;

    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;

    @FXML
    void addPost(ActionEvent event) throws IOException {
        System.out.println("UP");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("newPost.fxml"));
        Parent root = loader.load();
        NewPost np = loader.getController();
        np.setData(userName.getText());

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void loadHome(ActionEvent event) {

    }

    @FXML
    void loadProfile(ActionEvent event) {

    }

    @FXML
    void searchPost(ActionEvent event) {

    }
    @FXML
    void setData(String s)
    {
        userName.setText(s);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<setter> list = new ArrayList<>(set());
        for(int i=0; i<list.size(); i++){
            Label l = new Label(list.get(i).getUserName());
            l.setWrapText(true);
            TextArea tf = new TextArea(list.get(i).getPostContent());
            tf.setMaxWidth(870);
            tf.setMinHeight(250.0);
            tf.setWrapText(true);
            Button bt = new Button("LIKE");
            Button bt2 = new Button("disLIKE");
            Button bt3 = new Button("Comment");
            container.getChildren().add(l);
            container.getChildren().add(tf);
            HBox btns = new HBox(bt, bt2, bt3);
            container.getChildren().add(btns);
        }
    }

    public List<setter> set(){
        List<setter> setPost = new ArrayList<>();
        setter set = new setter();
        set.setUserName("nahin123");
        set.setPostContent("This is a dummy post");
        setPost.add(set);

        set = new setter();
        set.setUserName("admin");
        set.setPostContent("NO ADMIN REQUIRED> ONLY SIUM IS REAL *_*");
        setPost.add(set);

        set = new setter();
        set.setUserName("babul");
        set.setPostContent("Babul is NOT BULBUL  ^_^");
        setPost.add(set);

        set = new setter();
        set.setUserName("mia");
        set.setPostContent("It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!! ");
        setPost.add(set);

        set = new setter();
        set.setUserName("mia");
        set.setPostContent("It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!!");
        setPost.add(set);

        set = new setter();
        set.setUserName("mia");
        set.setPostContent("It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!!");
        setPost.add(set);

        set = new setter();
        set.setUserName("mia");
        set.setPostContent("It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!!");
        setPost.add(set);

        set = new setter();
        set.setUserName("mia");
        set.setPostContent("It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!!");
        setPost.add(set);

        set = new setter();
        set.setUserName("mia");
        set.setPostContent("It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!!");
        setPost.add(set);

        set = new setter();
        set.setUserName("mia");
        set.setPostContent("It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!!");
        setPost.add(set);

        set = new setter();
        set.setUserName("mia");
        set.setPostContent("It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!!");
        setPost.add(set);

        set = new setter();
        set.setUserName("mia");
        set.setPostContent("It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!!");
        setPost.add(set);

        set = new setter();
        set.setUserName("mia");
        set.setPostContent("It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!!");
        setPost.add(set);

        set = new setter();
        set.setUserName("mia");
        set.setPostContent("It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!!");
        setPost.add(set);

        set = new setter();
        set.setUserName("mia");
        set.setPostContent("It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!!");
        setPost.add(set);

        set = new setter();
        set.setUserName("mia");
        set.setPostContent("It is Muhammad Ishrak Abedin, Not MIA KHALIFA!!!!");
        setPost.add(set);

        return setPost;
    }
}

