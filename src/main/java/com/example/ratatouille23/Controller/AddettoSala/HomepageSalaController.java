package com.example.ratatouille23.Controller.AddettoSala;

import com.example.ratatouille23.HomepageController;
import com.example.ratatouille23.View.*;
import com.example.ratatouille23.View.AddettoSala.RegistraOrdinazioniView;
import com.example.ratatouille23.View.AddettoSala.HomepageSalaView;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class HomepageSalaController extends HomepageController {

    protected RegistraOrdinazioniView registraOrdinazioni;


    //**************************

    // Costruttori

    public HomepageSalaController(HomepageSalaView view){
        super(view);
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

    // Loader

    public void loadRegistraOrdinazioni(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/registra-ordinazioni.fxml"));
            loader.load();
            this.registraOrdinazioni = loader.getController();
            this.registraOrdinazioni.setNode(loader.getRoot());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
