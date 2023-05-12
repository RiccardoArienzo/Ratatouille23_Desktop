package com.example.ratatouille23.Model.DAO.DAOImplUnirest;

import com.example.ratatouille23.Model.DAO.DAOInterface.UtenteDAO;
import com.example.ratatouille23.Model.DTO.UtenteDTO;
import com.example.ratatouille23.Model.Piatto;
import com.example.ratatouille23.Model.Utente;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class UtenteDAOImplUnirest implements UtenteDAO {
    @Override
    public List<Utente> getUtenti() {

        try {
            HttpResponse<JsonNode> apiResponse = Unirest.get("http://localhost:8080/api/v1/utente/getUtenti").asJson();
            Type utenteListType = new TypeToken<ArrayList<Utente>>(){}.getType();

            ArrayList<Utente> utenti = new Gson().fromJson(apiResponse.getBody().toString(), utenteListType);

            return utenti;
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Utente getUtenteByEmail(String email) {
        return null;
    }

    @Override
    public List<Utente> getUtenteByGroup(String group) {
        return null;
    }

    @Override
    public void addUtente(UtenteDTO utente) {
        try {
            HttpResponse<JsonNode> response = Unirest.post("http://localhost:8080/api/v1/utente/addUtente")
                    .header("accept", "application/json")
                    .field("email", utente.getEmail())
                    .field("username", utente.getUsername())
                    .field("gruppo", utente.getGruppo())
                    .asJson();
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }
}
