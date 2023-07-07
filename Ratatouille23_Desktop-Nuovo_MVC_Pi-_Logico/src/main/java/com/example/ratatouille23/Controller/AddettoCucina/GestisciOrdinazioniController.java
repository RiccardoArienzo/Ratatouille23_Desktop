package com.example.ratatouille23.Controller.AddettoCucina;

import com.example.ratatouille23.Main;
import com.example.ratatouille23.Model.DAO.DAOImplUnirest.InfoOrdineDAOImplUnirest;
import com.example.ratatouille23.Model.DAO.DAOImplUnirest.OrdinazioneDAOImplUnirest;
import com.example.ratatouille23.Model.DAO.DAOInterface.InfoOrdineDAO;
import com.example.ratatouille23.Model.DAO.DAOInterface.OrdinazioneDAO;
import com.example.ratatouille23.Model.DTO.InfoOrdineDTO;
import com.example.ratatouille23.Model.InfoOrdine;
import com.example.ratatouille23.Model.Ordinazione;
import com.example.ratatouille23.Model.Piatto;
import com.example.ratatouille23.View.AddettoCucina.GestisciOrdinazioniView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GestisciOrdinazioniController {

    GestisciOrdinazioniView gestisciOrdinazioni;

    //TODO inserire anche HomepageCucinaView?
    private OrdinazioneDAO ordinazioneDAO;
    private InfoOrdineDAO infoOrdineDAO;


    public GestisciOrdinazioniController(GestisciOrdinazioniView view){
        this.gestisciOrdinazioni = view;
        ordinazioneDAO = new OrdinazioneDAOImplUnirest();
        infoOrdineDAO = new InfoOrdineDAOImplUnirest();
    }


    public List<Ordinazione> ottieniOrdinazioni(){
        return ordinazioneDAO.getOrdinazioneOrderByTavolo();
    }


    public List<InfoOrdine> ottieniInfoOrdini() {
        return ordinazioneDAO.getInfoOrdine();
    }

    public void modificaStatoOrdinazioneInPreparazione(Ordinazione ordinazione, Piatto piatto) {
        InfoOrdineDTO infoOrdineDTO = new InfoOrdineDTO();
        infoOrdineDTO.setOrdinazione(ordinazione.getIdOrdinazione());
        infoOrdineDTO.setPiatto(piatto.getIdPiatto());
        infoOrdineDTO.setStato(InfoOrdine.StatoOrdine.IN_PREPARAZIONE);
        infoOrdineDAO.modificaStatoOrdinazione(infoOrdineDTO);
        System.out.println("Ho oltrepassato la chiamata al DAO PUT in GestisciOrdinazioniController");
    }

    public void setUsernameAddettoAllaCucina(String username, Ordinazione ordinazione, Piatto piatto) {
        InfoOrdineDTO infoOrdineDTO = new InfoOrdineDTO();
        infoOrdineDTO.setOrdinazione(ordinazione.getIdOrdinazione());
        infoOrdineDTO.setPiatto(piatto.getIdPiatto());
        infoOrdineDTO.setUsername(username);
        System.out.println("Sono nel metodo setUsernameAddettoAllaCucina. In questo momento lo username è " + username);
        infoOrdineDAO.setUsernameAdettoAllaCucina(infoOrdineDTO);
    }

    public void modificaStatoOrdinazioneCompletato(Ordinazione ordinazione, Piatto piatto) {
        InfoOrdineDTO infoOrdineDTO = new InfoOrdineDTO();
        infoOrdineDTO.setOrdinazione(ordinazione.getIdOrdinazione());
        infoOrdineDTO.setPiatto(piatto.getIdPiatto());
        infoOrdineDTO.setStato(InfoOrdine.StatoOrdine.COMPLETATO);
        infoOrdineDAO.modificaStatoOrdinazione(infoOrdineDTO);
        System.out.println("Ho oltrepassato la chiamata al DAO PUT in GestisciOrdinazioniController");
    }

    public void onBtnOrdinazioniEvaseClicked() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ordinazioni-evase.fxml"));
            Stage newStage = new Stage();
            newStage.initOwner(Main.getPrimaryStage());
            newStage.initModality(Modality.APPLICATION_MODAL); // Questa riga rende la nuova finestra modale rispetto alla finestra principale
            newStage.setScene(new Scene(loader.load()));
            newStage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
