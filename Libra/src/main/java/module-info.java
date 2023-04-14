module com.example.demo11 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires controlsfx;
    requires java.desktop;
    requires TrayTester;
    requires javafx.web;
    requires java.net.http;
    requires commons.net;
    requires org.apache.commons.net;
    requires java.mail;
    requires ojdbc10;


    opens com.example.demo11 to javafx.fxml;
    exports com.example.demo11;
}