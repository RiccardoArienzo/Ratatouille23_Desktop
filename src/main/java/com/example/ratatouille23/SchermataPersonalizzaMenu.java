package com.example.ratatouille23;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SchermataPersonalizzaMenu extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HomePage.class.getResource("personalizza-menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("A capocchj");
        stage.setScene(scene);
        stage.show();

    }
}
