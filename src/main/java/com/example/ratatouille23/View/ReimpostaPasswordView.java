package com.example.ratatouille23.View;

import com.example.ratatouille23.Controller.ReimpostaPasswordController;
import com.example.ratatouille23.ViewInterface;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ReimpostaPasswordView implements ViewInterface {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private Node node;

    @FXML
    private TextField oldPasswordTextField;

    @FXML
    private TextField newPasswordTextField;

    @FXML
    private Button btnConferma;


    private HomepageView homepage;

    private ReimpostaPasswordController reimpostaPasswordController;

    public void initialize() {
        btnConferma.disableProperty().bind(
                Bindings.createBooleanBinding(
                        () -> oldPasswordTextField.getText().isEmpty() || newPasswordTextField.getText().isEmpty(),
                        oldPasswordTextField.textProperty(),
                        newPasswordTextField.textProperty()
                )
        );

    }

    // Metodi di View Interface
    @Override
    public Node loadNode() throws IOException {
        return FXMLLoader.load(getClass().getResource("/Login/reimposta-password.fxml"));
    }

    @Override
    public Node getNode(){
        return this.node;
    }

    @Override
    public void setNode(Node node){
        this.node = node;
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

    public String getNewPasswordText() {
        return newPasswordTextField.getText();
    }

    public String getOldPasswordText(){
        return oldPasswordTextField.getText();
    }
}
