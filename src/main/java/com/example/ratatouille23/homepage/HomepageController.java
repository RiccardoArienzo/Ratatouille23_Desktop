package com.example.ratatouille23.homepage;

import com.example.ratatouille23.creaUtente.CreaUtenteController;
import com.example.ratatouille23.personalizzaMenu.PersonalizzaMenuController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HomepageController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    private Parent root2;

    private PersonalizzaMenuController menuController ;

    public HomepageController(){
        FXMLLoader loaderPMC = new FXMLLoader(getClass().getResource("/personalizzaMenu/personalizza-menu.fxml"));
        try {
            root = loaderPMC.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        menuController = loaderPMC.getController();
    }


/*
    FXMLLoader loaderCUC = new FXMLLoader(getClass().getResource("/creaUtente/crea-utente.fxml"));
    root2 = loaderCUC.load();
    creautenteController = loaderCUC.getController();
    private CreaUtenteController creautenteController;

 */


    public void apriSchermataHome(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/homepage/homepage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void clickPulsantePersonalizzaMenu(ActionEvent event){
        try {
            menuController.apriSchermataPersonalizzaMenu(event);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
