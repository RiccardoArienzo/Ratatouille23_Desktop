package com.example.ratatouille23.View;

import com.example.ratatouille23.Controller.GestisciAvvisiController;
import com.example.ratatouille23.Model.Avviso;
import com.example.ratatouille23.Model.DAO.DAOInterface.AvvisoDAO;
import com.example.ratatouille23.Model.DTO.AvvisoDTO;
import com.example.ratatouille23.Model.DTO.UtenteDTO;
import com.example.ratatouille23.Model.Utente;
import com.example.ratatouille23.ViewInterface;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import org.kordamp.ikonli.javafx.FontIcon;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class GestisciAvvisiView implements ViewInterface {

    @FXML
    private Accordion listaAvvisi;
    
    GestisciAvvisiController gestisciAvvisiController;

    private Node node;


    @FXML
    public void initialize() {

        this.gestisciAvvisiController = new GestisciAvvisiController(this);
        popolaAvvisiAccordion();

    }

    public void popolaAvvisiAccordion() {
        listaAvvisi.getPanes().clear();
        UtenteDTO utenteDTO = new UtenteDTO();
        utenteDTO.setUsername(Utente.getUsername());
        utenteDTO.setGruppo(Utente.getGroup());
        utenteDTO.setEmail(Utente.getEmail());
        System.out.println("Utente in popolaAvvisi è uguale a questo: " + utenteDTO);
        ArrayList<Avviso> listaAvv = (ArrayList<Avviso>) gestisciAvvisiController.ottieniAvviso(utenteDTO);

        for (Avviso avv : listaAvv) {
            TitledPane tp = new TitledPane();
            tp.setText(avv.getOggettoAvviso());

            if (avv.getStato() == false) {

                FontIcon newIcon = new FontIcon("mdi-exclamation");
                newIcon.setIconSize(30);
                newIcon.setIconColor(Color.RED);
                newIcon.setStroke(Color.WHITE);

                tp.setGraphic(newIcon);

                tp.expandedProperty().addListener((observable, oldValue, newValue) -> {
                    if (newValue) {
                        tp.setGraphic(null);
                        //TODO per tenere sott'occhio la chiamata al dao
                        // richiamare avvisoDAO cambiando lo stato dell'avviso corrente per l'utente corrente
                        // da Non letto a Letto

//                        AvvisoDTO avvisoDTO = new AvvisoDTO();
//                        avvisoDTO.setIdAvviso(avv.getIdAvviso());
//                        avvisoDTO.setBodyAvviso(avv.getBodyAvviso());
//                        avvisoDTO.setMittente(avv.getMittente());
//                        avvisoDTO.setOggettoAvviso(avv.getOggettoAvviso());
//                        avvisoDTO.setDataInvio(avv.getDataInvio());
//                        avvisoDTO.setOrarioInvio(avv.getOrarioInvio());
//                        System.out.println("L'avviso selezionato è il seguente: " + avvisoDTO.getIdAvviso());
//                        gestisciAvvisiController.onAvvisoLetto(avvisoDTO);



                        // versione di prova

                        AvvisoDTO avvisoDTO = new AvvisoDTO();
                        avvisoDTO.setIdAvviso(avv.getIdAvviso());
                        avvisoDTO.setBodyAvviso(avv.getBodyAvviso());
                        avvisoDTO.setMittente(avv.getMittente());
                        avvisoDTO.setOggettoAvviso(avv.getOggettoAvviso());
                        avvisoDTO.setDataInvio(avv.getDataInvio());
                        avvisoDTO.setOrarioInvio(avv.getOrarioInvio());
                        System.out.println("L'avviso selezionato è il seguente: " + avvisoDTO.getIdAvviso());

                        gestisciAvvisiController.onAvvisoLetto(avvisoDTO, utenteDTO);


                    }
                });

                // }


                //

                TextFlow mittenteOrarioAvviso = new TextFlow();

                Text boldText = new Text("Inviato da: ");
                boldText.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
                Text plainText = new Text(avv.getMittente());
                plainText.setFont(Font.font("Tahoma", 14));

                Text boldText3 = new Text(" in data: ");
                boldText3.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
                Text plainText3 = new Text(avv.getDataInvio().toString());
                plainText3.setFont(Font.font("Tahoma", 14));
                Text boldText4 = new Text(" alle ore ");
                boldText4.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
                Text plainText4 = new Text(avv.getOrarioInvio().toString());
                plainText4.setFont(Font.font("Tahoma", 14));

                mittenteOrarioAvviso.getChildren().addAll(boldText, plainText, boldText3, plainText3, boldText4, plainText4);

                //

                TextFlow corpoAvviso = new TextFlow();

                Text plainText2 = new Text(avv.getBodyAvviso());
                plainText2.setFont(Font.font("Tahoma", 18));

                Button prepara = new Button();

                prepara.setText("Nascondi avviso");
                prepara.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {

                        // chiamata al controller, passi l'avviso e cambi lo stato
                        AvvisoDTO avvisoDTO = new AvvisoDTO();
                        avvisoDTO.setIdAvviso(avv.getIdAvviso());
                        avvisoDTO.setBodyAvviso(avv.getBodyAvviso());
                        avvisoDTO.setMittente(avv.getMittente());
                        avvisoDTO.setOggettoAvviso(avv.getOggettoAvviso());
                        avvisoDTO.setDataInvio(avv.getDataInvio());
                        avvisoDTO.setOrarioInvio(avv.getOrarioInvio());
                        gestisciAvvisiController.nascondiAvviso(avvisoDTO, utenteDTO);

                        popolaAvvisiAccordion();

                    }
                });


                VBox vbox = new VBox();
                vbox.setSpacing(10);
                vbox.setAlignment(Pos.TOP_CENTER);
                vbox.getChildren().addAll(corpoAvviso, mittenteOrarioAvviso, prepara);

                tp.setContent(vbox);

                listaAvvisi.getPanes().add(tp);
            }
        }
    }

        // Event Handler

        public void clickBtnVisualizzaAvvisiNascosti () {
            gestisciAvvisiController.onBtnVisualizzaAvvisiNascostiClicked();
        }

        // Metodi di View Interface

        @Override
        public Node getNode () {
            return this.node;
        }

        @Override
        public void setNode (Node node){
            this.node = node;
        }

        // Getter


        public GestisciAvvisiController getGestisciAvvisiController () {
            return gestisciAvvisiController;
        }
    }
