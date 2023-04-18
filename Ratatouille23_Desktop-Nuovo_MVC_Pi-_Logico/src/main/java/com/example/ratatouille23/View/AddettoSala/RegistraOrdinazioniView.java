package com.example.ratatouille23.View.AddettoSala;

import com.example.ratatouille23.Controller.AddettoSala.RegistraOrdinazioniController;
import com.example.ratatouille23.Model.Categoria;
import com.example.ratatouille23.Model.Piatto;
import com.example.ratatouille23.ViewInterface;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.IOException;
import java.util.ArrayList;

public class RegistraOrdinazioniView implements ViewInterface {

    @FXML
    private BorderPane borderPane;

    @FXML
    private Accordion listaPiatti;
    @FXML
    private VBox vboxButtonsCategorie;

    private Node node;

    private RegistraOrdinazioniController gestisciOrdinazioniController;


    @FXML
    public void initialize() {

        this.gestisciOrdinazioniController = new RegistraOrdinazioniController(this);



//        ToggleGroup toggleGroup = new ToggleGroup();
//
//        for (Categoria cat : listaCat) {
//            ToggleButton btnCategoria = new ToggleButton(cat.getNome());
//            btnCategoria.setPrefSize(195,63);
//            btnCategoria.setStyle("-fx-font-family: Tahoma; -fx-font-size: 23px; -fx-text-fill: white");
//            btnCategoria.getStyleClass().add("button-orders");
//            btnCategoria.setToggleGroup(toggleGroup);
//
//            vboxButtonsCategorie.getChildren().add(btnCategoria);
//
//            btnCategoria.setOnAction(new EventHandler<ActionEvent>() {
//                @Override
//                public void handle(ActionEvent actionEvent) {
//
//                    listaPiatti.getPanes().clear();
//
//                    for (Piatto piatto : cat.getPiatti()) {
//                        TitledPane TPPiatto = new TitledPane();
//                        TPPiatto.setText(piatto.getNomePiatto());
//
//                        // Piatti
//
//
//                        // Nome
//                        TextFlow nomePiatto = new TextFlow();
//
//                        Text boldText = new Text("Nome: ");
//                        boldText.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
//                        Text plainText = new Text(piatto.getNomePiatto());
//                        plainText.setFont(Font.font("Tahoma", 16));
//
//                        nomePiatto.getChildren().addAll(boldText, plainText);
//
//                        // Costo
//                        TextFlow costoPiatto = new TextFlow();
//
//                        Text boldText2 = new Text("Costo: ");
//                        boldText2.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
//                        Text plainText2 = new Text(piatto.getCostoPiatto());
//                        plainText2.setFont(Font.font("Tahoma", 16));
//
//                        costoPiatto.getChildren().addAll(boldText2, plainText2);
//
//                        // Descrizione
//                        TextFlow descrizionePiatto = new TextFlow();
//
//                        Text boldText3 = new Text("Descrizione: ");
//                        boldText3.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
//                        Text plainText3 = new Text(piatto.getDescrizione());
//                        plainText3.setFont(Font.font("Tahoma", 16));
//
//                        descrizionePiatto.getChildren().addAll(boldText3, plainText3);
//
//                        // Allergeni
//                        TextFlow allergeniPiatto = new TextFlow();
//
//                        Text boldText4 = new Text("Nome: ");
//                        boldText4.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
//                        Text plainText4 = new Text(piatto.getAllergeni());
//                        plainText4.setFont(Font.font("Tahoma", 16));
//
//                        allergeniPiatto.getChildren().addAll(boldText4, plainText4);
//
//                        // quantità
//                        Button minus = new Button("-");
//                        TextField quantity = new TextField("0");
//                        Button plus = new Button("+");
//
//                        quantity.getStyleClass().add("textfield");
//                        quantity.setPrefWidth(30);
//                        quantity.setPrefHeight(29);
//                        minus.getStyleClass().add("circular-button");
//                        plus.getStyleClass().add("circular-button");
//
//
//                        minus.setOnAction(new EventHandler<ActionEvent>() {
//                            @Override
//                            public void handle(ActionEvent actionEvent) {
//                                int value = Integer.parseInt(quantity.getText());
//                                if (value > 0) {
//                                    quantity.setText(Integer.toString(value - 1));
//                                }
//                            }
//                        });
//
//                        plus.setOnAction(new EventHandler<ActionEvent>() {
//                            @Override
//                            public void handle(ActionEvent actionEvent) {
//                                int value = Integer.parseInt(quantity.getText());
//                                quantity.setText(Integer.toString(value + 1));
//                            }
//                        });
//
//                        HBox chooseQuantity = new HBox();
//                        chooseQuantity.getChildren().addAll(minus, quantity, plus);
//                        chooseQuantity.setSpacing(5);
//
//
//                        VBox content = new VBox();
//                        content.getChildren().addAll(nomePiatto, costoPiatto, descrizionePiatto, allergeniPiatto, chooseQuantity);
//
//                        TPPiatto.setContent(content);
//                        listaPiatti.getPanes().add(TPPiatto);
//                    }
//                }
//            });
//
//        }
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


}
