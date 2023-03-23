package com.example.ratatouille23.View;

import com.example.ratatouille23.Controller.LoginController;
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

public class LoginView implements ViewInterface {


    @FXML
    private TextField userNameTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private Button btnLogin;


    private Stage stage;
    private Scene scene;
    private Parent root;

    private Node node;


    // Schermate
    private HomepageView homepage;
    private ReimpostaPasswordView reimpostaPassword;
    private LoginController loginController;


    public void initialize() {

        this.loginController = new LoginController();

        btnLogin.disableProperty().bind(
                Bindings.createBooleanBinding(
                        () -> userNameTextField.getText().isEmpty() || passwordTextField.getText().isEmpty(),
                        userNameTextField.textProperty(),
                        passwordTextField.textProperty()
                )
        );

    }

    // Metodi di ViewInterface
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

    public String getUsernameText() {
        return userNameTextField.getText();
    }

    public String getPasswordText(){
        return passwordTextField.getText();
    }


}
