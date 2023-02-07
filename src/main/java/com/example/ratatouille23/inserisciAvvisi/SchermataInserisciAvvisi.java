package com.example.ratatouille23.inserisciAvvisi;

import com.example.ratatouille23.homepage.Homepage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SchermataInserisciAvvisi extends Application {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Homepage.class.getResource("/inserisciAvvisi/inserisci-avvisifxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public void apriSchermataInserisciAvvisi(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/inserisciAvvisi/inserisci-avvisi.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
