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
import com.example.ratatouille23.View.Admin.StatisticheView;

import java.time.LocalDate;
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


    public List<ValoreTotalePerAddetto> getValoriTotaliPerAddetto(LocalDate datePickerInizioValue, LocalDate datePickerFineValue) {
        return valoreTotalePerAddettoDAO.getValore(datePickerInizioValue, datePickerFineValue);
    }

    public List<NumeroOrdinazioniPerAddetto> getNumeroOrdinazioni(LocalDate datePickerInizioValue, LocalDate datePickerFineValue) {
        return numeroOrdinazioniPerAddettoDAO.getValore(datePickerInizioValue, datePickerFineValue);
    }

    public List<MediaOrdinazioniPerGiornate> getMediaOrdinazioniPerGiornate(LocalDate datePickerInizioValue, LocalDate datePickerFineValue) {
        return mediaOrdinazioniPerGiornateDAO.getValore(datePickerInizioValue, datePickerFineValue);
    }
}
