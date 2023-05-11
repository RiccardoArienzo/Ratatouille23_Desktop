package com.example.ratatouille23.View;

import com.example.ratatouille23.Controller.InserisciAvvisiController;
import com.example.ratatouille23.ViewInterface;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;

import java.io.IOException;

public class InserisciAvvisiView implements ViewInterface {


    @FXML
    private TextArea corpoAvviso;
    @FXML
    private Button btnInvia;
    @FXML
    private TextField oggettoAvviso;

    private Node node;
    private InserisciAvvisiController inserisciAvvisiController;

    // Costruttori

    public InserisciAvvisiView() {}


    // Metodi

    @FXML
    public void initialize(){
        this.inserisciAvvisiController = new InserisciAvvisiController(this);

        btnInvia.disableProperty().bind(
                Bindings.createBooleanBinding(
                        () -> oggettoAvviso.getText().isEmpty()  || corpoAvviso.getText().isEmpty(),
                        oggettoAvviso.textProperty(),
                        corpoAvviso.textProperty()
                )
        );
    }

    // Metodi di ViewInterface

    @Override
    public Node getNode(){
        return this.node;
    }

    @Override
    public void setNode(Node node){
        this.node = node;
    }


    // Event handler

    public boolean verificaCampiVuoti(){
        if (corpoAvviso.getText().isEmpty() && oggettoAvviso.getText().isEmpty()){
            return true;
        } else {
            return false;
        }
    }

    public void clickBtnInvia(){
        inserisciAvvisiController.onBtnInviaClicked();
    }


    public void setInserisciAvvisiController(InserisciAvvisiController inserisciAvvisiController) {
        this.inserisciAvvisiController = inserisciAvvisiController;
    }

    public TextArea getCorpoAvviso() {
        return corpoAvviso;
    }


    public TextField getOggettoAvviso() {
        return oggettoAvviso;
    }

}
