package com.example.ratatouille23.Controller.AddettoCucina;

import com.example.ratatouille23.Main;
import com.example.ratatouille23.Model.Ordinazione;
import com.example.ratatouille23.View.AddettoCucina.GestisciOrdinazioniView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class GestisciOrdinazioniController {

    GestisciOrdinazioniView gestisciOrdinazioni;

    public GestisciOrdinazioniController(GestisciOrdinazioniView view){
        this.gestisciOrdinazioni = view;
    }

    public void onBtnPreparaOrdinazioneClicked(Ordinazione ord) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Conferma");
        alert.setHeaderText("Sei sicuro di voler preparare questa ordinazione?");
        alert.setContentText("Una volta presa in carico la comanda, non potrai annullare.");
        alert.initOwner(Main.getPrimaryStage());
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            // 1. Aggiorna lo stato del piatto con un metodo tipo:
            // updateOrdinazione(ord);
            // 2. Controllare che lo stato del piatto sia stato cambiato.
            // Il metodo deve ritornare un valore. Se il valore è false,
            // Allora la comanda è già stata prenotata da qualcun altro nel frattempo.
            // Altrimenti, dialog che dice ''prenotazione effettuata'

            // ATTENZIONE: Va anche passato il nome dell'utente che la sta preparando
        }
    }

    public void onBtnOrdinazioniEvaseClicked() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ordinazioni-evase.fxml"));
            Stage newStage = new Stage();
            newStage.initOwner(Main.getPrimaryStage());
            newStage.initModality(Modality.APPLICATION_MODAL); // Questa riga rende la nuova finestra modale rispetto alla finestra principale
            newStage.setScene(new Scene(loader.load()));
            newStage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
