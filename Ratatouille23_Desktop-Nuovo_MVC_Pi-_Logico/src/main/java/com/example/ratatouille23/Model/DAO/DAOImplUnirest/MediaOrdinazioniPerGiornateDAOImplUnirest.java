package com.example.ratatouille23.Model.DAO.DAOImplUnirest;

import com.example.ratatouille23.Model.DAO.DAOInterface.MediaOrdinazioniPerGiornateDAO;
import com.example.ratatouille23.Model.MediaOrdinazioniPerGiornate;
import com.example.ratatouille23.Model.NumeroOrdinazioniPerAddetto;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MediaOrdinazioniPerGiornateDAOImplUnirest implements MediaOrdinazioniPerGiornateDAO {


    @Override
    public List<MediaOrdinazioniPerGiornate> getValore(LocalDate inizio, LocalDate fine) {
        try {

            System.out.println("Sono dentro a getValore di AvgOrd.");

            HttpResponse<JsonNode> apiResponse = Unirest.get("http://localhost:8080/api/v1/mediaOrdinazioni/getValori")
                    .queryString("inizio", inizio.toString())
                    .queryString("fine", fine.toString())
                    .asJson();

            Type mediaOrdinazioni = new TypeToken<ArrayList<MediaOrdinazioniPerGiornate>>(){}.getType();

            ArrayList<MediaOrdinazioniPerGiornate> listView = new Gson().fromJson(apiResponse.getBody().toString(), mediaOrdinazioni);

            System.out.println("Sono all'interno del daoImpl, in particolar modo sto tornando dalla chiamata GET. Il valore della lista è uguale a :"
                    + listView);

            return listView;
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }
}
