package com.example.ratatouille23.View;

import com.example.ratatouille23.Controller.GestisciAvvisiController;
import com.example.ratatouille23.Model.Avviso;
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
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign.MaterialDesign;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class GestisciAvvisiView implements ViewInterface {

    @FXML
    private Accordion listaAvvisi;

    @FXML
    private Button btnVisualizzaAvvisiNascosti;
    private GestisciAvvisiController gestisciAvvisiController;
    private Node node;


    @FXML
    public void initialize() {
        this.gestisciAvvisiController = new GestisciAvvisiController(this);

        popolaListaAvvisi();


    }


    public void popolaListaAvvisi(){



        Avviso avv1 = new Avviso("Salvatore Corrado", "Basta pagare tasse",
                "Da oggi, le tasse non verranno più pagate. Basta.", LocalDate.of(2023,03,13), LocalTime.of(12,24));

        Avviso avv2 = new Avviso("Flavio Arienzo", "Comprare droga",
                "Necessito di un bel pezzo di fumo.", LocalDate.of(2023,03,13), LocalTime.of(12,24));

        ArrayList<Avviso> avvisi = new ArrayList<>();

        avvisi.add(avv1);
        avvisi.add(avv2);

        for (Avviso avv : avvisi) {
            TitledPane tp = new TitledPane();
            tp.setText(avv.getOggettoAvviso());


            // Codice per carlo

            // Da inserire dopo "tp.setText" dentro il ciclo for(Avviso avv: avvisi){

            // if (avv.getStato == "Non letto"){

            FontIcon newIcon = new FontIcon("mdi-exclamation");
            newIcon.setIconSize(30);
            newIcon.setIconColor(Color.RED);
            newIcon.setStroke(Color.WHITE);

            tp.setGraphic(newIcon);

            tp.expandedProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue) {
                    tp.setGraphic(null);
                    // richiamare avvisoDAO cambiando lo stato dell'avviso corrente per l'utente corrente
                    // da Non letto a Letto
                } else {
                }
            });

            // }


           // Text titolo = new Text(avv.getOggettoAvviso());
            //titolo.setFont(Font.font("Tahoma", FontWeight.BOLD, 16));

            //tp.setText(String.valueOf(titolo));

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

            corpoAvviso.getChildren().addAll(plainText2);

            //

            Button prepara = new Button();

            prepara.setText("Nascondi avviso");
            prepara.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {

                    // chiamata al controller, passi l'avviso e cambi lo stato


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

    // Event Handler

    public void clickBtnVisualizzaAvvisiNascosti(){
        gestisciAvvisiController.onBtnVisualizzaAvvisiNascostiClicked();
    }

    // Metodi di View Interface

    @Override
    public Node getNode(){
        return this.node;
    }

    @Override
    public void setNode(Node node){
        this.node = node;
    }

    // Getter


    public GestisciAvvisiController getGestisciAvvisiController() {
        return gestisciAvvisiController;
    }
}
