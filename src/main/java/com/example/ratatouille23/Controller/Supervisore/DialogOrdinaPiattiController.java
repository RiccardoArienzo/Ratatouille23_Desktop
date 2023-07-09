package com.example.ratatouille23.Controller.Supervisore;

import com.example.ratatouille23.Main;
import com.example.ratatouille23.Model.Categoria;
import com.example.ratatouille23.Model.Piatto;
import com.example.ratatouille23.View.Supervisore.DialogOrdinaCategorieView;
import com.example.ratatouille23.View.Supervisore.DialogOrdinaPiattiView;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;

import java.util.Optional;

public class DialogOrdinaPiattiController {

    private DialogOrdinaPiattiView ordinaPiattiView;

    public DialogOrdinaPiattiController(DialogOrdinaPiattiView ordinaPiattiView) {
        this.ordinaPiattiView = ordinaPiattiView;
    }


    public void onBtnConfermaClicked() {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Conferma nuovo ordinamento piatti");
        alert.setContentText("Sei sicuro di voler riordinare i piatti in questo modo?");
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.initOwner(Main.getPrimaryStage());
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            System.out.println("L'ordine dei piatti è:");

            ObservableList<Piatto> items = ordinaPiattiView.getListaPiatti().getItems();
            items.forEach(element -> {
                        int position = items.indexOf(element)+1;
                        System.out.println("La posizione di " + element.getNomePiatto() + " è: " + position);
                        //TODO aggiungere chiamata DAO per aggiornare posizione piatto.

                        // qui devi fare la chiamata al backend. La chiamata dovrà essere definita così:
                        // updatePosizionePiatto(Piatto piatto, int posizione)
                        // Ed il modo in cui lo richiami qui sarà:
                        // updatePosizionePiatto(element, position)

                    }
            );

        }
        }

    }

