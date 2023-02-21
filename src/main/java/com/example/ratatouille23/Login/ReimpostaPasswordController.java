package com.example.ratatouille23.Login;

import com.example.ratatouille23.Model.Utente;
import com.example.ratatouille23.homepage.Homepage;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.cognitoidentityprovider.CognitoIdentityProviderClient;
import software.amazon.awssdk.services.cognitoidentityprovider.model.*;

public class ReimpostaPasswordController {


    @FXML


    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    TextField vecchiaPasswordTextField;

    @FXML
    TextField nuovaPasswordTextField;

    @FXML
    Button pulsanteConferma;


    private Homepage home = new Homepage();

    public void initialize() {
        pulsanteConferma.disableProperty().bind(
                Bindings.createBooleanBinding(
                        () -> vecchiaPasswordTextField.getText().isEmpty() || nuovaPasswordTextField.getText().isEmpty(),
                        vecchiaPasswordTextField.textProperty(),
                        nuovaPasswordTextField.textProperty()
                )
        );

    }

    public void clickPulsanteConfermaNuovaPassword(ActionEvent event) {
        try {
            if (verificaPasswordUguali()) {
                Utente.ReimpostaPasswordPrimoAccesso(nuovaPasswordTextField.getText());
                home.apriSchermataHome(event);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


        public boolean verificaPasswordUguali() {
            if (vecchiaPasswordTextField.getText().equals(nuovaPasswordTextField.getText())){
                return true;
            } else {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Password errata");
                alert.setHeaderText("Le due password non coincidono. Inserire nuovamente le password.");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                  //
                }
                return false;
            }
        }

}