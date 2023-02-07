package com.example.ratatouille23.personalizzaMenu;

import com.example.ratatouille23.homepage.Homepage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SchermataNuovoPiatto extends Application {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Homepage.class.getResource("/personalizzaMenu/personalizza-menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("A capocchj");
        stage.setScene(scene);
        stage.show();
    }

    public void apriSchermataNuovoPiatto(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/personalizzaMenu/nuovo-piatto.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
