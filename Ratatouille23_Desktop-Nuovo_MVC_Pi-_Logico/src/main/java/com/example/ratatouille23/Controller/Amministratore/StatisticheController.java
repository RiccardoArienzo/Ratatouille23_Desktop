package com.example.ratatouille23.Controller.Amministratore;

import com.example.ratatouille23.Model.DAO.DAOImplUnirest.MediaOrdinazioniPerGiornateDAOImplUnirest;
import com.example.ratatouille23.Model.DAO.DAOImplUnirest.NumeroOrdinazioniPerAddettoDAOImplUnirest;
import com.example.ratatouille23.Model.DAO.DAOImplUnirest.ValoreTotalePerAddettoDAOImplUnirest;
import com.example.ratatouille23.Model.DAO.DAOInterface.MediaOrdinazioniPerGiornateDAO;
import com.example.ratatouille23.Model.DAO.DAOInterface.NumeroOrdinazioniPerAddettoDAO;
import com.example.ratatouille23.Model.DAO.DAOInterface.ValoreTotalePerAddettoDAO;
import com.example.ratatouille23.Model.MediaOrdinazioniPerGiornate;
import com.example.ratatouille23.Model.NumeroOrdinazioniPerAddetto;
import com.example.ratatouille23.Model.ValoreTotalePerAddetto;
import com.example.ratatouille23.View.Admin.CreaUtenteView;
import com.example.ratatouille23.View.Admin.StatisticheView;

import java.util.ArrayList;
import java.util.List;

public class StatisticheController {

    private StatisticheView view;
    private ValoreTotalePerAddettoDAO valoreTotalePerAddettoDAO;
    private NumeroOrdinazioniPerAddettoDAO numeroOrdinazioniPerAddettoDAO;
    private MediaOrdinazioniPerGiornateDAO mediaOrdinazioniPerGiornateDAO;

    public StatisticheController(StatisticheView view){
        this.view = view;
        valoreTotalePerAddettoDAO = new ValoreTotalePerAddettoDAOImplUnirest();
        numeroOrdinazioniPerAddettoDAO = new NumeroOrdinazioniPerAddettoDAOImplUnirest();
        mediaOrdinazioniPerGiornateDAO = new MediaOrdinazioniPerGiornateDAOImplUnirest();
    }


    public List<ValoreTotalePerAddetto> getValoriTotaliPerAddetto() {
        return valoreTotalePerAddettoDAO.getValore();
    }

    public List<NumeroOrdinazioniPerAddetto> getNumeroOrdinazioni() {
        return numeroOrdinazioniPerAddettoDAO.getValore();
    }

    public List<MediaOrdinazioniPerGiornate> getMediaOrdinazioniPerGiornate() {
        return mediaOrdinazioniPerGiornateDAO.getValore();
    }
}
