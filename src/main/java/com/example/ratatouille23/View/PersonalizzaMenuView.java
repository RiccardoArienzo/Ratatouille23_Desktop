package com.example.ratatouille23.View;

import com.example.ratatouille23.Controller.HomepageController;
import com.example.ratatouille23.Controller.PersonalizzaMenuController;
import com.example.ratatouille23.Model.Utente;
import com.example.ratatouille23.ViewInterface;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;

import java.io.IOException;

public class PersonalizzaMenuView implements ViewInterface {

    @FXML
    private Accordion listaCategorie;
    private Node node;
    private PersonalizzaMenuController personalizzaMenuController;

    public PersonalizzaMenuView(){};


    @FXML
    public void initialize(){
        this.personalizzaMenuController = new PersonalizzaMenuController(this);
    }

    // Metodi di View Interface
    @Override
    public Node loadNode() throws IOException {
        return FXMLLoader.load(getClass().getResource("/personalizzaMenu/personalizza-menu.fxml"));
    }
    @Override
    public Node getNode(){
        return this.node;
    }
    @Override
    public void setNode(Node node) {
        this.node = node;
    }


    public void clickPulsanteAggiungiCategoria() {
        personalizzaMenuController.onPulsanteAggiungiCategoriaClicked();
    }



    public void clickPulsanteAggiungiPiatto() {
        personalizzaMenuController.onPulsanteAggiungiPiattoClicked();
    }

    @FXML
    public void setPersonalizzaMenuController(PersonalizzaMenuController personalizzaMenuController) {
        this.personalizzaMenuController = personalizzaMenuController;
    }

}





