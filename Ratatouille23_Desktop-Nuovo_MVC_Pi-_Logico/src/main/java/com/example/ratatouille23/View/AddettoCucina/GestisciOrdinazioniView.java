package com.example.ratatouille23.View.AddettoCucina;

import com.example.ratatouille23.Controller.AddettoCucina.GestisciOrdinazioniController;
import com.example.ratatouille23.Model.*;
import com.example.ratatouille23.Model.DAO.DAOInterface.InfoOrdineDAO;
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
import java.util.Map;
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
        popolaOrdinazioniAccordion();


    }

    private void popolaOrdinazioniAccordion() {

        listaOrdinazioni.getPanes().clear();



        ArrayList<Ordinazione> ordini = (ArrayList<Ordinazione>) gestisciOrdinazioniController.ottieniOrdinazioni();
        ArrayList<InfoOrdine> io = (ArrayList<InfoOrdine>) gestisciOrdinazioniController.ottieniInfoOrdini();
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


        for (Ordinazione ord : ordini) {
            TitledPane titledPane = new TitledPane();
            titledPane.setText("Tavolo " + ord.getIdTavolo() + " - " + ord.getOrarioInvio() + " - " + ord.getDataInvio()); // imposto il titolo del TitledPane con il numero tavolo

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

                content.getChildren().add(stato);

                if (map.getValue().getStato().equals(InfoOrdine.StatoOrdine.DA_PREPARARE)){
                    Button prepara = new Button();
                    prepara.setText("Prepara ordinazione");
                    content.getChildren().add(prepara);

                    prepara.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setTitle("Conferma");
                            alert.setHeaderText("Sei sicuro di voler preparare questa ordinazione?");
                            alert.setContentText("Una volta presa in carico la comanda, non potrai annullare.");
                            Optional<ButtonType> result = alert.showAndWait();
                            if (result.get() == ButtonType.OK){
                                // Manda al database
                                //TODO metodo PUT in DAO

                                // con questa istruzione, vado a segnare l'utente che ha premuto il pulsante
//                                map.getValue().setUsername(Utente.getUsername());

                                // TODO DAO PER AGGIORNARE USERNAME IN INFOORDINE
                                gestisciOrdinazioniController.setUsernameAddettoAllaCucina(Utente.getUsername(), map.getValue().getOrdinazione(), map.getValue().getPiatto());
                                gestisciOrdinazioniController.modificaStatoOrdinazioneInPreparazione(map.getValue().getOrdinazione(), map.getValue().getPiatto());
                                popolaOrdinazioniAccordion();
                            }
                        }
                    });
                } else if ((map.getValue().getStato().equals(InfoOrdine.StatoOrdine.IN_PREPARAZIONE))){

                    TextFlow addetto = new TextFlow();

                    Text boldAddetto = new Text("Presa in carico da: ");
                    boldAddetto.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));

                    Text plainAddetto = new Text(map.getValue().getUsername());
                    plainAddetto.setFont(Font.font("Tahoma", 16));

                        if(map.getValue().getUsername().equals(Utente.getUsername())){
//                    if(map.getValue().getUsername() == Utente.getUsername()){
                        System.out.println("QUESTO UTENTE E' LUUUIIIIIIIIIIIIUIUIUI");
                            Button btnConfermaComanda = new Button("COMPLETA ORDINAZIONE");
                        content.getChildren().add(btnConfermaComanda);
                        btnConfermaComanda.setOnAction(event ->{
                                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                                        alert.setTitle("Conferma");
                                        alert.setHeaderText("Sei sicuro di voler completare questa ordinazione?");
                                        alert.setContentText("Una volta completata la comanda, non potrai annullare.");
                                        Optional<ButtonType> result = alert.showAndWait();
                                        if (result.get() == ButtonType.OK){
                                            gestisciOrdinazioniController.modificaStatoOrdinazioneCompletato(map.getValue().getOrdinazione(), map.getValue().getPiatto());
                                            popolaOrdinazioniAccordion();
                                        }
                            });

                        }


                        addetto.getChildren().addAll(boldAddetto, plainAddetto);
                    content.getChildren().add(addetto);

                } else if((map.getValue().getStato().equals(InfoOrdine.StatoOrdine.COMPLETATO))){


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

                }

                TPPiatto.setContent(content);
                accordion.getPanes().add(TPPiatto);
            }
            titledPane.setContent(accordion);
            listaOrdinazioni.getPanes().add(titledPane);
        }
    }


    public void clickBtnOrdinazioniEvase(){
        gestisciOrdinazioniController.onBtnOrdinazioniEvaseClicked();
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
