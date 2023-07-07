package com.example.ratatouille23.View.AddettoCucina;

import com.example.ratatouille23.Controller.AddettoCucina.OrdinazioniEvaseController;
import com.example.ratatouille23.Model.InfoOrdine;
import com.example.ratatouille23.Model.Ordinazione;
import com.example.ratatouille23.Model.Piatto;
import com.example.ratatouille23.ViewInterface;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class OrdinazioniEvaseView implements ViewInterface {


    @FXML
    private BorderPane borderPane;

    @FXML
    private Accordion listaOrdinazioni;

    private Node node;

    private OrdinazioniEvaseController ordinazioniEvaseController;


    @FXML
    public void initialize() {

        this.ordinazioniEvaseController = new OrdinazioniEvaseController(this);

        popolaAccordion();
    }




    // Methods

    public void popolaAccordion(){
        // popolare l'accordion. questo codice va messo in controller

        listaOrdinazioni.getPanes().clear();


        ArrayList<Ordinazione> ordini = (ArrayList<Ordinazione>) ordinazioniEvaseController.ottieniOrdinazioniEvase();
        ArrayList<InfoOrdine> io = (ArrayList<InfoOrdine>) ordinazioniEvaseController.ottieniInfoOrdini();
        InfoOrdine infoOrdine = new InfoOrdine();

        for(Ordinazione ordinazione : ordini){
            Map<Piatto, InfoOrdine> infopiatto = new HashMap<>();

            for (InfoOrdine infoOrdini : io){
                if(ordinazione.getIdOrdinazione() == infoOrdini.getOrdinazione().getIdOrdinazione()){
                    infopiatto.put(infoOrdini.getPiatto(), infoOrdini);
                }
            }
            ordinazione.setInfoPiatto(infopiatto);
            System.out.println("Dopo aver composto l'oggetto, l'ordinazione è uguale a: " + ordinazione);

        }


        // In realtà, qui va fatto un ordinazioneDAO.getAllOrdinazioniEvase()

        for (Ordinazione ord : ordini) {
            TitledPane titledPane = new TitledPane();
            titledPane.setText("Tavolo " + ord.getIdTavolo()  + " - " + ord.getOrarioInvio() + " - " + ord.getDataInvio()); // imposto il titolo del TitledPane con il numero tavolo


            Accordion accordion = new Accordion();

            for (HashMap.Entry<Piatto, InfoOrdine> map : ord.getInfoPiatto().entrySet()){
                TitledPane TPPiatto = new TitledPane();
                TPPiatto.setText(map.getKey().getNomePiatto());


                // Stato

                TextFlow stato = new TextFlow();

                Text boldStato = new Text("Stato: ");
                boldStato.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));

                Text plainStato = new Text(map.getValue().getStato().toString());
                plainStato.setFont(Font.font("Tahoma", 16));

                stato.getChildren().addAll(boldStato, plainStato);

                VBox content = new VBox();

                content.setSpacing(10);
                content.getChildren().add(stato);
                content.setAlignment(Pos.CENTER);


                TextFlow addetto = new TextFlow();

                Text boldAddetto = new Text("Completato da: ");
                boldAddetto.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));

                Text plainAddetto = new Text(map.getValue().getUsername());
                plainAddetto.setFont(Font.font("Tahoma", 16));

                //La versione vera deve prendere l'utente che ha preso in carico la comanda
                //Text plainAddetto = new Text(map.getValue().getStato().toString());
                //plainStato.setFont(Font.font("Tahoma", 16));

                addetto.getChildren().addAll(boldAddetto, plainAddetto);
                content.getChildren().add(addetto);


                TPPiatto.setContent(content);
                accordion.getPanes().add(TPPiatto);
            }
            titledPane.setContent(accordion);
            listaOrdinazioni.getPanes().add(titledPane);
        }
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
