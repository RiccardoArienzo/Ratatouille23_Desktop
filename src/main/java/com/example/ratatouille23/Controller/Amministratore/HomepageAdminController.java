package com.example.ratatouille23.Controller.Amministratore;

import com.example.ratatouille23.Controller.Supervisore.HomepageSupervisoreController;
import com.example.ratatouille23.Homepage;
import com.example.ratatouille23.HomepageController;
import com.example.ratatouille23.View.Admin.CreaUtenteView;
import com.example.ratatouille23.View.Admin.HomepageAdminView;
import com.example.ratatouille23.View.GestisciAvvisiView;
import com.example.ratatouille23.View.InserisciAvvisiView;
import com.example.ratatouille23.View.NuovoPiattoView;
import com.example.ratatouille23.View.PersonalizzaMenuView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import java.io.IOException;

public class HomepageAdminController extends HomepageSupervisoreController {

    protected CreaUtenteView creaUtente;



    //**************************

    // Costruttori

    public HomepageAdminController(HomepageAdminView view){
        super(view);
        loadCreaUtente();
    };


    //**************************

    // On Action Event

    public void onCreaUtenteClicked() {
        homepage.removeRightView();
        homepage.updateCenterView(creaUtente.getNode());
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
