package com.example.ratatouille23.Model.DAO.DAOImplUnirest;

import com.example.ratatouille23.Model.DAO.DAOInterface.ValoreTotalePerAddettoDAO;
import com.example.ratatouille23.Model.DTO.UtenteDTO;
import com.example.ratatouille23.Model.Ordinazione;
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
import java.util.Map;

public class ValoreTotalePerAddettoDAOImplUnirest implements ValoreTotalePerAddettoDAO {


    @Override
    public List<ValoreTotalePerAddetto> getValore() {
        try {

            System.out.println("Sono dentro a getValore di ValTot.");

            HttpResponse<JsonNode> apiResponse = Unirest.get("http://localhost:8080/api/v1/valoreTotale/getValori").asJson();

            Type valoriPerAddetto = new TypeToken<ArrayList<ValoreTotalePerAddetto>>(){}.getType();

            ArrayList<ValoreTotalePerAddetto> listView = new Gson().fromJson(apiResponse.getBody().toString(), valoriPerAddetto);

            System.out.println("Sono all'interno del daoImpl, in particolar modo sto tornando dalla chiamata GET. Il valore della lista è uguale a :"
               + listView);

            return listView;
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }
}
