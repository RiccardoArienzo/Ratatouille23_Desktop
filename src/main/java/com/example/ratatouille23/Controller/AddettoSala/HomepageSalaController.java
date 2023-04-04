package com.example.ratatouille23.Controller.AddettoSala;

import com.example.ratatouille23.View.*;
import com.example.ratatouille23.View.AddettoSala.RegistraOrdinazioniView;
import com.example.ratatouille23.View.AddettoSala.HomepageSalaView;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class HomepageSalaController {


    HomepageSalaView homepage;
    GestisciAvvisiView gestisciAvvisi;
    RegistraOrdinazioniView registraOrdinazioni;


    //**************************

    // Costruttori

    public HomepageSalaController(HomepageSalaView view){
        this.homepage = view;
        loadGestisciAvvisi();
        loadRegistraOrdinazioni();
    };


    //**************************

    // On Action Event


    public void onRegistraOrdinazioniClicked() {
        homepage.removeRightView();
        homepage.updateCenterView(registraOrdinazioni.getNode());
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

    public void loadRegistraOrdinazioni(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/registra-ordinazioni.fxml"));
            loader.load();
            this.registraOrdinazioni= loader.getController();
            this.registraOrdinazioni.setNode(loader.getRoot());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
