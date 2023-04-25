package com.example.ratatouille23.Model.DAO.DAOImplUnirest;

import com.example.ratatouille23.Model.Categoria;
import com.example.ratatouille23.Model.DAO.DAOInterface.OrdinazioneDAO;
import com.example.ratatouille23.Model.Ordinazione;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrdinazioneDAOImplUnirest implements OrdinazioneDAO {

    @Override
    public Optional<List<Ordinazione>> getOrdinazioneOrderByTavolo() {
        try {

            HttpResponse<JsonNode> apiResponse = Unirest.get("http://localhost:8080/api/v1/ordinazione/getOrdinazioni").asJson();

            Type ordinazioneListType = new TypeToken<ArrayList<Ordinazione>>(){}.getType();

            ArrayList<Ordinazione> ord = new Gson().fromJson(apiResponse.getBody().toString(), ordinazioneListType);

            return Optional.ofNullable(ord);
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

    @Override
    public void sendOrdinazione(Ordinazione ordinazione) {

        try {
            HttpResponse<JsonNode> response = Unirest.post("http://localhost:8080/api/v1/ordinazione/postOrdinazione")
                    .header("accept", "application/json")
                    .field("tavolo", ordinazione.getIdTavolo())
                    .field("evasa", ordinazione.getStato())
                    .asJson();
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void setOrdinazioneEvasa(Ordinazione ordinazione) {

    }
}
