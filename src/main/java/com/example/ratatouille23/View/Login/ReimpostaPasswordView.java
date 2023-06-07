package com.example.ratatouille23.View.Login;

import com.example.ratatouille23.Controller.Login.ReimpostaPasswordController;
import com.example.ratatouille23.View.Admin.HomepageAdminView;
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

    private Scene scene;
    private Parent root;
    private Node node;

    @FXML
    private TextField oldPasswordTextField;

    @FXML
    private TextField newPasswordTextField;

    @FXML
    private Button btnConferma;
    private ReimpostaPasswordController reimpostaPasswordController;

    @FXML
    public void initialize() {

        this.reimpostaPasswordController = new ReimpostaPasswordController(this);

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
    public Node getNode(){
        return this.node;
    }

    @Override
    public void setNode(Node node){
        this.node = node;
    }

    public void clickBtnConfermaNuovaPassword() {
        reimpostaPasswordController.onBtnConfermaNuovaPasswordClicked();
    }


    public String getNewPasswordText() {
        return newPasswordTextField.getText();
    }

    public String getOldPasswordText(){
        return oldPasswordTextField.getText();
    }
}
