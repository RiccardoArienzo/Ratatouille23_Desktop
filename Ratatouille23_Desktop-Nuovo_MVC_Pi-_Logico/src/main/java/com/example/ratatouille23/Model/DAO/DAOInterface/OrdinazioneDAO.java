package com.example.ratatouille23.Model.DAO.DAOInterface;

import com.example.ratatouille23.Model.DTO.InfoOrdineDTO;
import com.example.ratatouille23.Model.DTO.OrdinazioneDTO;
import com.example.ratatouille23.Model.InfoOrdine;
import com.example.ratatouille23.Model.Ordinazione;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface OrdinazioneDAO {


    public List<Ordinazione> getOrdinazioneOrderByTavolo();


    public Optional<List<Ordinazione>> getOrdinazioniEvase();


//    public void sendOrdinazione(OrdinazioneDTO ordinazione);

    public void sendOrdinazione(Ordinazione ordinazione);

    public void modificaStatoOrdinazioneInPreparazione(InfoOrdineDTO infoOrdine);

    public void setOrdinazioneEvasa(Ordinazione ordinazione);

    public List<InfoOrdine> getInfoOrdine();
}
