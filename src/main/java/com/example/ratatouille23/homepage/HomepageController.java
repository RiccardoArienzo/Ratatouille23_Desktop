package com.example.ratatouille23.homepage;

import com.example.ratatouille23.View;
import com.example.ratatouille23.creaUtente.CreaUtenteView;
import com.example.ratatouille23.inserisciAvvisi.InserisciAvvisiView;
import com.example.ratatouille23.personalizzaMenu.NuovoPiattoView;
import com.example.ratatouille23.personalizzaMenu.PersonalizzaMenuView;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.Optional;

public class HomepageController {

    HomepageView homepage;
    PersonalizzaMenuView personalizzaMenu;
    NuovoPiattoView nuovoPiatto;
    CreaUtenteView creaUtente;
    InserisciAvvisiView inserisciAvvisi;

    String nodoCorrente = "homepage";


    //**************************

    // Costruttori
    HomepageController(HomepageView home, PersonalizzaMenuView personalizzamenu, NuovoPiattoView nuovopiatto,
                       CreaUtenteView creautente, InserisciAvvisiView inserisciavvisi){
        this.homepage = home;
        this.personalizzaMenu = personalizzamenu;
        this.nuovoPiatto = nuovopiatto;
        this.creaUtente = creautente;
        this.inserisciAvvisi = inserisciavvisi;
    }


    //**************************

    // On Action Event


    public void onPersonalizzaMenuClicked() {
        try {
            if (nodoCorrente == "creaUtente"){
                if(creaUtente.verificaCampiVuoti()){
                    setBorderPaneCenter(personalizzaMenu.caricaNodoPersonalizzaMenu());
                    nodoCorrente = "personalizzaMenu";
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
                setBorderPaneCenter(personalizzaMenu.caricaNodoPersonalizzaMenu());
                nodoCorrente = "personalizzaMenu";
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public void onCreaUtenteClicked() {
        try {
            setBorderPaneCenter(creaUtente.caricaNodoCreaUtente());
            nodoCorrente = "creaUtente";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void onInserisciAvvisiClicked() {
        try {
            if (nodoCorrente == "creaUtente"){
                if(creaUtente.verificaCampiVuoti()){
                    setBorderPaneCenter(personalizzaMenu.caricaNodoPersonalizzaMenu());
                    nodoCorrente = "inserisciAvvisi";
                } else {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Conferma");
                    alert.setHeaderText("Sei sicuro di voler tornare indietro?");
                    alert.setContentText("I dati inseriti non verranno salvati.");
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK) {
                        setBorderPaneCenter(personalizzaMenu.caricaNodoPersonalizzaMenu());
                        nodoCorrente = "inserisciAvvisi";                    }
                }
            } else {
                setBorderPaneCenter(personalizzaMenu.caricaNodoPersonalizzaMenu());
                nodoCorrente = "inserisciAvvisi";
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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

    // Metodi di utility

    public void setBorderPaneCenter(Node node){
        homepage.borderPane.getChildren().remove(homepage.borderPane.getCenter());
        homepage.borderPane.setCenter(node);
    }

    public void setBorderPaneRight(Node node){
       homepage.borderPane.getChildren().remove(homepage.borderPane.getRight());
        homepage.borderPane.setCenter(node);
    }

}
