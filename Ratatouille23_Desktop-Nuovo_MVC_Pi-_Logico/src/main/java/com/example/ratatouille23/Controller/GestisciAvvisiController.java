package com.example.ratatouille23.Controller;

import com.example.ratatouille23.Model.Avviso;
import com.example.ratatouille23.Model.DAO.DAOImplUnirest.AvvisoDAOImplUnirest;
import com.example.ratatouille23.Model.DAO.DAOInterface.AvvisoDAO;
import com.example.ratatouille23.View.GestisciAvvisiView;
import com.example.ratatouille23.View.AddettoSala.HomepageSalaView;

import java.util.List;

public class GestisciAvvisiController {

    private GestisciAvvisiView gestisciAvvisi;
    private HomepageSalaView homepage;
    private AvvisoDAO avvisoDAO;

    public GestisciAvvisiController(GestisciAvvisiView view){
        this.gestisciAvvisi = view;
        avvisoDAO = new AvvisoDAOImplUnirest();
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

    public List<Avviso> ottieniAvviso(){
        return avvisoDAO.getAvvisi();
//        return null;
    }

}
