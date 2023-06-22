package com.example.ratatouille23;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;


import java.io.IOException;

public class Main extends Application {

    private static Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {

        Main.primaryStage = stage;

//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/login.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gestisci-ordinazioni.fxml"));

//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/registra-ordinazioni.fxml"));

        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Ratatouille23");
        stage.setScene(scene);
//        stage.setFullScreen(true);
//        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        stage.show();
    }


    public static Stage getPrimaryStage() {
        return primaryStage;
    }
}
