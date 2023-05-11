package com.example.ratatouille23.Controller;

import com.example.ratatouille23.Model.DAO.DAOImplUnirest.AvvisoDAOImplUnirest;
import com.example.ratatouille23.Model.DAO.DAOInterface.AvvisoDAO;
import com.example.ratatouille23.Model.DTO.AvvisoDTO;
import com.example.ratatouille23.Model.Utente;
import com.example.ratatouille23.View.InserisciAvvisiView;

import java.time.Instant;


public class InserisciAvvisiController {

    InserisciAvvisiView inserisciAvvisi;
    AvvisoDAO avvisoDAO;

    public InserisciAvvisiController(InserisciAvvisiView view){
        this.inserisciAvvisi = view;
        this.avvisoDAO = new AvvisoDAOImplUnirest();
    }

    public void onBtnInviaClicked() {

        Instant dataInvio = Instant.now(); // O eventualmente Instant.ofEpochSecond(...)
        Instant orarioInvio = Instant.now(); // O eventualmente Instant.ofEpochMilli(...)

        AvvisoDTO avvisoDTO = new AvvisoDTO();
        avvisoDTO.setBodyAvviso(inserisciAvvisi.getCorpoAvviso().getText());
        avvisoDTO.setOggettoAvviso(inserisciAvvisi.getOggettoAvviso().getText());
        avvisoDTO.setDataInvio(dataInvio);
        avvisoDTO.setOrarioInvio(orarioInvio);
        avvisoDTO.setMittente(Utente.getUsername());

        avvisoDAO.addAvviso(avvisoDTO);
    }

    public void setInserisciAvvisi(InserisciAvvisiView inserisciAvvisi) {
        this.inserisciAvvisi = inserisciAvvisi;
    }
}
