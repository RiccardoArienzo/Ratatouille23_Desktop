package com.example.ratatouille23.Model.DAO.DAOImplUnirest;

import com.example.ratatouille23.Model.DAO.DAOInterface.OrdinazioneDAO;
import com.example.ratatouille23.Model.DTO.InfoOrdineDTO;
import com.example.ratatouille23.Model.DTO.OrdinazioneDTO;
import com.example.ratatouille23.Model.DTO.PiattoDTO;
import com.example.ratatouille23.Model.InfoOrdine;
import com.example.ratatouille23.Model.Ordinazione;
import com.example.ratatouille23.Model.Piatto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.lang.reflect.Type;
import java.util.*;

public class OrdinazioneDAOImplUnirest implements OrdinazioneDAO {

    @Override
    public List<Ordinazione> getOrdinazioneOrderByTavolo() {
        try {

            HttpResponse<JsonNode> apiResponse = Unirest.get("http://localhost:8080/api/v1/ordinazione/getOrdinazioni").asJson();

            Type ordinazioneListType = new TypeToken<ArrayList<Ordinazione>>(){}.getType();

            ArrayList<Ordinazione> ord = new Gson().fromJson(apiResponse.getBody().toString(), ordinazioneListType);

            return ord;
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<List<Ordinazione>> getOrdinazioniEvase() {
        try {

            HttpResponse<JsonNode> apiResponse = Unirest.get("http://localhost:8080/api/v1/ordinazione/getOrdinazioni").asJson();

            Type ordinazioneListType = new TypeToken<ArrayList<Ordinazione>>(){}.getType();

            ArrayList<Ordinazione> ord = new Gson().fromJson(apiResponse.getBody().toString(), ordinazioneListType);

            return Optional.ofNullable(ord);
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }

    /*Questa versione dovrà inviare la mappa convertita in collection e set*/

//    @Override
//    public void sendOrdinazione(OrdinazioneDTO ordinazione) {
//
//        try {
//            Gson gson = new Gson();
//            String jsonSet = gson.toJson(ordinazione.getPiattoSet());
//            String jsonCollection = gson.toJson(ordinazione.getInfoOrdineCollection());
////            ObjectMapper objectMapper = new ObjectMapper();
////            ObjectMapper objectMapper = new ObjectMapper();
//            String requestBody = objectMapper.writeValueAsString(ordinazione);
//            System.out.println("Questo è il valore di requestBody: " + requestBody);
//            HttpResponse<JsonNode> response = Unirest.post("http://localhost:8080/api/v1/ordinazione/postOrdinazione")
//                    .header("accept", "application/json")
////                    .field("idTavolo", ordinazione.getIdTavolo())
////                    .field("infoPiatto", ordinazione.getInfoPiatto())
//                    // SE USO IL .body DEVO UTILIZZARE @RequestBody NEL CONTROLLER
//                    .body(requestBody)
//                    .asJson();
//            System.out.println("Stu sfaccimm è ugual a chest: " + ordinazione.getInfoPiatto());
//        } catch (UnirestException | JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//
//    }

    /* Questa versione dovrà inviare la mappa con Gson  */

        @Override
    public void sendOrdinazione(Ordinazione ordinazione) {

        try {

            System.out.println("Ordinazione prima di serializzare è uguale a sta roba: " + ordinazione);
            Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
            String json = gson.toJson(ordinazione.getInfoPiatto());
            System.out.println("La mappa serializzata è la seguente: " + json);

            HttpResponse<JsonNode> response = Unirest.post("http://localhost:8080/api/v1/ordinazione/postOrdinazione")
                    .header("accept", "application/json")
//                    .field("idTavolo", ordinazione.getIdTavolo())
//                    .field("infoPiatto", ordinazione.getInfoPiatto())
                    // SE USO IL .body DEVO UTILIZZARE @RequestBody NEL CONTROLLER
                    .field("idTavolo", ordinazione.getIdTavolo())
                    .field("evasa", ordinazione.isEvasa())
                    .field("infoPiatto", json)
                    .asJson();
            System.out.println("Stu sfaccimm è ugual a chest: " + ordinazione.getInfoPiatto());
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void modificaStatoOrdinazioneInPreparazione(InfoOrdineDTO infoOrdine) {
            infoOrdine.setStato(InfoOrdine.StatoOrdine.IN_PREPARAZIONE);
        System.out.println("Sono entrato nel DAO. Il valore del DTO è: " + infoOrdine);
        try {
            HttpResponse<JsonNode> response = Unirest.put("http://localhost:8080/api/v1/ordinazione/aggiornaStatoInPreparazione")
                    .header("accept", "application/json")
                    .field("piatto", infoOrdine.getPiatto())
                    .field("ordinazione", infoOrdine.getOrdinazione())
                    .field("stato", infoOrdine.getStato())
                    .asJson();
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }



    /* VERSIONE CHE INVIA L'OGGETTO SERIALIZZATO */
//    @Override
//    public void sendOrdinazione(Ordinazione ordinazione) {
//
//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
////            ObjectMapper objectMapper = new ObjectMapper();
//            String requestBody = objectMapper.writeValueAsString(ordinazione);
//            System.out.println("Questo è il valore di requestBody: " + requestBody);
//            HttpResponse<JsonNode> response = Unirest.post("http://localhost:8080/api/v1/ordinazione/postOrdinazione")
//                    .header("accept", "application/json")
////                    .field("idTavolo", ordinazione.getIdTavolo())
////                    .field("infoPiatto", ordinazione.getInfoPiatto())
//                    // SE USO IL .body DEVO UTILIZZARE @RequestBody NEL CONTROLLER
//                    .body(requestBody)
//                    .asJson();
//            System.out.println("Stu sfaccimm è ugual a chest: " + ordinazione);
//        } catch (UnirestException | JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//
//    }

    @Override
    public void setOrdinazioneEvasa(Ordinazione ordinazione) {

    }

    @Override
    public List<InfoOrdine> getInfoOrdine() {
        try {

            HttpResponse<JsonNode> apiResponse = Unirest.get("http://localhost:8080/api/v1/ordinazione/getInfoOrdini").asJson();

            Type infoOrdiniListType = new TypeToken<ArrayList<InfoOrdine>>(){}.getType();

            ArrayList<InfoOrdine> io = new Gson().fromJson(apiResponse.getBody().toString(), infoOrdiniListType);

            return io;
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }
}
