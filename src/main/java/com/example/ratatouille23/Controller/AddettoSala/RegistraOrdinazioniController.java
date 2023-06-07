package com.example.ratatouille23.Controller.AddettoSala;

import com.example.ratatouille23.Main;
import com.example.ratatouille23.Model.Ordinazione;
import com.example.ratatouille23.Model.Piatto;
import com.example.ratatouille23.View.AddettoSala.RegistraOrdinazioniView;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class RegistraOrdinazioniController {

    private Ordinazione ordinazione;
    private RegistraOrdinazioniView registraOrdinazioni;

    public RegistraOrdinazioniController(RegistraOrdinazioniView view) {
        this.registraOrdinazioni = view;
        this.ordinazione = new Ordinazione();
    }



    public void incrementaQuantity(Piatto piatto) {
        ordinazione.incrementaQuantitaPiatto(piatto);

        System.out.println(ordinazione);

    }

    public void decrementaQuantity(Piatto piatto){
        ordinazione.decrementaQuantitaPiatto(piatto);

        System.out.println(ordinazione);

    }


    public void impostaTavolo(String idTavolo) {
        this.ordinazione.setIdTavolo(idTavolo);
    }

    public Ordinazione getOrdinazione() {
        return ordinazione;
    }

    public void onBtnConfermaOrdinazioneClicked() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Conferma");
        alert.setHeaderText("Sei sicuro di voler confermare questa ordinazione?");
        alert.setContentText("Una volta confermata, la comanda non potrà essere cancellata.");
        alert.initOwner(Main.getPrimaryStage());
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){

            // Invia l'ordinazione al server
            // poi cancella quella corrente
           resetOrdinazione();
        }
    }


    public void onBtnCancellaOrdinazioneClicked() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Conferma");
        alert.setHeaderText("Sei sicuro di voler cancellare questa ordinazione?");
        alert.setContentText("Una volta confermata, la comanda andrà persa definitivamente.");
        alert.initOwner(Main.getPrimaryStage());
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            resetOrdinazione();
        }
    }



    public void resetOrdinazione(){
        ordinazione = new Ordinazione();
        registraOrdinazioni.updateRiepilogo();
        registraOrdinazioni.getTavoloComboBox().getSelectionModel().clearSelection();
        registraOrdinazioni.getTavoloComboBox().setPromptText("Seleziona tavolo");
    }

}
