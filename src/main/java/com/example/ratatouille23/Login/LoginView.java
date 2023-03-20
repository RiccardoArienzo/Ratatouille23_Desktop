package com.example.ratatouille23.Login;

import com.example.ratatouille23.Model.Utente;
import com.example.ratatouille23.homepage.HomepageView;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import software.amazon.awssdk.services.cognitoidentityprovider.model.CognitoIdentityProviderException;

import java.io.IOException;
import java.util.Optional;

public class LoginView {


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
    private HomepageView homepage;
    private ReimpostaPasswordView reimpostaPassword;

    private LoginController loginController;


    public void initialize() {
        pulsanteLogin.disableProperty().bind(
                Bindings.createBooleanBinding(
                        () -> userNameTextField.getText().isEmpty() || passwordTextField.getText().isEmpty(),
                        userNameTextField.textProperty(),
                        passwordTextField.textProperty()
                )
        );

    }


    public void clickPulsanteLogin() {
        loginController.onPulsanteLoginClicked();
    }

    public void apriSchermataReimpostaPassword(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/Login/reimposta-password.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
