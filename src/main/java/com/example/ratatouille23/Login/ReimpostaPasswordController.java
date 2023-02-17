package com.example.ratatouille23.Login;

import com.example.ratatouille23.homepage.Homepage;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

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

    }

    public static void changeTempPassword(CognitoIdentityProviderClient identityProviderClient, String clientId, String username, String newPassword, String poolId){
        try {
            AdminSetUserPasswordRequest passwordRequest = AdminSetUserPasswordRequest.builder()
                    .username(username)
                    .userPoolId(poolId)
                    .password(newPassword)
                    .permanent(true)
                    .build();

            identityProviderClient.adminSetUserPassword(passwordRequest);
            System.out.println("The password was successfully changed");

        } catch(CognitoIdentityProviderException e) {
            System.err.println(e.awsErrorDetails().errorMessage());
            System.exit(1);
        }
    }
}