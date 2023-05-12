package com.example.ratatouille23.Model.DAO.DAOImplUnirest;

import com.example.ratatouille23.Model.Avviso;
import com.example.ratatouille23.Model.DAO.DAOInterface.AvvisoDAO;
import com.example.ratatouille23.Model.DTO.AvvisoDTO;
import com.example.ratatouille23.Model.Utente;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.lang.reflect.Type;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AvvisoDAOImplUnirest implements AvvisoDAO {



    @Override
    public List<Avviso> getAvvisi() {

        try {
            HttpResponse<JsonNode> apiResponse = Unirest.get("http://localhost:8080/api/v1/avviso/getAvvisi").asJson();
            Type avvisoListType = new TypeToken<ArrayList<Avviso>>(){}.getType();

            ArrayList<Avviso> avvisi = new Gson().fromJson(apiResponse.getBody().toString(), avvisoListType);

            return avvisi;
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Avviso> getAvvisiNascosti() {
        try {
            HttpResponse<JsonNode> apiResponse = Unirest.get("http://localhost:8080/api/v1/avviso/getAvvisiNascosti").asJson();
            Type avvisoListType = new TypeToken<ArrayList<Avviso>>(){}.getType();

            ArrayList<Avviso> avvisi = new Gson().fromJson(apiResponse.getBody().toString(), avvisoListType);

            return avvisi;
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Optional<Avviso> getAvvisiNonLettiPerUtente(Utente utente) {
        return Optional.empty();
    }

    @Override
    public void addAvviso(AvvisoDTO avviso) {

        try {

            HttpResponse<JsonNode> response = Unirest.post("http://localhost:8080/api/v1/avviso/addAvviso")
                    .header("accept", "application/json")
                    .field("mittente", avviso.getMittente())
                    .field("oggettoAvviso", avviso.getOggettoAvviso())
                    .field("bodyAvviso", avviso.getBodyAvviso())
                    .field("dataInvio", avviso.getDataInvio())
                    .field("orarioInvio", avviso.getOrarioInvio())
                    .asJson();
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }

    }
}
