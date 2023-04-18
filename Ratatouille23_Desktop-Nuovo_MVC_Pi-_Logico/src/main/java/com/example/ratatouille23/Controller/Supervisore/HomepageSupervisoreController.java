package com.example.ratatouille23.Controller.Supervisore;

import com.example.ratatouille23.Homepage;
import com.example.ratatouille23.HomepageController;
import com.example.ratatouille23.View.Admin.HomepageAdminView;
import com.example.ratatouille23.View.InserisciAvvisiView;
import com.example.ratatouille23.View.NuovoPiattoView;
import com.example.ratatouille23.View.PersonalizzaMenuView;
import com.example.ratatouille23.View.Supervisore.HomepageSupervisoreView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import java.io.IOException;

public class HomepageSupervisoreController extends HomepageController {

    protected PersonalizzaMenuView personalizzaMenu;
    protected NuovoPiattoView nuovoPiatto;
    protected InserisciAvvisiView inserisciAvvisi;

    // Costruttori

    public HomepageSupervisoreController(Homepage view){
        super(view);
        loadPersonalizzaMenu();
        loadInserisciAvvisi();
        loadNuovoPiatto();
    };



    // Event handler

    public void onPersonalizzaMenuClicked() {
        homepage.removeRightView();
        homepage.updateCenterView(personalizzaMenu.getNode());
        homepage.updateRightView(nuovoPiatto.getNode());
    }

    public void onGestisciAvvisiClicked() {
        homepage.removeRightView();
        homepage.updateCenterView(gestisciAvvisi.getNode());
    }


    public void onInserisciAvvisiClicked() {
        homepage.removeRightView();
        homepage.updateCenterView(inserisciAvvisi.getNode());
    }

    // Loader

    public void loadPersonalizzaMenu(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/personalizza-menu.fxml"));
            loader.load();
            this.personalizzaMenu = loader.getController();
            this.personalizzaMenu.setNode(loader.getRoot());
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
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
