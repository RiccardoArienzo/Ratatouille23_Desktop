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

public class ReimpostaPasswordController {


    @FXML
    TextField vecchiaPasswordTextField;

    @FXML
    TextField nuovaPasswordTextField;

    @FXML
    Button pulsanteConferma;

    private Stage stage;
    private Scene scene;
    private Parent root;

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

    public void clickPulsanteConfermaNuovaPassword(ActionEvent event){
        // if vecchia pass corrisponde allora tras
        //TODO
        try {
            home.apriSchermataHome(event);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //else dialog errore
    }


}