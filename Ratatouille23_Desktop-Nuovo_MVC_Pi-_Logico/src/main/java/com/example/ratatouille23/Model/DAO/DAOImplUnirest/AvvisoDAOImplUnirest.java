package com.example.ratatouille23.Model.DAO.DAOImplUnirest;

import com.example.ratatouille23.Model.Avviso;
import com.example.ratatouille23.Model.DAO.DAOInterface.AvvisoDAO;
import com.example.ratatouille23.Model.DTO.AvvisoDTO;
import com.example.ratatouille23.Model.DTO.UtenteDTO;
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

//    @Override
//    public List<Avviso> getAvvisiNonLettiPerUtente(UtenteDTO utenteDTO){
//        try {
//
//
//            HttpResponse<JsonNode> response = Unirest.post("http://localhost:8080/api/v1/avviso/getAvvisoNonLetto/utenteDTO")
//                    .header("accept", "application/json")
//                    .field("username", utenteDTO.getUsername())
//                    .field("gruppo", utenteDTO.getGruppo())
//                    .field("email", utenteDTO.getEmail())
//                    .asJson();
//
//
//            HttpResponse<JsonNode> apiResponse = Unirest.get("http://localhost:8080/api/v1/avviso/getAvvisoNonLetto").asJson();
//            Type avvisoListType = new TypeToken<ArrayList<Avviso>>(){}.getType();
//
//            ArrayList<Avviso> avvisi = new Gson().fromJson(apiResponse.getBody().toString(), avvisoListType);
//
//            return avvisi;
//        } catch (UnirestException e) {
//            throw new RuntimeException(e);
//        }
//    }

    //versione forse buona
    @Override
    public List<Avviso> getAvvisiNonLettiPerUtente(UtenteDTO utenteDTO) {
        try {
            Gson gson = new Gson();
            String utenteJson = gson.toJson(utenteDTO);
//            System.out.println("CHEST è L'UTENTE: " + utenteDTO);
            System.out.println("CHEST è L'UTENTE: " + utenteJson);


            HttpResponse<JsonNode> apiResponse = Unirest.get("http://localhost:8080/api/v1/avviso/getAvvisoNonLetto")
//                    .queryString("utenteDTO", utenteDTO)
                    .queryString("utenteDTO", utenteJson)
                    .asJson();

            Type avvisoListType = new TypeToken<ArrayList<Avviso>>(){}.getType();
//            ArrayList<Avviso> avvisi = new Gson().fromJson(apiResponse.getBody().toString(), avvisoListType);
            ArrayList<Avviso> avvisi = gson.fromJson(apiResponse.getBody().toString(), avvisoListType);

            for(Avviso avviso : avvisi){
                System.out.println("Avviso : " + avviso);
            }

            return avvisi;
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }

//    @Override
//    public List<Avviso> getAvvisiNonLettiPerUtente(UtenteDTO utenteDTO) {
//        try {
//            Gson gson = new Gson();
//            String utenteJson = gson.toJson(utenteDTO);
//
//            HttpResponse<JsonNode> apiResponse = Unirest.get("http://localhost:8080/api/v1/avviso/getAvvisoNonLetto")
//                    .queryString("idUtente", utenteDTO.getEmail())
//                    .header("Content-Type", "application/json")
//                    .bodyString(utenteJson, ContentType.APPLICATION_JSON.getMimeType())
//                    .asJson();
//
//            if (apiResponse.getStatus() == 200) {
//                Type avvisoListType = new TypeToken<ArrayList<Avviso>>(){}.getType();
//                ArrayList<Avviso> avvisi = gson.fromJson(apiResponse.getBody().toString(), avvisoListType);
//                return avvisi;
//            } else {
//                throw new RuntimeException("Failed to retrieve avvisi. Status code: " + apiResponse.getStatus());
//            }
//        } catch (UnirestException e) {
//            throw new RuntimeException("Error during API request", e);
//        }
//    }



//       @Override
//    public List<Avviso> getAvvisiNonLettiPerUtente(UtenteDTO utenteDTO) {
//        try {
//
//            HttpResponse<JsonNode> apiResponse = Unirest.get("http://localhost:8080/api/v1/avviso/getAvvisoNonLetto/utenteDTO").asJson();
//            Type avvisoListType = new TypeToken<ArrayList<Avviso>>(){}.getType();
//
//            ArrayList<Avviso> avvisi = new Gson().fromJson(apiResponse.getBody().toString(), avvisoListType);
//
//            return avvisi;
//        } catch (UnirestException e) {
//            throw new RuntimeException(e);
//        }
//    }

//    public List<Avviso> getAvvisiNonLettiPerUtente(UtenteDTO utenteDTO) {
//        try {
//            // Assuming utenteDTO has an id field
//            String userId = String.valueOf(utenteDTO.getEmail());
//
//            HttpResponse<JsonNode> apiResponse = Unirest.get("http://localhost:8080/api/v1/avviso/idUtente/" + userId).asJson();
//
//            Type avvisoListType = new TypeToken<ArrayList<Avviso>>(){}.getType();
//            ArrayList<Avviso> avvisi = new Gson().fromJson(apiResponse.getBody().toString(), avvisoListType);
//
//            return avvisi;
//        } catch (UnirestException e) {
//            throw new RuntimeException(e);
//        }
//    }


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

    /* VERSIONE FUNZIONANTE */
//    @Override
//    public void modificaStatoAvviso(AvvisoDTO avviso) {
//        try {
//            HttpResponse<JsonNode> response = Unirest.put("http://localhost:8080/api/v1/avviso/updateAvviso")
//                    .header("accept", "application/json")
//                    .field("idAvviso", avviso.getIdAvviso())
//                    .field("mittente", avviso.getMittente())
//                    .field("oggettoAvviso", avviso.getOggettoAvviso())
//                    .field("bodyAvviso", avviso.getBodyAvviso())
//                    .field("dataInvio", avviso.getDataInvio())
//                    .field("orarioInvio", avviso.getOrarioInvio())
//                    .asJson();
//        } catch (UnirestException e) {
//            throw new RuntimeException(e);
//        }
//    }


    @Override
    public void modificaStatoAvviso(AvvisoDTO avviso, UtenteDTO utenteDTO) {
        try {
            HttpResponse<JsonNode> response = Unirest.put("http://localhost:8080/api/v1/avviso/updateAvviso")
                    .header("accept", "application/json")
                    .field("idAvviso", avviso.getIdAvviso())
                    .field("mittente", avviso.getMittente())
                    .field("oggettoAvviso", avviso.getOggettoAvviso())
                    .field("bodyAvviso", avviso.getBodyAvviso())
                    .field("dataInvio", avviso.getDataInvio())
                    .field("orarioInvio", avviso.getOrarioInvio())
                    .field("email", utenteDTO.getEmail())
                    .field("username", utenteDTO.getUsername())
                    .field("gruppo", utenteDTO.getGruppo())
                    .asJson();
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void nascondiAvviso(AvvisoDTO avviso, UtenteDTO utenteDTO) {
        try {
            HttpResponse<JsonNode> response = Unirest.put("http://localhost:8080/api/v1/avviso/nascondiAvviso")
                    .header("accept", "application/json")
                    .field("idAvviso", avviso.getIdAvviso())
                    .field("mittente", avviso.getMittente())
                    .field("oggettoAvviso", avviso.getOggettoAvviso())
                    .field("bodyAvviso", avviso.getBodyAvviso())
                    .field("dataInvio", avviso.getDataInvio())
                    .field("orarioInvio", avviso.getOrarioInvio())
                    .field("email", utenteDTO.getEmail())
                    .field("username", utenteDTO.getUsername())
                    .field("gruppo", utenteDTO.getGruppo())
                    .asJson();
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }


}
