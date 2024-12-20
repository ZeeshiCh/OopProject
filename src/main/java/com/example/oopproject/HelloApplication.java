package com.example.oopproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class HelloApplication extends Application {
    public static Stage stage1;
    @Override

    public void start(Stage stage) throws IOException {
        stage1=stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        URL url = HelloApplication.class.getResource("/com/example/oopproject/Picture/Butt.jpg");
        assert url != null;
        Image image = new Image(url.openStream());
        stage1.getIcons().add(image);
        stage1.setTitle("Shahi Carpets");

        stage1.setScene(scene);
        stage1.setResizable(false);
        stage1.show();
    }

    public static void main(String[] args) {
        launch();


    }
}