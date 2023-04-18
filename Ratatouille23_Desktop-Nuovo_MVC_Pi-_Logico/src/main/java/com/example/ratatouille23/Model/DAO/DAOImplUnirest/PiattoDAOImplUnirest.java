package com.example.ratatouille23.Model.DAO.DAOImplUnirest;

import com.example.ratatouille23.Model.DAO.DAOInterface.PiattoDAO;
import com.example.ratatouille23.Model.Piatto;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class PiattoDAOImplUnirest implements PiattoDAO {
    @Override
    public void addPiatto(Piatto piatto) {
        try {
            HttpResponse<JsonNode> response = Unirest.post("http://localhost:8080/api/v1/piatto/addPiatto")
                    .header("accept", "application/json")
                    .field("nome", piatto.getNomePiatto())
                    .field("descrizione", piatto.getDescrizione())
                    .field("allergeni", piatto.getAllergeni())
                    .field("costo", piatto.getCostoPiatto())
                    .field("categoria", piatto.getCategoria())
                    .asJson();
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }
}
