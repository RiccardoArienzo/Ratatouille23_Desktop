package com.example.ratatouille23.homepage;

import com.example.ratatouille23.creaUtente.SchermataCreaUtente;
import com.example.ratatouille23.personalizzaMenu.SchermataPersonalizzaMenu;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HomepageController {


    private SchermataPersonalizzaMenu personalizzaMenu = new SchermataPersonalizzaMenu();
    private SchermataCreaUtente creaUtente = new SchermataCreaUtente();



    public void clickPulsantePersonalizzaMenu(ActionEvent event){
        try {
            personalizzaMenu.apriSchermataPersonalizzaMenu(event);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickPulsanteCreaUtente(ActionEvent event){
        try {
            creaUtente.apriSchermataCreaUtente(event);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
