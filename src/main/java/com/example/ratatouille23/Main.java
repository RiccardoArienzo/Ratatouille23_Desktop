package com.example.ratatouille23;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/homepage-admin.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Ratatouille23");
        stage.setScene(scene);
        stage.show();
    }
}
