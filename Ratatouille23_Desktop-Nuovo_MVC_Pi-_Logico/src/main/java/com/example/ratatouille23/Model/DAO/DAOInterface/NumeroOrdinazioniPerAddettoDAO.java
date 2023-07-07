package com.example.ratatouille23.Model.DAO.DAOInterface;

import com.example.ratatouille23.Model.NumeroOrdinazioniPerAddetto;

import java.time.LocalDate;
import java.util.List;

public interface NumeroOrdinazioniPerAddettoDAO {

    public List<NumeroOrdinazioniPerAddetto> getValore(LocalDate inizio, LocalDate fine);
}
