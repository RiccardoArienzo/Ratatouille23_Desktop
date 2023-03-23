package com.example.ratatouille23.View;

import com.example.ratatouille23.Controller.InserisciAvvisiController;
import com.example.ratatouille23.ViewInterface;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;

import java.io.IOException;

public class InserisciAvvisiView implements ViewInterface {


    @FXML
    private TextArea corpoAvviso;
    @FXML
    private Button btnInvia;
    @FXML
    private TextField oggettoAvviso;

    private Node node;
    private InserisciAvvisiController inserisciAvvisiController;

    // Costruttori

    public InserisciAvvisiView() {}


    // Metodi

    public void initialize(){

        this.inserisciAvvisiController = new InserisciAvvisiController(this);
        btnInvia.disableProperty().bind(
                Bindings.createBooleanBinding(
                        () -> oggettoAvviso.getText().isEmpty()  || corpoAvviso.getText().isEmpty(),
                        oggettoAvviso.textProperty(),
                        corpoAvviso.textProperty()
                )
        );
    }

    // Metodi di ViewInterface
    @Override
    public Node loadNode() throws IOException {
        return FXMLLoader.load(getClass().getResource("/inserisciAvvisi/inserisci-avvisi.fxml"));
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


    public void setInserisciAvvisiController(InserisciAvvisiController inserisciAvvisiController) {
        this.inserisciAvvisiController = inserisciAvvisiController;
    }
}
