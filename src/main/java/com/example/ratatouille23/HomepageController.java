package com.example.ratatouille23;

import com.example.ratatouille23.View.AddettoCucina.GestisciOrdinazioniView;
import com.example.ratatouille23.View.AddettoSala.RegistraOrdinazioniView;
import com.example.ratatouille23.View.Admin.CreaUtenteView;
import com.example.ratatouille23.View.GestisciAvvisiView;
import com.example.ratatouille23.View.InserisciAvvisiView;
import com.example.ratatouille23.View.NuovoPiattoView;
import com.example.ratatouille23.View.PersonalizzaMenuView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public abstract class HomepageController {

    protected Homepage homepage;
    protected GestisciAvvisiView gestisciAvvisi;

    public HomepageController(Homepage home) {
        this.homepage = home;
        loadGestisciAvvisi();
    }


    // Loader

    public void loadGestisciAvvisi(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gestisci-avvisi.fxml"));
            loader.load();
            gestisciAvvisi = loader.getController();
            gestisciAvvisi.setNode(loader.getRoot());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
