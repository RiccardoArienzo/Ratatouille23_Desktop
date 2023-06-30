package com.example.ratatouille23.Model.DAO.DAOImplUnirest;

import com.example.ratatouille23.Model.Categoria;
import com.example.ratatouille23.Model.DAO.DAOInterface.CategoriaDAO;
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

public class CategoriaDAOImplUnirest implements CategoriaDAO {


    @Override
    public List<Categoria> getCategorie() {
        try {

            HttpResponse<JsonNode> apiResponse = Unirest.get("http://localhost:8080/api/v1/categoria/categorie").asJson();

            Type  categoriaListType = new TypeToken<ArrayList<Categoria>>(){}.getType();

            ArrayList<Categoria> cat = new Gson().fromJson(apiResponse.getBody().toString(), categoriaListType);

            return cat;
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Optional<Categoria> getCategoriaByID(Long idCategoria) {
        try {
          HttpResponse<JsonNode>  apiResponse = Unirest.get("http://localhost:8080/api/v1/categoria/id/idCategoria").asJson();

            Categoria cat = new Gson().fromJson(apiResponse.getBody().toString(), Categoria.class);

            return Optional.ofNullable(cat);

        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }



    }

    @Override
    public Categoria getCategoriaByName(String nomeCategoria) {
        try {
            HttpResponse<JsonNode>  apiResponse = Unirest.get("http://localhost:8080/api/v1/categoria/nomeCategoria").asJson();

            Categoria cat = new Gson().fromJson(apiResponse.getBody().toString(), Categoria.class);

            return cat;

        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addCategoria(Categoria categoria) {
        try {
            HttpResponse<JsonNode> response = Unirest.post("http://localhost:8080/api/v1/categoria/addCategoria")
                    .header("accept", "application/json")
                    .field("nomeCategoria", categoria.getNome())
                    .asJson();
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int deleteCategoria(Long idCategoria) {
        System.out.println("In questo momento l'id della piatto è: " + idCategoria);
        try {
            HttpResponse<JsonNode> apiResponse = Unirest.delete("http://localhost:8080/api/v1/categoria/delete")
                    .header("accept", "application/json").
                    field("idCategoria", idCategoria).asJson();
            System.out.println("Ho effettuato una DELETE con il seguente stato: " + apiResponse.getStatus());
            return apiResponse.getStatus();
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updatePosizioneCategoria(Long idCategoria, Long categoriaCounter) {
        System.out.println("In questo momento, idCategoria = " + idCategoria + " e categoriaCounter = " + categoriaCounter);
        try {
            HttpResponse<JsonNode> response = Unirest.put("http://localhost:8080/api/v1/categoria/aggiornaContatoreCategoria")
                    .header("accept", "application/json")
                    .field("idCategoria", idCategoria)
                    .field("categoriaCounter", categoriaCounter)
                    .asJson();
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }

}

