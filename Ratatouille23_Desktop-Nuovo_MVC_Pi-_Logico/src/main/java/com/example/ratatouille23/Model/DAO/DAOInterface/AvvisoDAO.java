package com.example.ratatouille23.Model.DAO.DAOInterface;

import com.example.ratatouille23.Model.Avviso;
import com.example.ratatouille23.Model.DTO.AvvisoDTO;
import com.example.ratatouille23.Model.DTO.UtenteDTO;
import com.example.ratatouille23.Model.Utente;

import java.util.List;
import java.util.Optional;

public interface AvvisoDAO {

    public List<Avviso> getAvvisi();

    public List<Avviso> getAvvisiNascosti();

    public List<Avviso> getAvvisiNonLettiPerUtente(UtenteDTO utenteDTO);

    public void addAvviso(AvvisoDTO avviso);

    public void modificaStatoAvviso(AvvisoDTO avviso, UtenteDTO utente);

    public void nascondiAvviso(AvvisoDTO avviso, UtenteDTO utente);


//    public void modificaStatoAvviso(AvvisoDTO avviso);
}
