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

    public void clickPulsanteLogin(ActionEvent event){
        // if non primo login
        //TODO
        try {
            reimpostaPassword.apriSchermataReimpostaPassword(event);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}