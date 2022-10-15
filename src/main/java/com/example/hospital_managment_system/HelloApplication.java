package com.example.hospital_managment_system;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;


public class HelloApplication extends Application {


    @Override
    public void start(Stage stage)  {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("interface.fxml"));
//            FXMLLoader fxmlLoader = new FXMLLoader(new File("C:\\Users\\User\\Documents\\hospital managment system\\src\\main\\resources\\com\\example\\hospital_managment_system\\interface.fxml").toURI().toURL());
//            fxmlLoader.setRoot(new AnchorPane());
//            Parent root = fxmlLoader.load();
            AnchorPane root = (AnchorPane)fxmlLoader.load();
            Scene scene = new Scene(root, 1260, 680);
            scene.getStylesheets().add("style.css");
//            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());
            stage.setTitle("Dashboard");
            stage.setScene(scene);
            stage.show();
        }catch (IOException e){
           e.getCause();
        }

    }

    public static void main(String[] args) {
        launch();

    }
}