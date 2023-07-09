package com.example.ratatouille23.View;

import com.example.ratatouille23.Controller.NuovoPiattoController;
import com.example.ratatouille23.Model.Piatto;
import com.example.ratatouille23.Utils.Prodotto;
import com.example.ratatouille23.ViewInterface;
import com.google.gson.*;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class NuovoPiattoView implements ViewInterface {

    @FXML
    private TextField nomePiattoTextField;
    @FXML
    private TextField costoPiattoTextField;
    @FXML
    private TextArea descrizionePiattoTextArea;
    @FXML
    private ComboBox categoriaComboBox;
    @FXML
    private TextArea allergeniPiattoTextArea;
    @FXML
    private Button btnConferma;

    private AutoCompletionBinding autocompletion;

    private Node node;
    NuovoPiattoController nuovoPiattoController;




   // ArrayList<Prodotto> suggerimenti = new ArrayList<>();
    //****************

    public NuovoPiattoView() {}

    @FXML
    public void initialize() {

        this.nuovoPiattoController = new NuovoPiattoController(this);

        btnConferma.disableProperty().bind(
                Bindings.createBooleanBinding(
                        () -> nomePiattoTextField.getText().isEmpty() || costoPiattoTextField.getText().isEmpty() || descrizionePiattoTextArea.getText().isEmpty() || allergeniPiattoTextArea.getText().isEmpty() || categoriaComboBox.getValue() == null,
                        nomePiattoTextField.textProperty(),
                        costoPiattoTextField.textProperty(),
                        descrizionePiattoTextArea.textProperty(),
                        allergeniPiattoTextArea.textProperty(),
                        categoriaComboBox.valueProperty()
                )
        );


        categoriaComboBox.getItems().addAll("Antipasti", "Bevande");
/*
        nomePiattoTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.length() >= 3) {
               // if (autocompletion == null || oldValue.length() < newValue.length()) {
                    if (autocompletion != null ){
                        autocompletion.dispose();
                    }
                    String finalJson = json1 + newValue + json2;

                    System.out.println(finalJson);

                    suggerimenti.clear();

                    if (finalJson.contains(" ")) {
                        return;
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

                        // Iterare sui prodotti nell'array
                        for (JsonElement productElement : productsArray) {
                            JsonObject productObject = productElement.getAsJsonObject();

                            // Deserializzare l'oggetto prodotto in una classe Product (definisci la classe Product secondo la struttura dei dati del tuo JSON)
                            Prodotto product = gson.fromJson(productObject, Prodotto.class);

                            System.out.println("Product Name: " + product.getProduct_name());
                            System.out.println("Allergens: " + product.getAllergens());
                            System.out.println("Generic Name: " + product.getGeneric_name());
                            System.out.println();

                            suggerimenti.add(product);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                    autocompletion = TextFields.bindAutoCompletion(nomePiattoTextField, suggerimenti);
                    autocompletion.getAutoCompletionPopup();

                    System.out.println("attivato binding");


                    autocompletion.setOnAutoCompleted(new EventHandler<AutoCompletionBinding.AutoCompletionEvent<Prodotto>>() {
                        @Override
                        public void handle(AutoCompletionBinding.AutoCompletionEvent<Prodotto> event) {
                            descrizionePiattoTextArea.setText(event.getCompletion().getGeneric_name());
                            allergeniPiattoTextArea.setText(event.getCompletion().getAllergens());
                        }
                    });
                }

               // } else {
                     if (autocompletion != null) {
                        autocompletion.dispose();
                        System.out.println("dispose effettuato");
                        autocompletion = null;
                    }
                }

           // }
        });

 */

        autocompletion = TextFields.bindAutoCompletion(nomePiattoTextField, iSuggestionRequest ->
                nuovoPiattoController.ottieniProdottiJson(iSuggestionRequest.getUserText()));

        autocompletion.setOnAutoCompleted(new EventHandler<AutoCompletionBinding.AutoCompletionEvent<Prodotto>>() {
            @Override
            public void handle(AutoCompletionBinding.AutoCompletionEvent<Prodotto> event) {
                descrizionePiattoTextArea.setText(event.getCompletion().getGeneric_name());
                allergeniPiattoTextArea.setText(event.getCompletion().getAllergens());
            }
        });

}










    // Event Handler

    public void clickBtnConferma(){
        nuovoPiattoController.onBtnConfermaClicked();
    }


    // Metodi di ViewInterface

    @Override
    public Node getNode(){
        return this.node;
    }

    @Override
    public void setNode(Node node){
        this.node = node;
    }


    // Event handler
    private void clickBtnConferma(ActionEvent e){

    }




    public TextField getNomePiattoTextField() {
        return nomePiattoTextField;
    }

    public TextField getCostoPiattoTextField() {
        return costoPiattoTextField;
    }

    public TextArea getDescrizionePiattoTextArea() {
        return descrizionePiattoTextArea;
    }

    public ComboBox getCategoriaComboBox() {
        return categoriaComboBox;
    }

    public TextArea getAllergeniPiattoTextArea() {
        return allergeniPiattoTextArea;
    }

    public NuovoPiattoController getNuovoPiattoController() {
        return nuovoPiattoController;
    }

}
