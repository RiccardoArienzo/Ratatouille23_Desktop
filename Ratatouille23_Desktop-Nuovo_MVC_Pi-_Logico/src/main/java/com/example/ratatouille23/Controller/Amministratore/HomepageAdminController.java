package com.example.ratatouille23.Controller.Amministratore;

import com.example.ratatouille23.Controller.Supervisore.HomepageSupervisoreController;
import com.example.ratatouille23.View.Admin.CreaUtenteView;
import com.example.ratatouille23.View.Admin.HomepageAdminView;
import com.example.ratatouille23.View.Admin.StatisticheView;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class HomepageAdminController extends HomepageSupervisoreController {

    protected CreaUtenteView creaUtente;
    protected StatisticheView statisticheView;



    //**************************

    // Costruttori

    public HomepageAdminController(HomepageAdminView view){
        super(view);
        loadCreaUtente();
        loadStatistiche();
    };


    //**************************

    // On Action Event

    public void onCreaUtenteClicked() {
        homepage.removeRightView();
        homepage.updateCenterView(creaUtente.getNode());
    }

    public void onStatisticheClicked(){
        homepage.removeRightView();
        homepage.updateCenterView(statisticheView.getNode());
    }




    //**************************

    // Metodi di loading

    public void loadCreaUtente(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/crea-utente.fxml"));
            loader.load();
            this.creaUtente = loader.getController();
            this.creaUtente.setNode(loader.getRoot());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadStatistiche() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/statistiche.fxml"));
            loader.load();
            this.statisticheView = loader.getController();
            this.statisticheView.setNode(loader.getRoot());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Utility

    /*
    public void setLabelAvvisiDisponibili(){
        if (gestisciAvvisi.getGestisciAvvisiController().checkAvvisiNonLetti()){
            homepage.getLabelAvvisiDisponibili().setVisible(true);
        } else {
            homepage.getLabelAvvisiDisponibili().setVisible(false);
        }
    }

     */

}
