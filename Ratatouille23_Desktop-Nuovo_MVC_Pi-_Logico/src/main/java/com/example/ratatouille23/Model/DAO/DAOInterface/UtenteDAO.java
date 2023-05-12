package com.example.ratatouille23.Model.DAO.DAOInterface;

import com.example.ratatouille23.Model.DTO.UtenteDTO;
import com.example.ratatouille23.Model.Utente;

import java.util.List;

public interface UtenteDAO {

    public List<Utente> getUtenti();

    public Utente getUtenteByEmail(String email);

    public List<Utente> getUtenteByGroup(String gruppo);

    public void addUtente(UtenteDTO utente);

}
