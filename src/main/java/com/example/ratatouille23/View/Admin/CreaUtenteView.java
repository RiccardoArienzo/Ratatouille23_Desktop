package com.example.ratatouille23.View.Admin;
import com.example.ratatouille23.Controller.Amministratore.CreaUtenteController;
import com.example.ratatouille23.ViewInterface;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;

import java.io.IOException;


public class CreaUtenteView implements ViewInterface {

    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private ComboBox tipoDipendenteComboBox;
    @FXML
    private Button btnRegistraUtente;

    private Node node;
    private CreaUtenteController creaUtenteController;

    public CreaUtenteView(){}


    @FXML
    public void initialize() {
        this.creaUtenteController = new CreaUtenteController(this);

        btnRegistraUtente.disableProperty().bind(
                Bindings.createBooleanBinding(
                        () -> usernameTextField.getText().isEmpty() || emailTextField.getText().isEmpty() || tipoDipendenteComboBox.getValue() == null,
                        usernameTextField.textProperty(),
                        emailTextField.textProperty(),
                        tipoDipendenteComboBox.valueProperty()
                )
        );

        creaUtenteController.fillGroupsCombobox();
    }

    // Metodi di ViewInterface
    @Override
    public Node loadNode() throws IOException {
        return FXMLLoader.load(getClass().getResource("/crea-utente.fxml"));
    }

    @Override
    public Node getNode(){
        return this.node;
    }

    @Override
    public void setNode(Node node){
        this.node = node;
    }




    public boolean verificaCampiVuoti() {
        return creaUtenteController.verificaCampiVuoti();
    }


    public void clickBtnRegistraUtente(){
        creaUtenteController.onBtnRegistraUtenteClicked();
    }



    // Utility

    public String getEmailText(){
        return this.emailTextField.getText();
    }

    public String getUsernameText(){
        return this.usernameTextField.getText();
    }

    // Getter e Setter


    public ComboBox getTipoDipendenteComboBox() {
        return tipoDipendenteComboBox;
    }
}
