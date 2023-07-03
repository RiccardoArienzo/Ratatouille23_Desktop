package com.example.ratatouille23.Model.DAO.DAOInterface;

import com.example.ratatouille23.Model.DTO.InfoOrdineDTO;
import com.example.ratatouille23.Model.Ordinazione;
import com.example.ratatouille23.Model.Piatto;

public interface InfoOrdineDAO {

//    public void setUsernameAdettoAllaCucina(String username, Ordinazione ordinazione, Piatto piatto);

    public void setUsernameAdettoAllaCucina(InfoOrdineDTO infoOrdineDTO);

    public void modificaStatoOrdinazioneInPreparazione(InfoOrdineDTO infoOrdine);

}
