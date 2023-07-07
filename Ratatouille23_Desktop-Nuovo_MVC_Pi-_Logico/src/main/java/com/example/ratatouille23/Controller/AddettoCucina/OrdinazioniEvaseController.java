package com.example.ratatouille23.Controller.AddettoCucina;

import com.example.ratatouille23.Model.DAO.DAOImplUnirest.OrdinazioneDAOImplUnirest;
import com.example.ratatouille23.Model.DAO.DAOInterface.OrdinazioneDAO;
import com.example.ratatouille23.Model.InfoOrdine;
import com.example.ratatouille23.Model.Ordinazione;
import com.example.ratatouille23.View.AddettoCucina.GestisciOrdinazioniView;
import com.example.ratatouille23.View.AddettoCucina.OrdinazioniEvaseView;

import java.util.List;

public class OrdinazioniEvaseController {

    OrdinazioniEvaseView ordinazioniEvase;

    OrdinazioneDAO ordinazioneDAO;



    public OrdinazioniEvaseController(OrdinazioniEvaseView view){
        this.ordinazioniEvase = view;
        this.ordinazioneDAO = new OrdinazioneDAOImplUnirest();
    }

    public List<Ordinazione> ottieniOrdinazioniEvase() {
        return ordinazioneDAO.getOrdinazioniEvase();
    }

    public List<InfoOrdine> ottieniInfoOrdini() {
        return ordinazioneDAO.getInfoOrdine();
    }
}
