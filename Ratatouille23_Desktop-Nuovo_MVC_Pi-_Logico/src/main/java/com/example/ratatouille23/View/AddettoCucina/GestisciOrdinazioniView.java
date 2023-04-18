package com.example.ratatouille23.View.AddettoCucina;

import com.example.ratatouille23.Controller.AddettoCucina.GestisciOrdinazioniController;
import com.example.ratatouille23.Model.Ordinazione;
import com.example.ratatouille23.Model.Piatto;
import com.example.ratatouille23.ViewInterface;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class GestisciOrdinazioniView implements ViewInterface {

    @FXML
    private BorderPane borderPane;

    @FXML
    private Accordion listaOrdinazioni;

    private Node node;

    private GestisciOrdinazioniController gestisciOrdinazioniController;


    @FXML
    public void initialize() {

        this.gestisciOrdinazioniController = new GestisciOrdinazioniController(this);



//        for (Ordinazione ord : ordini) {
//            TitledPane titledPane = new TitledPane();
//            titledPane.setText("Tavolo " + ord.getIdTavolo()); // imposto il titolo del TitledPane con il numero tavolo
//
//            Accordion accordion = new Accordion();
//
//            for (HashMap.Entry<Piatto, Ordinazione.InfoOrdine> map : ord.getPiattiOrdinazione().entrySet()){
//                TitledPane TPPiatto = new TitledPane();
//                TPPiatto.setText(map.getKey().getNomePiatto());
//
//
//                // Stato
//
//                TextFlow stato = new TextFlow();
//
//                Text boldStato = new Text("Stato: ");
//                boldStato.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
//
//                Text plainStato = new Text(map.getValue().getStato().toString());
//                plainStato.setFont(Font.font("Tahoma", 16));
//
//                stato.getChildren().addAll(boldStato, plainStato);
//
//                VBox content = new VBox();
//
//                content.getChildren().add(stato);
//
//                if (map.getValue().getStato().equals(Ordinazione.StatoOrdine.DA_PREPARARE)){
//                    Button prepara = new Button();
//                    prepara.setText("Prepara ordinazione");
//                    content.getChildren().add(prepara);
//
//                    prepara.setOnAction(new EventHandler<ActionEvent>() {
//                        @Override
//                        public void handle(ActionEvent actionEvent) {
//                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//                            alert.setTitle("Conferma");
//                            alert.setHeaderText("Sei sicuro di voler preparare questa ordinazione?");
//                            alert.setContentText("Una volta presa in carico la comanda, non potrai annullare.");
//                            Optional<ButtonType> result = alert.showAndWait();
//                            if (result.get() == ButtonType.OK){
//                                // Manda al database
//                            }
//                        }
//                    });
//                }
//
//                TPPiatto.setContent(content);
//                accordion.getPanes().add(TPPiatto);
//            }
//            titledPane.setContent(accordion);
//            listaOrdinazioni.getPanes().add(titledPane);
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
