package com.example.ratatouille23.personalizzaMenu;

import com.example.ratatouille23.Model.Piatto;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class NuovoPiattoController {

    @FXML
    TextField nomePiattoTextField;

    @FXML
    TextField costoPiattoTextField;

    @FXML
    TextArea descrizionePiattoTextArea;

    @FXML
    ComboBox categoriaComboBox;

    @FXML
    TextArea allergeniPiattoTextArea;

    @FXML
    Button pulsanteConferma;




    SchermataPersonalizzaMenu personalizzaMenu = new SchermataPersonalizzaMenu();
    SchermataNuovoPiatto schermataNuovoPiatto = new SchermataNuovoPiatto();

    public void initialize(){

        pulsanteConferma.disableProperty().bind(
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

    private void clickPulsanteConferma(ActionEvent e){

        Piatto piatto = new Piatto(nomePiattoTextField.getText(), Float.parseFloat(costoPiattoTextField.getText()), allergeniPiattoTextArea.getText(), descrizionePiattoTextArea.getText());
        // codice per inviarlo al backend
    }

    public void clickPulsanteIndietroNuovoPiatto(ActionEvent event){
        try {
            personalizzaMenu.apriSchermataPersonalizzaMenu(event);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
