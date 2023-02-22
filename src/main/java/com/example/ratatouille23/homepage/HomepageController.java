package com.example.ratatouille23.homepage;

import com.example.ratatouille23.Model.Utente;
import com.example.ratatouille23.creaUtente.SchermataCreaUtente;
import com.example.ratatouille23.inserisciAvvisi.SchermataInserisciAvvisi;
import com.example.ratatouille23.personalizzaMenu.SchermataPersonalizzaMenu;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.cognitoidentityprovider.CognitoIdentityProviderClient;
import software.amazon.awssdk.services.cognitoidentityprovider.model.GroupType;
import software.amazon.awssdk.services.cognitoidentityprovider.model.ListGroupsRequest;
import software.amazon.awssdk.services.cognitoidentityprovider.model.ListGroupsResponse;

import java.io.IOException;
import java.util.List;

public class HomepageController {


    private SchermataPersonalizzaMenu personalizzaMenu = new SchermataPersonalizzaMenu();
    private SchermataCreaUtente creaUtente = new SchermataCreaUtente();
    private SchermataInserisciAvvisi inserisciAvvisi = new SchermataInserisciAvvisi();


    @FXML
    BorderPane borderPane;

    @FXML
    Label labelUsername;



    public void initialize(){
        labelUsername.setText(Utente.getUsername());
    }

    public void clickPulsantePersonalizzaMenu(ActionEvent event){
        try {
            borderPane.getChildren().remove(borderPane.getCenter());
            borderPane.setCenter(personalizzaMenu.apriSchermataPersonalizzaMenu(event));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void clickPulsanteCreaUtente(ActionEvent event){
        try {
            borderPane.getChildren().remove(borderPane.getCenter());
            borderPane.setCenter(creaUtente.apriSchermataCreaUtente(event));
        } catch (IOException e) {
            throw new RuntimeException(e);
        };
    }

    public void clickPulsanteInserisciAvvisi(ActionEvent event){
        try {
            borderPane.getChildren().remove(borderPane.getCenter());
            borderPane.setCenter(inserisciAvvisi.apriSchermataInserisciAvvisi(event));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
