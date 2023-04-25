package com.example.ratatouille23.Model.DAO.DAOInterface;

import com.example.ratatouille23.Model.Avviso;
import com.example.ratatouille23.Model.Utente;

import java.util.List;
import java.util.Optional;

public interface AvvisoDAO {

    public List<Avviso> getAvvisi();

    public Optional<Avviso> getAvvisiNonLettiPerUtente(Utente utente);

    public void addAvviso(Avviso avviso);
}
