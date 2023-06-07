package com.example.ratatouille23.View.AddettoCucina;

import com.example.ratatouille23.Controller.AddettoCucina.OrdinazioniEvaseController;
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
        Piatto piatto1 = new Piatto("Pasta e cazzi", "€ 12",
                "Cazzi, coppole di minchia, palle, culi",
                "Un piatto contenente tanti bei cuolli di cazzo");

        Piatto piatto2 = new Piatto("Antipasto di minchia", "€ 16",
                "Nessuno", "Un ricco antipasto di capocchia imbuttunata");

        Piatto piatto3 = new Piatto("Il tributo di RobMcCum", "€69",
                "Liquido seminale", "Che dire. Un bel frullato di lasagne sborrate dal mitico rob Mcquack.");

        Piatto piatto4 = new Piatto("Abbasso l'università", "Dipende dall'ISEE",
                "Salvatore Corrado, Flavio Arienzo, SDM, Starace e tutt a maronn ro carmn", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");


        Ordinazione ord1 = new Ordinazione("12");



        ord1.aggiungiPiatto(piatto1, 4);
        ord1.setStatoInPreparazione(piatto1);
        ord1.aggiungiPiatto(piatto2, 1);
        ord1.setStatoCompletato(piatto2);


        Ordinazione ord2 = new Ordinazione("2");

        ord2.aggiungiPiatto(piatto2, 3);
        ord2.aggiungiPiatto(piatto3,4);


        ArrayList<Ordinazione> ordini = new ArrayList<>();

        ordini.add(ord1);
        ordini.add(ord2);


        // In realtà, qui va fatto un ordinazioneDAO.getAllOrdinazioniEvase()

        for (Ordinazione ord : ordini) {
            TitledPane titledPane = new TitledPane();
            titledPane.setText("Tavolo " + ord.getIdTavolo()); // imposto il titolo del TitledPane con il numero tavolo


            Accordion accordion = new Accordion();

            for (HashMap.Entry<Piatto, Ordinazione.InfoOrdine> map : ord.getPiattiOrdinazione().entrySet()){
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
