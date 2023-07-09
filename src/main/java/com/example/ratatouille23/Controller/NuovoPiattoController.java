package com.example.ratatouille23.Controller;

import com.example.ratatouille23.Homepage;
import com.example.ratatouille23.Utils.Prodotto;
import com.example.ratatouille23.View.Admin.HomepageAdminView;
import com.example.ratatouille23.View.NuovoPiattoView;
import com.google.gson.*;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NuovoPiattoController {

    private NuovoPiattoView nuovoPiatto;

    private String BASE_URL_JSON = "https://it.openfoodfacts.org/cgi/search.pl?search_terms=";
    private String LAST_URL_JSON = "&search_simple=true&json=true&fields=product_name,allergens,generic_name";

    public NuovoPiattoController(NuovoPiattoView view) {
        this.nuovoPiatto = view;
    }


    // Event Handler

    public void onBtnConfermaClicked() {
    }


    public List<Prodotto> ottieniProdottiJson(String prod) {
        String finalJson = BASE_URL_JSON + prod + LAST_URL_JSON;

        System.out.println(finalJson);

        if (finalJson.contains(" ")) {
            return null;
        }

        try {
            HttpResponse<JsonNode> response = Unirest.get(finalJson)
                    .header("accept", "application/json")
                    .asJson();


            // Ottenere il corpo della risposta come oggetto JSON
            JsonNode jsonBody = response.getBody();

            // Convertire il corpo della risposta in una stringa
            String jsonString = jsonBody.toString();

            // Creare un parser JSON
            JsonParser parser = new JsonParser();

            // Parsare la stringa JSON in un oggetto JsonElement
            JsonElement jsonElement = parser.parse(jsonString);

            // Ottenere l'oggetto radice JSON
            JsonObject rootObject = jsonElement.getAsJsonObject();

            // Ottenere l'array "products" dall'oggetto radice
            JsonArray productsArray = rootObject.getAsJsonArray("products");

            // Creare un oggetto Gson per la deserializzazione
            Gson gson = new Gson();

            ArrayList<Prodotto> listaSuggerimenti = new ArrayList<>();

            // Iterare sui prodotti nell'array
            for (JsonElement productElement : productsArray) {
                JsonObject productObject = productElement.getAsJsonObject();

                // Deserializzare l'oggetto prodotto in una classe Product (definisci la classe Product secondo la struttura dei dati del tuo JSON)
                Prodotto product = gson.fromJson(productObject, Prodotto.class);

                System.out.println("Product Name: " + product.getProduct_name());
                System.out.println("Allergens: " + product.getAllergens());
                System.out.println("Generic Name: " + product.getGeneric_name());
                System.out.println();

                listaSuggerimenti.add(product);
            }

            return listaSuggerimenti;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    // Utility
    public boolean verificaCampiNonVuoti(){
        if (nuovoPiatto.getNomePiattoTextField().getText().isEmpty() &&
            nuovoPiatto.getCostoPiattoTextField().getText().isEmpty() &&
            nuovoPiatto.getAllergeniPiattoTextArea().getText().isEmpty() &&
            nuovoPiatto.getDescrizionePiattoTextArea().getText().isEmpty() &&
            nuovoPiatto.getCategoriaComboBox().getValue() == null){
            return true;
        } else {
            return false;
        }
    }

}
