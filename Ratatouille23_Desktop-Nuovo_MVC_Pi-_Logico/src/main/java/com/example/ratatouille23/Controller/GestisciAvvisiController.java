package com.example.ratatouille23.Controller;

import com.example.ratatouille23.View.GestisciAvvisiView;
import com.example.ratatouille23.View.AddettoSala.HomepageSalaView;

public class GestisciAvvisiController {

    GestisciAvvisiView gestisciAvvisi;
    HomepageSalaView homepage;

    public GestisciAvvisiController(GestisciAvvisiView view){
        this.gestisciAvvisi = view;
    }


    // Event handler

    public void onBtnVisualizzaAvvisiNascostiClicked() {
        //
    }

    public boolean checkAvvisiNonLetti(){
        // Se ci sono avvisi non letti per l'utente corrente
        return false;
        // altrimenti return false
    }
}
