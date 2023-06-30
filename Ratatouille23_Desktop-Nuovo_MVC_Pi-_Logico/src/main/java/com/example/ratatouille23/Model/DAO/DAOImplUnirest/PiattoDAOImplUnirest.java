package com.example.ratatouille23.Model.DAO.DAOImplUnirest;

import com.example.ratatouille23.Model.DAO.DAOInterface.PiattoDAO;
import com.example.ratatouille23.Model.DTO.PiattoDTO;
import com.example.ratatouille23.Model.Piatto;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PiattoDAOImplUnirest implements PiattoDAO {
    @Override
    public void addPiatto(PiattoDTO piatto) {
        try {
            HttpResponse<JsonNode> response = Unirest.post("http://localhost:8080/api/v1/piatto/addPiatto")
                    .header("accept", "application/json")
                    .field("nome", piatto.getNome())
                    .field("descrizione", piatto.getDescrizione())
                    .field("allergeni", piatto.getAllergeni())
                    .field("costo", piatto.getCosto())
                    .field("nomeCategoria", piatto.getNomeCategoria())
//                    .field("categoria", piatto.getCategoria())
                    .asJson();
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Piatto> getPiatti() {

        try {
            HttpResponse<JsonNode> apiResponse = Unirest.get("http://localhost:8080/api/v1/piatto/getPiatti").asJson();
            Type piattoListType = new TypeToken<ArrayList<Piatto>>(){}.getType();

            ArrayList<Piatto> piatti = new Gson().fromJson(apiResponse.getBody().toString(), piattoListType);

            return piatti;
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Optional<Piatto> getPiattoByID(Long idPiatto) {

        try {
            HttpResponse<JsonNode> apiResponse = Unirest.get("http://localhost:8080/api/v1/piatto/id/idPiatto").asJson();

            Piatto piatto = new Gson().fromJson(apiResponse.getBody().toString(), Piatto.class);

            return Optional.ofNullable(piatto);

        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Optional<Piatto> getPiattoByName(String nome) {
        try {
            HttpResponse<JsonNode> apiResponse = Unirest.get("http://localhost:8080/api/v1/piatto/nome/nome").asJson();

            Piatto piatto = new Gson().fromJson(apiResponse.getBody().toString(), Piatto.class);

            return Optional.ofNullable(piatto);

        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int deletePiatto(Long idPiatto) {
        System.out.println("In questo momento l'id del piatto è: " + idPiatto);
        try {
            HttpResponse<JsonNode> apiResponse = Unirest.delete("http://localhost:8080/api/v1/piatto/delete")
              .header("accept", "application/json").
                    field("idPiatto", idPiatto).asJson();
            System.out.println("Ho effettuato una DELETE con il seguente stato: " + apiResponse.getStatus());

            return apiResponse.getStatus();
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }

    // FORSE QUESTA CHIAMATA NON FUNZIONA PERCHE' NECESSITA DI PIATTO O PIATTODTO. PROVIAMO. INOLTRE PROVARE CON
    // NAME PIUTTOSTO CHE CON ID
    @Override
    public void updatePosizionePiatto(Long idPiatto, Long piattoCounter) {
        System.out.println("In questo momento, idPiatto = " + idPiatto + " e piattoCounter = " + piattoCounter);
        try {
            HttpResponse<JsonNode> response = Unirest.put("http://localhost:8080/api/v1/piatto/aggiornaContatorePiatto")
                    .header("accept", "application/json")
                    .field("idPiatto", idPiatto)
                    .field("piattoCounter", piattoCounter)
                    .asJson();
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }

}
