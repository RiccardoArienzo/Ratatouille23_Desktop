package com.example.ratatouille23.Controller;

import com.example.ratatouille23.Main;
import com.example.ratatouille23.Model.Avviso;
import com.example.ratatouille23.Model.DAO.DAOImplUnirest.AvvisoDAOImplUnirest;
import com.example.ratatouille23.Model.DAO.DAOInterface.AvvisoDAO;
import com.example.ratatouille23.Model.DTO.AvvisoDTO;
import com.example.ratatouille23.Model.DTO.UtenteDTO;
import com.example.ratatouille23.Model.UtenteAvviso;
import com.example.ratatouille23.View.GestisciAvvisiView;
import com.example.ratatouille23.View.AddettoSala.HomepageSalaView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GestisciAvvisiController {

    private GestisciAvvisiView gestisciAvvisi;
    private HomepageSalaView homepage;
    private AvvisoDAO avvisoDAO;

    public GestisciAvvisiController(GestisciAvvisiView view){
        this.gestisciAvvisi = view;
        avvisoDAO = new AvvisoDAOImplUnirest();
    }


    // Event handler

    public void onBtnVisualizzaAvvisiNascostiClicked() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/avvisi-nascosti.fxml"));
            Stage newStage = new Stage();
            newStage.initOwner(Main.getPrimaryStage());
            newStage.initModality(Modality.APPLICATION_MODAL); // Questa riga rende la nuova finestra modale rispetto alla finestra principale
            newStage.setScene(new Scene(loader.load()));
            newStage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkAvvisiNonLetti(){
        // Se ci sono avvisi non letti per l'utente corrente
        return false;
        // altrimenti return false
    }

    public List<Avviso> ottieniAvviso(UtenteDTO utenteDTO){

        return avvisoDAO.getAvvisiNonLettiPerUtente(utenteDTO);
//        return null;
    }

//    public void onAvvisoLetto(AvvisoDTO avvisoDTO) {
//
//        avvisoDAO.modificaStatoAvviso(avvisoDTO);
//
//    }

    public void onAvvisoLetto(AvvisoDTO avvisoDTO, UtenteDTO utenteDTO) {

        avvisoDAO.modificaStatoAvviso(avvisoDTO, utenteDTO);

    }

    public void nascondiAvviso(AvvisoDTO avv, UtenteDTO utenteDTO) {

        avvisoDAO.nascondiAvviso(avv, utenteDTO);
    }

    public List<UtenteAvviso> ottieniUtenteAvvisi(UtenteDTO utenteDTO) {
       return avvisoDAO.getListUtenteAvviso(utenteDTO);
    }
}
