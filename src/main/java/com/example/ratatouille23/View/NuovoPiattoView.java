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
    @FXML
    private Button btnChiudiSchermata;

    private Node node;
    NuovoPiattoController nuovoPiattoController;


    //****************

    public NuovoPiattoView() {}

    @FXML
    public void initialize(){

        this.nuovoPiattoController = new NuovoPiattoController(this);

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

    // Event Handler

    public void clickBtnConferma(){
        nuovoPiattoController.onBtnConfermaClicked();
    }


    // Metodi di ViewInterface

    @Override
    public Node getNode(){
        return this.node;
    }

    @Override
    public void setNode(Node node){
        this.node = node;
    }


    // Event handler
    private void clickBtnConferma(ActionEvent e){

    }




    public TextField getNomePiattoTextField() {
        return nomePiattoTextField;
    }

    public TextField getCostoPiattoTextField() {
        return costoPiattoTextField;
    }

    public TextArea getDescrizionePiattoTextArea() {
        return descrizionePiattoTextArea;
    }

    public ComboBox getCategoriaComboBox() {
        return categoriaComboBox;
    }

    public TextArea getAllergeniPiattoTextArea() {
        return allergeniPiattoTextArea;
    }

    public NuovoPiattoController getNuovoPiattoController() {
        return nuovoPiattoController;
    }

}
