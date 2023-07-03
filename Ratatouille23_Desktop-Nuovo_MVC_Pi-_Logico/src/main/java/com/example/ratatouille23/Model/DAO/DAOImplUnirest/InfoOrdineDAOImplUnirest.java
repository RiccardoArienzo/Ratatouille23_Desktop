package com.example.ratatouille23.Model.DAO.DAOImplUnirest;

import com.example.ratatouille23.Model.DAO.DAOInterface.InfoOrdineDAO;
import com.example.ratatouille23.Model.DTO.InfoOrdineDTO;
import com.example.ratatouille23.Model.InfoOrdine;
import com.example.ratatouille23.Model.Ordinazione;
import com.example.ratatouille23.Model.Piatto;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class InfoOrdineDAOImplUnirest implements InfoOrdineDAO {
    @Override
    public void setUsernameAdettoAllaCucina(InfoOrdineDTO infoOrdineDTO) {
        System.out.println("Sono entrato nel DAO di infoOrdine. In questo momento, ");
        System.out.println("Username: " + infoOrdineDTO.getUsername() + "Ordinazione: " + infoOrdineDTO.getOrdinazione() + "Piatto: " + infoOrdineDTO.getPiatto());

        try {
            HttpResponse<JsonNode> response = Unirest.put("http://localhost:8080/api/v1/infoordine/impostaUsername")
                    .header("accept", "application/json")
                    .field("username", infoOrdineDTO.getUsername())
                    .field("ordinazione", infoOrdineDTO.getOrdinazione())
                    .field("piatto", infoOrdineDTO.getPiatto())
                    .asJson();
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void modificaStatoOrdinazioneInPreparazione(InfoOrdineDTO infoOrdine) {
        infoOrdine.setStato(InfoOrdine.StatoOrdine.IN_PREPARAZIONE);
        System.out.println("Sono entrato nel DAO. Il valore del DTO è: " + infoOrdine);
        try {
            HttpResponse<JsonNode> response = Unirest.put("http://localhost:8080/api/v1/infoordine/aggiornaStatoInPreparazione")
                    .header("accept", "application/json")
                    .field("piatto", infoOrdine.getPiatto())
                    .field("ordinazione", infoOrdine.getOrdinazione())
                    .field("stato", infoOrdine.getStato())
                    .asJson();
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }

}
