package com.example.demo11;
//import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

import javax.mail.MessagingException;
import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public TextField txt_show;
    @FXML
    public static boolean state;
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
    @FXML
    private AnchorPane wrapper;

  //  String help;

// add the button to a container or scene
//public void initialize(){
//    txt_show.setVisible(false);
//    ibopen.setVisible(false);
//}
    @FXML
    protected void signupBtn(ActionEvent event) throws IOException {  // signup button in login page
        System.out.println("UP");
        String title="WELCOME";
        String message="LET'S SIGN UP FIRST";
        TrayNotification tray=new TrayNotification();
        AnimationType type= AnimationType.POPUP;
        tray.setAnimationType(type);
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(NotificationType.NOTICE);
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

        if(username.getText().isBlank() == true || password.getText().isBlank() == true) {
            String title="LOGIN FAILED";
            String message="Wrong username or password!!\n";
            TrayNotification tray=new TrayNotification();
            AnimationType type= AnimationType.POPUP;
            tray.setAnimationType(type);
            tray.setTitle(title);
            tray.setMessage(message);
            tray.setNotificationType(NotificationType.ERROR);
            tray.showAndDismiss(Duration.seconds(1));
         //  loginError.setText("Wrong username or password!!");
            //createNotification();
        }else {
            String usrname = username.getText();
            String pass = password.getText();
            if(JDBC.checkEntry(usrname, pass) == true) {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("welcomepage.fxml"));
                root = loader.load();

//                tray.setMessage(title);
//                tray.setNotificationType(NotificationType.SUCCESS);
//                tray.showAndDismiss(Duration.millis(300));

                welcomepageController wc = loader.getController();
                String userID = JDBC.getUserId(username.getText());
                wc.initialize(null, null, username.getText(), userID);


                wc.setData(username.getText(), userID);
                stage = (Stage) ((Node)event.getSource()).getScene().getWindow();

                stage.setResizable(false);
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                String title="WELCOME TO LIBRA ❤";
                String message= "LOGGED IN AS :"+"'"+username.getText()+"'"+"\n";
                TrayNotification tray=new TrayNotification();
                AnimationType type= AnimationType.POPUP;
                tray.setAnimationType(type);
                tray.setTitle(title);
                tray.setMessage(message);
                tray.setNotificationType(NotificationType.SUCCESS);
                tray.showAndDismiss(Duration.seconds(1));


//
//
             }else{
                String title="LOGIN FAILED";
                String message="Wrong username or password!!\n";
                TrayNotification tray=new TrayNotification();
                AnimationType type= AnimationType.POPUP;
                tray.setAnimationType(type);
                tray.setTitle(title);
                tray.setMessage(message);
                tray.setNotificationType(NotificationType.ERROR);
                tray.showAndDismiss(Duration.seconds(1));
            }
        }
    }

    @FXML
    protected void signup(ActionEvent event) throws SQLException, IOException, NoSuchAlgorithmException, MessagingException {
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
            String title="SIGN UP FAILED";
            String message="Password must be identical for both fields!\n";
            TrayNotification tray=new TrayNotification();
            AnimationType type= AnimationType.POPUP;
            tray.setAnimationType(type);
            tray.setTitle(title);
            tray.setMessage(message);
            tray.setNotificationType(NotificationType.ERROR);
            tray.showAndDismiss(Duration.seconds(1));
         //   signupError.setText("Password must be identical for both fields!");
        }
        else {
            if(JDBC.checkUsernameAndMail(username, mail) == false)
            {String title="SIGNUP FAILED";
            String message="Username or Email already exists\n";
            TrayNotification tray=new TrayNotification();
            AnimationType type= AnimationType.POPUP;
            tray.setAnimationType(type);
            tray.setTitle(title);
            tray.setMessage(message);
            tray.setNotificationType(NotificationType.ERROR);
            tray.showAndDismiss(Duration.seconds(1));}
                //signupError.setText("username or email already exists");
            else if(UTILITY.checkStudentId(id) == false)
            {String title="SIGNUP FAILED";
                String message="Student ID can contain numbers only!\n";
                TrayNotification tray=new TrayNotification();
                AnimationType type= AnimationType.POPUP;
                tray.setAnimationType(type);
                tray.setTitle(title);
                tray.setMessage(message);
                tray.setNotificationType(NotificationType.ERROR);
                tray.showAndDismiss(Duration.seconds(1));}
               // signupError.setText("Student ID can contain numbers only!");
            else if(UTILITY.checkEmail(mail) == false)
            {String title="SIGNUP FAILED";
                String message="Invalid Email !!\n";
                TrayNotification tray=new TrayNotification();
                AnimationType type= AnimationType.POPUP;
                tray.setAnimationType(type);
                tray.setTitle(title);
                tray.setMessage(message);
                tray.setNotificationType(NotificationType.ERROR);
                tray.showAndDismiss(Duration.seconds(1));}
                //signupError.setText("Invalid email !!!");
            else if(UTILITY.checkUsername(username)==false)
            {String title="SIGNUP FAILED";
                String message="username can contain only lowercase letters, numbers and underscore symbol\n";
                TrayNotification tray=new TrayNotification();
                AnimationType type= AnimationType.POPUP;
                tray.setAnimationType(type);
                tray.setTitle(title);
                tray.setMessage(message);
                tray.setNotificationType(NotificationType.ERROR);
                tray.showAndDismiss(Duration.seconds(1));}
               // signupError.setText("username can contain only lowercase letters, numbers and underscore symbol");
            else if(UTILITY.checkPassword(pas1) == false)
            {
                String title="SIGNUP FAILED";
                String message="Password is not Strong Enough!\n";
                TrayNotification tray=new TrayNotification();
                AnimationType type= AnimationType.POPUP;
                tray.setAnimationType(type);
                tray.setTitle(title);
                tray.setMessage(message);
                tray.setNotificationType(NotificationType.ERROR);
                tray.showAndDismiss(Duration.seconds(1));}
               // signupError.setText("Password is not Strong Enough!");
            else {
                pas1 = UTILITY.encrypt(pas1);

                FXMLLoader loader = new FXMLLoader(getClass().getResource("otp.fxml"));
                Parent rt = loader.load();
                Otp otp = loader.getController();
                otp.initialize(null, null);
                otp.setData(fn, ln, id, department, mail, username, pas1);
                Stage stg = (Stage) ((Node)event.getSource()).getScene().getWindow();
                stg.setResizable(false);
                Scene scn = new Scene(rt);
                stg.setScene(scn);
                stg.show();


            }
        }
    }
    @FXML
    protected void signupcancel(ActionEvent event) throws IOException{
        System.out.println("Cancel Button Pressed!!");
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Sign Up Cancellation");
        alert.setContentText("Do you want to cancel signing up?");
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

    public void restPass(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("forgetPass.fxml"));
        Parent rt = loader.load();
        ForgetPass forgetPass = loader.getController();
        forgetPass.initialize(null, null);

        Stage stg = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stg.setResizable(false);
        Scene scn = new Scene(rt);
        stg.setScene(scn);
        stg.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //txt_show.setVisible(false);

    }

//    public void notifii(ActionEvent actionEvent) {
//
//        createNotification();
//    }
}