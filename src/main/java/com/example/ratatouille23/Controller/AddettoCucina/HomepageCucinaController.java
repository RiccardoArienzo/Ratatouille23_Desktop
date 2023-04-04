package com.example.ratatouille23.Controller.AddettoCucina;

import com.example.ratatouille23.View.AddettoCucina.GestisciOrdinazioniView;
import com.example.ratatouille23.View.AddettoCucina.HomepageCucinaView;
import com.example.ratatouille23.View.GestisciAvvisiView;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class HomepageCucinaController {


    HomepageCucinaView homepage;
    GestisciAvvisiView gestisciAvvisi;
    GestisciOrdinazioniView gestisciOrdinazioni;


    //**************************

    // Costruttori

    public HomepageCucinaController(HomepageCucinaView view){
        this.homepage = view;
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

    // Metodi di loading

    public void loadGestisciAvvisi(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gestisci-avvisi.fxml"));
            loader.load();
            this.gestisciAvvisi = loader.getController();
            this.gestisciAvvisi.setNode(loader.getRoot());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

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
