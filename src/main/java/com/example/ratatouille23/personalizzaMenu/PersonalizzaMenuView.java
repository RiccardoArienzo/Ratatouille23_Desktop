package com.example.ratatouille23.personalizzaMenu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Optional;

public class PersonalizzaMenuView {

    @FXML
    Accordion listaCategorie;

    PersonalizzaMenuController personalizzaMenuController;


    // Carica nodo schermata
    public Node caricaNodoPersonalizzaMenu() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/personalizzaMenu/personalizza-menu.fxml"));
        return loader.load();
    }


    public void clickPulsanteAggiungiCategoria() {
        personalizzaMenuController.onPulsanteAggiungiCategoriaClicked();
    }


    public void clickPulsanteAggiungiPiatto() {
        personalizzaMenuController.onPulsanteAggiungiPiattoClicked();
    }

}





