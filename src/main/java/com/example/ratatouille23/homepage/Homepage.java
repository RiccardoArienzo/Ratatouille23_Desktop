package com.example.ratatouille23.homepage;

import com.example.ratatouille23.creaUtente.CreaUtenteController;
import com.example.ratatouille23.personalizzaMenu.PersonalizzaMenuController;
import javafx.application.Application;
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

    PersonalizzaMenuController personalizzamenuController;

    CreaUtenteController creautenteController;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {

        // Istanziamo i controller

        FXMLLoader loaderHMC = new FXMLLoader(getClass().getResource("/homepage/homepage.fxml"));
        root = loaderHMC.load();
        PersonalizzaMenuController homepageController = loaderHMC.getController();

        FXMLLoader loaderPMC = new FXMLLoader(getClass().getResource("/personalizzaMenu/personalizza-menu.fxml"));
        root = loaderPMC.load();
        PersonalizzaMenuController personalizzaMenuController = loaderPMC.getController();

        FXMLLoader loaderCU = new FXMLLoader(getClass().getResource("/creaUtente/crea-utente.fxml"));
        root = loaderCU.load();
        CreaUtenteController creaUtenteController = loaderCU.getController();

        // Istanzio la scena

        FXMLLoader fxmlLoader = new FXMLLoader(Homepage.class.getResource("/homepage/homepage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

    }


    // Action Listener

    public void clickButtonPersonalizzaMenu(){


    }


}
