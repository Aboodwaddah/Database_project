package com.example.databaseproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage.setScene(new Scene(root,850,500));
        stage.setTitle("Hello!");
        stage.setResizable(true);
        stage.initStyle(StageStyle.DECORATED);
        stage.show();

    }

    public static void main(String[] args)
    {
        launch();
        ////wqelmm pwe owjg erql goje g
    }
}