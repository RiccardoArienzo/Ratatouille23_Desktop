package com.example.ratatouille23.Model.DAO.DAOInterface;

import com.example.ratatouille23.Model.Ordinazione;

import java.util.List;
import java.util.Optional;

public interface OrdinazioneDAO {


    public Optional<List<Ordinazione>> getOrdinazioneOrderByTavolo();


    public Optional<List<Ordinazione>> getOrdinazioniEvase();


    public void sendOrdinazione(Ordinazione ordinazione);


    public void setOrdinazioneEvasa(Ordinazione ordinazione);

}
