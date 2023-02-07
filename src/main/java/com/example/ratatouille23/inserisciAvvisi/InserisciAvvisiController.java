package com.example.ratatouille23.inserisciAvvisi;

import com.example.ratatouille23.homepage.Homepage;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class InserisciAvvisiController {

    private Homepage home = new Homepage();

    @FXML
    TextArea corpoAvviso;
    @FXML
    Button pulsanteInvia;
    @FXML
    TextField oggettoAvviso;



    public void initialize(){
        pulsanteInvia.disableProperty().bind(
                Bindings.createBooleanBinding(
                        () -> oggettoAvviso.getText().isEmpty()  || corpoAvviso.getText().isEmpty(),
                        oggettoAvviso.textProperty(),
                        corpoAvviso.textProperty()
                )
        );
    }

    public void clickPulsanteIndietroInserisciAvvisi(ActionEvent event){
        try {
            if (verificaCampiVuoti()) {
                home.apriSchermataHome(event);
            } else {
                // prova
                System.out.println("Non puoi tornare indietro");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public boolean verificaCampiVuoti(){
        if (corpoAvviso.getText().isEmpty() && oggettoAvviso.getText().isEmpty()){
            return true;
        } else {
            return false;
        }
    }
}
