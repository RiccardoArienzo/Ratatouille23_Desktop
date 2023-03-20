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

import java.io.IOException;
import java.util.Optional;

public class ReimpostaPasswordView {


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


    private HomepageView homepage;

    private ReimpostaPasswordController reimpostaPasswordController;

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
        reimpostaPasswordController.onPulsanteConfermaNuovaPasswordClicked();
    }




    public void apriSchermataReimpostaPassword() throws IOException {
        root = FXMLLoader.load(getClass().getResource("/Login/reimposta-password.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
