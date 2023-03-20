package com.example.ratatouille23.inserisciAvvisi;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.Optional;

public class InserisciAvvisiView {


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
      /*  try {
            if (verificaCampiVuoti()) {
                home.apriSchermataHome(event);
            } else {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Conferma");
                alert.setHeaderText("Sei sicuro di voler tornare indietro?");
                alert.setContentText("I dati inseriti non verranno salvati.");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK){
                    home.apriSchermataHome(event);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        */
    }


    public boolean verificaCampiVuoti(){
        if (corpoAvviso.getText().isEmpty() && oggettoAvviso.getText().isEmpty()){
            return true;
        } else {
            return false;
        }
    }

    public Node apriSchermataInserisciAvvisi(ActionEvent event) throws IOException {
        return FXMLLoader.load(getClass().getResource("/inserisciAvvisi/inserisci-avvisi.fxml"));
    }
}
