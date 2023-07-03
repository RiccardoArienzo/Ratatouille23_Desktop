package com.example.ratatouille23.Model.DAO.DAOImplUnirest;

import com.example.ratatouille23.Model.DAO.DAOInterface.NumeroOrdinazioniPerAddettoDAO;
import com.example.ratatouille23.Model.NumeroOrdinazioniPerAddetto;
import com.example.ratatouille23.Model.ValoreTotalePerAddetto;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class NumeroOrdinazioniPerAddettoDAOImplUnirest implements NumeroOrdinazioniPerAddettoDAO {
    @Override
    public List<NumeroOrdinazioniPerAddetto> getValore() {
        try {

            System.out.println("Sono dentro a getValore di NumOrd.");

            HttpResponse<JsonNode> apiResponse = Unirest.get("http://localhost:8080/api/v1/numeroOrdinazioni/getValori").asJson();

            Type numeroOrdinazioni = new TypeToken<ArrayList<NumeroOrdinazioniPerAddetto>>(){}.getType();

            ArrayList<NumeroOrdinazioniPerAddetto> listView = new Gson().fromJson(apiResponse.getBody().toString(), numeroOrdinazioni);

            System.out.println("Sono all'interno del daoImpl, in particolar modo sto tornando dalla chiamata GET. Il valore della lista è uguale a :"
                    + listView);

            return listView;
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }
}
