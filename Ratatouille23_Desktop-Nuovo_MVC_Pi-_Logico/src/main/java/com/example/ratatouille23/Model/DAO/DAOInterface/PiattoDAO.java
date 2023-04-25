package com.example.ratatouille23.Model.DAO.DAOInterface;

import com.example.ratatouille23.Model.Piatto;

import java.util.List;
import java.util.Optional;

public interface PiattoDAO {

    public void addPiatto(Piatto piatto);

    public List<Piatto> getPiatti();

    public Optional<Piatto> getPiattoByID(Long idPiatto);

    public Optional<Piatto> getPiattoByName(String nome);

    public void deletePiatto(Long idPiatto);
}
