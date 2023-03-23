package com.example.ratatouille23.View;
import com.example.ratatouille23.Controller.CreaUtenteController;
import com.example.ratatouille23.ViewInterface;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import software.amazon.awssdk.services.cognitoidentityprovider.CognitoIdentityProviderClient;
import software.amazon.awssdk.services.cognitoidentityprovider.model.ListGroupsResponse;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.cognitoidentityprovider.model.*;

import java.io.IOException;
import java.util.List;


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
    }

    // Metodi di ViewInterface
    @Override
    public Node loadNode() throws IOException {
        return FXMLLoader.load(getClass().getResource("/creaUtente/crea-utente.fxml"));
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
