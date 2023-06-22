package com.example.ratatouille23.Controller.AddettoCucina;

import com.example.ratatouille23.Model.DAO.DAOImplUnirest.OrdinazioneDAOImplUnirest;
import com.example.ratatouille23.Model.DAO.DAOInterface.OrdinazioneDAO;
import com.example.ratatouille23.Model.DTO.InfoOrdineDTO;
import com.example.ratatouille23.Model.InfoOrdine;
import com.example.ratatouille23.Model.Ordinazione;
import com.example.ratatouille23.Model.Piatto;
import com.example.ratatouille23.View.AddettoCucina.GestisciOrdinazioniView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GestisciOrdinazioniController {

    GestisciOrdinazioniView gestisciOrdinazioni;

    //TODO inserire anche HomepageCucinaView?
    private OrdinazioneDAO ordinazioneDAO;


    public GestisciOrdinazioniController(GestisciOrdinazioniView view){
        this.gestisciOrdinazioni = view;
        ordinazioneDAO = new OrdinazioneDAOImplUnirest();
    }


    public List<Ordinazione> ottieniOrdinazioni(){
        return ordinazioneDAO.getOrdinazioneOrderByTavolo();
    }


    public List<InfoOrdine> ottieniInfoOrdini() {
        return ordinazioneDAO.getInfoOrdine();
    }

    public void modificaStatoOrdinazioneInPreparazione(Ordinazione ordinazione, Piatto piatto) {
        InfoOrdineDTO infoOrdineDTO = new InfoOrdineDTO();
        infoOrdineDTO.setOrdinazione(ordinazione.getIdOrdinazione());
        infoOrdineDTO.setPiatto(piatto.getIdPiatto());
        ordinazioneDAO.modificaStatoOrdinazioneInPreparazione(infoOrdineDTO);
        System.out.println("Ho oltrepassato la chiamata al DAO PUT in GestisciOrdinazioniController");
    }
}
