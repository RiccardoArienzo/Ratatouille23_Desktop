package com.example.ratatouille23.Controller.Amministratore;

import com.example.ratatouille23.View.Admin.CreaUtenteView;
import com.example.ratatouille23.View.Admin.HomepageAdminView;
import com.example.ratatouille23.View.GestisciAvvisiView;
import com.example.ratatouille23.View.InserisciAvvisiView;
import com.example.ratatouille23.View.NuovoPiattoView;
import com.example.ratatouille23.View.PersonalizzaMenuView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import java.io.IOException;

public class HomepageAdminController {

    private HomepageAdminView homepage;
    private PersonalizzaMenuView personalizzaMenu;
    private NuovoPiattoView nuovoPiatto;
    private CreaUtenteView creaUtente;
    private InserisciAvvisiView inserisciAvvisi;
    private GestisciAvvisiView gestisciAvvisi;


    //**************************

    // Costruttori

    public HomepageAdminController(HomepageAdminView view){
        this.homepage = view;

        loadPersonalizzaMenu();
        loadCreaUtente();
        loadInserisciAvvisi();
        loadNuovoPiatto();
        loadGestisciAvvisi();
    };


    //**************************

    // On Action Event


    public void onPersonalizzaMenuClicked() {
        homepage.removeRightView();
        homepage.updateCenterView(personalizzaMenu.getNode());
    }



    public void onCreaUtenteClicked() {
        try {
            homepage.removeRightView();
            homepage.updateCenterView(creaUtente.loadNode());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void onInserisciAvvisiClicked() {
        try {
            homepage.removeRightView();
            homepage.updateCenterView(inserisciAvvisi.loadNode());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void onGestisciAvvisiClicked() {
        try {
            homepage.removeRightView();
            homepage.updateCenterView(gestisciAvvisi.loadNode());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //**************************

    // Metodi di loading

    public void loadPersonalizzaMenu(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/personalizza-menu.fxml"));
            loader.load();
            this.personalizzaMenu = loader.getController();
            this.personalizzaMenu.setNode(loader.getRoot());
            this.personalizzaMenu.getPersonalizzaMenuController().setHomepageView(homepage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
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
    public void loadInserisciAvvisi(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/inserisci-avvisi.fxml"));
            loader.load();
            this.inserisciAvvisi = loader.getController();
            this.inserisciAvvisi.setNode(loader.getRoot());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void loadNuovoPiatto(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/nuovo-piatto.fxml"));
            loader.load();
            this.nuovoPiatto = loader.getController();
            this.nuovoPiatto.setNode(loader.getRoot());
            this.nuovoPiatto.getNuovoPiattoController().setHomepageView(homepage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

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

    // Utility

    public void setLabelAvvisiDisponibili(){
        if (gestisciAvvisi.getGestisciAvvisiController().checkAvvisiNonLetti()){
            homepage.getLabelAvvisiDisponibili().setVisible(true);
        } else {
            homepage.getLabelAvvisiDisponibili().setVisible(false);
        }
    }

    // Getter

    public Node getNuovoPiattoNode(){
        return this.nuovoPiatto.getNode();
    }

}
