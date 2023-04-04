package com.example.ratatouille23;

import com.example.ratatouille23.View.PersonalizzaMenuView;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public abstract class Homepage {

    PersonalizzaMenuView personalizzaMenu;

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

}
