package com.example.ratatouille23.View;

import com.example.ratatouille23.Controller.GestisciAvvisiController;
import com.example.ratatouille23.Model.Avviso;
import com.example.ratatouille23.ViewInterface;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

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

        Avviso avv1 = new Avviso("Salvatore Corrado", "Basta pagare tasse",
                "Da oggi, le tasse non verranno più pagate. Basta.", LocalDate.of(2023,03,13), LocalTime.of(12,24));

        Avviso avv2 = new Avviso("Flavio Arienzo", "Comprare droga",
                "Necessito di un bel pezzo di fumo.", LocalDate.of(2023,03,13), LocalTime.of(12,24));

        ArrayList<Avviso> avvisi = new ArrayList<>();

        avvisi.add(avv1);
        avvisi.add(avv2);

        for (Avviso avv : avvisi){
            TitledPane tp = new TitledPane();
            tp.setText(avv.getOggettoAvviso());

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


            VBox vbox = new VBox();
            vbox.setSpacing(10);
            vbox.getChildren().addAll(corpoAvviso, mittenteOrarioAvviso);

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
