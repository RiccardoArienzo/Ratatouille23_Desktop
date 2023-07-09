package com.example.ratatouille23.Controller.AddettoCucina;

import com.example.ratatouille23.HomepageController;
import com.example.ratatouille23.View.AddettoCucina.GestisciOrdinazioniView;
import com.example.ratatouille23.View.AddettoCucina.HomepageCucinaView;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class HomepageCucinaController extends HomepageController {
    protected GestisciOrdinazioniView gestisciOrdinazioni;

    //**************************

    // Costruttori

    public HomepageCucinaController(HomepageCucinaView view){
         super(view);
        loadGestisciAvvisi();
        loadGestisciOrdinazioni();
    };


    //**************************

    // On Action Event


    public void onGestisciOrdinazioniClicked() {
        homepage.removeRightView();
        homepage.updateCenterView(gestisciOrdinazioni.getNode());
    }


    public void onGestisciAvvisiClicked() {
        homepage.removeRightView();
        homepage.updateCenterView(gestisciAvvisi.getNode());
    }


    //**************************

    // Loader

    public void loadGestisciOrdinazioni(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gestisci-ordinazioni.fxml"));
            loader.load();
            this.gestisciOrdinazioni= loader.getController();
            this.gestisciOrdinazioni.setNode(loader.getRoot());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
