package com.example.ratatouille23.homepage;

import com.example.ratatouille23.creaUtente.CreaUtenteController;
import com.example.ratatouille23.personalizzaMenu.PersonalizzaMenuController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Homepage extends Application {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    Button buttonPersonalizzaMenu;

    @FXML
    Button buttonCreaUtente;

    HomepageController homepageController;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Homepage.class.getResource("/homepage/homepage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

    }

}
