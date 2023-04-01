module com.example.demo11 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires controlsfx;
    requires java.desktop;
    requires javafx.web;
    requires TrayTester;


    opens com.example.demo11 to javafx.fxml;
    exports com.example.demo11;
}