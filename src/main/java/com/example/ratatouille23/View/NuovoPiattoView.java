package com.example.ratatouille23.View;

import com.example.ratatouille23.Controller.NuovoPiattoController;
import com.example.ratatouille23.ViewInterface;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class NuovoPiattoView implements ViewInterface {

    @FXML
    private TextField nomePiattoTextField;
    @FXML
    private TextField costoPiattoTextField;
    @FXML
    private TextArea descrizionePiattoTextArea;
    @FXML
    private ComboBox categoriaComboBox;
    @FXML
    private TextArea allergeniPiattoTextArea;
    @FXML
    private Button btnConferma;

    private Node node;
    NuovoPiattoController nuovoPiattoController;


    //****************

    public NuovoPiattoView() {}

    public void initialize(){

        btnConferma.disableProperty().bind(
                Bindings.createBooleanBinding(
                        () -> nomePiattoTextField.getText().isEmpty()  || costoPiattoTextField.getText().isEmpty() || descrizionePiattoTextArea.getText().isEmpty() || allergeniPiattoTextArea.getText().isEmpty() || categoriaComboBox.getValue() == null,
                        nomePiattoTextField.textProperty(),
                        costoPiattoTextField.textProperty(),
                        descrizionePiattoTextArea.textProperty(),
                        allergeniPiattoTextArea.textProperty(),
                        categoriaComboBox.valueProperty()
                )
        );
    }

    // Metodi di ViewInterface
    public Node loadNode() throws IOException {
        return FXMLLoader.load(getClass().getResource("/personalizzaMenu/nuovo-piatto.fxml"));
    }


    @Override
    public Node getNode(){
        return this.node;
    }

    @Override
    public void setNode(Node node){
        this.node = node;
    }


    // Event handler
    private void clickPulsanteConferma(ActionEvent e){

    }



    public void setNuovoPiattoController(NuovoPiattoController nuovoPiattoController) {
        this.nuovoPiattoController = nuovoPiattoController;
    }
}
