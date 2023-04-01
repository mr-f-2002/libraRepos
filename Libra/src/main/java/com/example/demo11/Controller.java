package com.example.demo11;
//import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.net.URL;
import java.awt.Desktop;
import javafx.scene.control.Hyperlink;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
//import org.controlsfx.control.Notifications;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;
import java.net.URISyntaxException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Controller {
    public TextField txt_show;
    public ImageView ibopen;
    public ImageView ifclose;
    @FXML
    private Button signUp;
    @FXML
    private Button logIn;
    @FXML
    private Label loginError, signupError;
    @FXML
    private TextField username;
    @FXML
    private TextField firstName;
    @FXML
    private TextField sUsername;
    @FXML
    private TextField lastName;
    @FXML
    private TextField sId;
    @FXML
    private TextField dept;
    @FXML
    private TextField email;
    @FXML
    private String help;
    @FXML
    private PasswordField password, sPassword, sRepassword;
    @FXML
    private Stage stage;
    private Scene scene;
    @FXML
    private Parent root;
  //  String help;

// add the button to a container or scene
//public void initialize(){
//    txt_show.setVisible(false);
//    ibopen.setVisible(false);
//}
    @FXML
    protected void signupBtn(ActionEvent event) throws IOException {  // signup button in login page
        System.out.println("UP");
        String title="Sign In";
        String message="Hello";
        TrayNotification tray=new TrayNotification();
        AnimationType type= AnimationType.POPUP;
        tray.setAnimationType(type);
        tray.setTitle(title);
        tray.setMessage(title);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss(Duration.millis(300));
        Parent root = FXMLLoader.load(getClass().getResource("signup.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setResizable(false);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


 @FXML
    public void createNotification(){
     String title="Sign In";
     String message="Hello";
     TrayNotification tray=new TrayNotification();
     AnimationType type= AnimationType.POPUP;
     tray.setAnimationType(type);
     tray.setTitle(title);
     tray.setMessage(title);
     tray.setNotificationType(NotificationType.SUCCESS);
     tray.showAndDismiss(Duration.millis(300));
     System.out.println("hd");
//     Notifications notifications=Notifications.create();
//     notifications.text("LOGIN SUCCESSFUL ❤");
//     notifications.title("WELCOME TO LIBRA");
//     notifications.darkStyle();
//     //  notifications.showConfirm();
//     notifications.position(Pos.BASELINE_CENTER);
//     notifications.hideAfter(Duration.seconds(3));
//     notifications.show();

 }
        @FXML
    protected void loginBtn(ActionEvent event) throws IOException, SQLException {

            String title="Sign In";
            String message="Hello";
            TrayNotification tray=new TrayNotification();
            AnimationType type= AnimationType.POPUP;
            tray.setAnimationType(type);
            tray.setTitle(title);
            tray.setMessage(title);
            tray.setNotificationType(NotificationType.SUCCESS);
            tray.showAndDismiss(Duration.millis(300));

        if(username.getText().isBlank() == true || password.getText().isBlank() == true) {
             title="Sign In";
             message="Hello";
//            TrayNotification tray=new TrayNotification();
//            AnimationType type= AnimationType.POPUP;
            tray.setAnimationType(type);
            tray.setTitle(title);
            tray.setMessage(title);
            tray.setNotificationType(NotificationType.SUCCESS);
            tray.showAndDismiss(Duration.millis(300));
           loginError.setText("Wrong username or password!!");
            //createNotification();
        }else {
            String usrname = username.getText();
            String pass = password.getText();
            if(JDBC.checkEntry(usrname, pass) == true) {
                title="Sign In";
                message="Hello";
//            TrayNotification tray=new TrayNotification();
//            AnimationType type= AnimationType.POPUP;
                tray.setAnimationType(type);
                tray.setTitle(title);
                tray.setMessage(title);
                tray.setNotificationType(NotificationType.SUCCESS);
                tray.showAndDismiss(Duration.millis(300));

                FXMLLoader loader = new FXMLLoader(getClass().getResource("welcomepage.fxml"));
                root = loader.load();
                // createNotification();

                title="Sign In";
                message="Hello";
//            TrayNotification tray=new TrayNotification();
//            AnimationType type= AnimationType.POPUP;
                tray.setAnimationType(type);
                tray.setTitle(title);
                tray.setMessage(title);
                tray.setNotificationType(NotificationType.SUCCESS);
                tray.showAndDismiss(Duration.millis(300));

                welcomepageController wc = loader.getController();
                String userID = JDBC.getUserId(username.getText());
                wc.initialize(null, null, username.getText(), userID);
                title="Sign In";
                message="Hello";
//            TrayNotification tray=new TrayNotification();
//            AnimationType type= AnimationType.POPUP;
                tray.setAnimationType(type);
                tray.setTitle(title);
                tray.setMessage(title);
                tray.setNotificationType(NotificationType.SUCCESS);
                tray.showAndDismiss(Duration.millis(300));

                wc.setData(username.getText(), userID);
                stage = (Stage) ((Node)event.getSource()).getScene().getWindow();

                stage.setResizable(false);
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                title="Sign In";
                message="Hello";
//            TrayNotification tray=new TrayNotification();
//            AnimationType type= AnimationType.POPUP;
                tray.setAnimationType(type);
                tray.setTitle(title);
                tray.setMessage(title);
                tray.setNotificationType(NotificationType.SUCCESS);
                tray.showAndDismiss(Duration.millis(300));

//
//
             }else{
                loginError.setText("Wrong username or password!!");
            }
        }
    }

    @FXML
    protected void signup(ActionEvent event) throws SQLException, IOException {
     //   createNotification();
        //signup button in signup page
        System.out.println("Signup Button Pressed");
        String fn = firstName.getText();
        String ln = lastName.getText();
        String id = sId.getText();
        String department = dept.getText();
        String mail = email.getText();
        String username = sUsername.getText();
        String pas1 = sPassword.getText();
        String pas2 = sRepassword.getText();
        if(pas1.equals(pas2)==false) {

            signupError.setText("Password must be identical for both fields!");
        }
        else {
            if(JDBC.checkUsernameAndMail(username, mail) == false)
                signupError.setText("username or email already exists");
            else if(UTILITY.checkStudentId(id) == false)
                signupError.setText("Student ID can contain numbers only!");
            else if(UTILITY.checkEmail(mail) == false)
                signupError.setText("Invalid email !!!");
            else if(UTILITY.checkUsername(username)==false)
                signupError.setText("username can contain only lowercase letters, numbers and underscore symbol");
            else if(UTILITY.checkPassword(pas1) == false)
                signupError.setText("Password is not Strong Enough!");
            else {
                String title="Sign In Successful";
                String message="Hello";
                TrayNotification tray=new TrayNotification();
                AnimationType type= AnimationType.POPUP;
                tray.setAnimationType(type);
                tray.setTitle(title);
                tray.setMessage(title);
                tray.setNotificationType(NotificationType.SUCCESS);
                tray.showAndDismiss(Duration.millis(300));

                pas1 = UTILITY.encrypt(pas1);
                JDBC.EnterData(fn, ln, id, department, mail, username, pas1);
                Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setResizable(false);
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        }
    }
    @FXML
    protected void signupcancel(ActionEvent event) throws IOException{
        System.out.println("Cancel Button Pressed!!");
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Sign Up Cancellation");
        alert.setContentText("Do you want to quit signing up?");
        if(alert.showAndWait().get() == ButtonType.OK) {
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setResizable(false);
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

//    public void Hide_pass(KeyEvent keyEvent) {
//    }

//    public void show_pass(KeyEvent keyEvent) {
//    }
//
//    public void close_eye(MouseEvent mouseEvent) {
//    }
//
//    public void open_eye(MouseEvent mouseEvent) {
//    }




    public void Hide_pass(KeyEvent keyEvent) {
     help=password.getText();
    txt_show.setText(help);
        System.out.println("pass in hide: " + help);
    }
    public void show_pass(KeyEvent keyEvent) {
        help=txt_show.getText();
        help=txt_show.getText();
        password.setText(help);
        System.out.println("pass in show: " + help);

    }
    public void close_eye(MouseEvent mouseEvent) {

    password.setVisible(false);
    ibopen.setVisible(true);
    ifclose.setVisible(false);
    txt_show.setVisible(true);

    }

    public void open_eye(MouseEvent mouseEvent) {
        txt_show.setVisible(false);
        ibopen.setVisible(false);
        ifclose.setVisible(true);
        password.setVisible(true);


    }

//    public void notifii(ActionEvent actionEvent) {
//
//        createNotification();
//    }
}