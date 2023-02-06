package com.example.ratatouille23.creaUtente;

import com.example.ratatouille23.homepage.Homepage;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreaUtenteController {

    @FXML
    TextField nomeUtenteTextField;
    @FXML
    TextField emailTextField;
    @FXML
    ComboBox tipoDipendenteComboBox;
    @FXML
    Button pulsanteConferma;

    private Homepage homepage = new Homepage();

    @FXML
    /*public void initialize() {
        // Crea una proprietà booleana che rappresenta lo stato del bottone
        BooleanProperty buttonDisabled = new SimpleBooleanProperty(true);

        BooleanBinding textFieldsEmpty = Bindings.and(
                nomeUtenteTextField.textProperty().isEmpty(),
                emailTextField.textProperty().isEmpty()
        );

        buttonDisabled.bind(
                Bindings.and(
                        textFieldsEmpty,
                        tipoDipendenteComboBox.valueProperty().isNull()
                )
        );

        pulsanteConferma.disableProperty().bind(buttonDisabled);

        // Associa la proprietà booleana alla proprietà di disabilitazione del bottone
        pulsanteConferma.disableProperty().bind(buttonDisabled);
    }
    */

    public void initialize(){
        tipoDipendenteComboBox.getItems().addAll("Supervisore", "Addetto alla cucina", "Addetto alla sala" );


        pulsanteConferma.disableProperty().bind(
                Bindings.createBooleanBinding(
                        () -> nomeUtenteTextField.getText().isEmpty()  || emailTextField.getText().isEmpty() || tipoDipendenteComboBox.getValue() == null,
                        nomeUtenteTextField.textProperty(),
                        emailTextField.textProperty(),
                        tipoDipendenteComboBox.valueProperty()
                )
        );
    }


    public void clickPulsanteIndietro(ActionEvent event){
        try {
            homepage.apriSchermataHome(event);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
