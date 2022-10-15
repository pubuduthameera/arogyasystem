module com.example.hospital_managment_system {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.hospital_managment_system to javafx.fxml;
    exports com.example.hospital_managment_system;
}