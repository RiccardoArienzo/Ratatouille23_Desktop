package com.example.ratatouille23.Controller;

import com.example.ratatouille23.View.CreaUtenteView;
import com.example.ratatouille23.View.HomepageView;
import com.example.ratatouille23.View.InserisciAvvisiView;
import com.example.ratatouille23.View.NuovoPiattoView;
import com.example.ratatouille23.View.PersonalizzaMenuView;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class HomepageController {

    HomepageView homepage;
    PersonalizzaMenuView personalizzaMenu;
    NuovoPiattoView nuovoPiatto;
    CreaUtenteView creaUtente;
    InserisciAvvisiView inserisciAvvisi;

    String nodoCorrente = "homepage";


    //**************************

    // Costruttori

    public HomepageController(HomepageView view){
        this.homepage = view;

        loadPersonalizzaMenu();
        loadCreaUtente();
        loadNuovoPiatto();
        loadInserisciAvvisi();
    };


    //**************************

    // On Action Event


    public void onPersonalizzaMenuClicked() {
        homepage.updateCenterView(personalizzaMenu.getNode());
        nodoCorrente = "personalizzaMenu";
       /*
        try {
            if (nodoCorrente == "creaUtente"){
                if(creaUtente.verificaCampiVuoti()){
                    homepage.updateCenterView(personalizzaMenu.caricaNodoPersonalizzaMenu());
                    nodoCorrente = "personalizzaMenu";
                } else {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Conferma");
                    alert.setHeaderText("Sei sicuro di voler tornare indietro?");
                    alert.setContentText("I dati inseriti non verranno salvati.");
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK) {
                        homepage.updateCenterView(personalizzaMenu.caricaNodoPersonalizzaMenu());
                        nodoCorrente = "personalizzaMenu";                    }
                }
            } else {
                homepage.updateCenterView(personalizzaMenu.caricaNodoPersonalizzaMenu());
                nodoCorrente = "personalizzaMenu";
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        */
    }



    public void onCreaUtenteClicked() {
        try {
            homepage.updateCenterView(creaUtente.loadNode());
            nodoCorrente = "creaUtente";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void onInserisciAvvisiClicked() {
        try {
            homepage.updateCenterView(inserisciAvvisi.loadNode());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        nodoCorrente = "personalizzaMenu";
        /*
        try {
            if (nodoCorrente == "creaUtente"){
                if(creaUtente.verificaCampiVuoti()){
                    homepage.updateCenterView(personalizzaMenu.caricaNodoPersonalizzaMenu());
                    nodoCorrente = "inserisciAvvisi";
                } else {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Conferma");
                    alert.setHeaderText("Sei sicuro di voler tornare indietro?");
                    alert.setContentText("I dati inseriti non verranno salvati.");
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK) {
                        homepage.updateCenterView(personalizzaMenu.caricaNodoPersonalizzaMenu());
                        nodoCorrente = "inserisciAvvisi";                    }
                }
            } else {
                homepage.updateCenterView(personalizzaMenu.caricaNodoPersonalizzaMenu());
                nodoCorrente = "inserisciAvvisi";
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

         */
    }
    

    /*
    public void verificaSePuoiAprire(View vista){
        try {
            if (nodoCorrente == "creaUtente"){
                if(creaUtente.verificaCampiVuoti()){
                    setBorderPaneCenter(vista.caricaNodo());
                    nodoCorrente = vista.nomeNodo;
                } else {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Conferma");
                    alert.setHeaderText("Sei sicuro di voler tornare indietro?");
                    alert.setContentText("I dati inseriti non verranno salvati.");
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK) {
                        setBorderPaneCenter(personalizzaMenu.caricaNodoPersonalizzaMenu());
                        nodoCorrente = "personalizzaMenu";                    }
                }
            } else {
                setBorderPaneCenter(vista.caricaNodo());
                nodoCorrente = "personalizzaMenu";
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
*/

    //**************************

    // Metodi di loading

    public void loadPersonalizzaMenu(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/personalizzaMenu/personalizza-menu.fxml"));
            loader.load();
            this.personalizzaMenu = loader.getController();
            this.personalizzaMenu.setNode(loader.getRoot());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void loadCreaUtente(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/creaUtente/crea-utente.fxml"));
            loader.load();
            this.creaUtente = loader.getController();
            this.creaUtente.setNode(loader.getRoot());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void loadInserisciAvvisi(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/inserisciAvvisi/inserisci-avvisi.fxml"));
            loader.load();
            this.inserisciAvvisi = loader.getController();
            this.inserisciAvvisi.setNode(loader.getRoot());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void loadNuovoPiatto(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/personalizzaMenu/nuovo-piatto.fxml"));
            loader.load();
            this.nuovoPiatto= loader.getController();
            this.nuovoPiatto.setNode(loader.getRoot());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
