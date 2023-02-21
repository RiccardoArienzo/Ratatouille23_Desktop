package com.example.ratatouille23.Login;

import com.example.ratatouille23.Model.Utente;
import com.example.ratatouille23.Utils.CognitoSettings;
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
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.cognitoidentityprovider.CognitoIdentityProviderClient;
import software.amazon.awssdk.services.cognitoidentityprovider.model.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public class LoginController {

    @FXML
    TextField userNameTextField;

    @FXML
    TextField passwordTextField;

    @FXML
    Button pulsanteLogin;


    private Stage stage;
    private Scene scene;
    private Parent root;


    // Schermate
    private Homepage home = new Homepage();
    private SchermataReimpostaPassword reimpostaPassword = new SchermataReimpostaPassword();


    public void initialize() {
        pulsanteLogin.disableProperty().bind(
                Bindings.createBooleanBinding(
                        () -> userNameTextField.getText().isEmpty() || passwordTextField.getText().isEmpty(),
                        userNameTextField.textProperty(),
                        passwordTextField.textProperty()
                )
        );

    }


    public void clickPulsanteLogin(ActionEvent event) {
        try {
            if (Utente.Login(userNameTextField.getText(), passwordTextField.getText()) == null) {
                home.apriSchermataHome(event);
            } else {
                reimpostaPassword.apriSchermataReimpostaPassword(event);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CognitoIdentityProviderException e) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Conferma");
            alert.setHeaderText(e.awsErrorDetails().errorMessage());
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                //
            }
        }
    }
}




