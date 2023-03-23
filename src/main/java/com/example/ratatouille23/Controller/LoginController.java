package com.example.ratatouille23.Controller;

import com.example.ratatouille23.View.LoginView;
import com.example.ratatouille23.View.ReimpostaPasswordView;
import com.example.ratatouille23.Model.Utente;
import com.example.ratatouille23.View.HomepageView;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import software.amazon.awssdk.services.cognitoidentityprovider.model.CognitoIdentityProviderException;

import java.io.IOException;
import java.util.Optional;

public class LoginController {

    private LoginView loginView;
    private HomepageView homepage;
    private ReimpostaPasswordView reimpostaPassword;

    public LoginController() {}

    public void onPulsanteLoginClicked() {
        try {
            if (Utente.Login(loginView.getUsernameText(), loginView.getPasswordText()) == null) {
                homepage.apriSchermataHome();
            } else {
                reimpostaPassword.apriSchermataReimpostaPassword();
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
