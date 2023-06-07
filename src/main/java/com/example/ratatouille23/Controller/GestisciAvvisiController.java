package com.example.ratatouille23.Controller;

import com.example.ratatouille23.Main;
import com.example.ratatouille23.View.GestisciAvvisiView;
import com.example.ratatouille23.View.AddettoSala.HomepageSalaView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class GestisciAvvisiController {

    GestisciAvvisiView gestisciAvvisi;

    public GestisciAvvisiController(GestisciAvvisiView view){
        this.gestisciAvvisi = view;
    }


    // Event handler

    public void onBtnVisualizzaAvvisiNascostiClicked() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/avvisi-nascosti.fxml"));
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
