package com.example.ratatouille23.Model.DAO.DAOInterface;

import com.example.ratatouille23.Model.MediaOrdinazioniPerGiornate;

import java.time.LocalDate;
import java.util.List;

public interface MediaOrdinazioniPerGiornateDAO {

    public List<MediaOrdinazioniPerGiornate> getValore(LocalDate inizio, LocalDate fine);

}
