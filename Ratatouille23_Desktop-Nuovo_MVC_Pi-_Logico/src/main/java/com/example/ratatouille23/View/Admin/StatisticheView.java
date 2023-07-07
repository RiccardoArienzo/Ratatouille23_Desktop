package com.example.ratatouille23.View.Admin;

import com.example.ratatouille23.Controller.Amministratore.CreaUtenteController;
import com.example.ratatouille23.Controller.Amministratore.StatisticheController;
import com.example.ratatouille23.Model.MediaOrdinazioniPerGiornate;
import com.example.ratatouille23.Model.NumeroOrdinazioniPerAddetto;
import com.example.ratatouille23.Model.ValoreTotalePerAddetto;
import com.example.ratatouille23.ViewInterface;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.ArrayList;



public class StatisticheView implements ViewInterface {

    private Node node;

    private StatisticheController statController;



    @FXML
    private VBox vbox;

    @FXML
    private Button btnOrdinazioniPerAddetto;

    @FXML
    private DatePicker datePickerInizio;

    @FXML
    private DatePicker datePickerFine;

    @FXML
    public void initialize() {
        this.statController = new StatisticheController(this);

    }



    public void clickBtnOrdinazioniPerAddetto(){
        loadBarchartOrdinazioniPerAddetto();
    }

    public void clickBtnValoreTotaleOrdinazioni(){
        loadBarchartValoreTotaleOrd();
    }


    private void loadBarchartOrdinazioniPerAddetto() {

        vbox.getChildren().clear();

        ArrayList<NumeroOrdinazioniPerAddetto> numeroOrdinazioniPerAddetto = (ArrayList<NumeroOrdinazioniPerAddetto>) statController.getNumeroOrdinazioni(datePickerInizio.getValue(), datePickerFine.getValue());
        ArrayList<MediaOrdinazioniPerGiornate> mediaOrdinazioniPerGiornate = (ArrayList<MediaOrdinazioniPerGiornate>) statController.getMediaOrdinazioniPerGiornate(datePickerInizio.getValue() ,datePickerFine.getValue());

        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Addetti");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Ordini");

        BarChart ordAddChart = new BarChart(xAxis, yAxis);

        // Creo una series di statistiche

        XYChart.Series dataSeries1 = new XYChart.Series();
        dataSeries1.setName("Ordinazioni per addetto");

        // Aggiungo i dati dalla lista al dataseries

        for(NumeroOrdinazioniPerAddetto val : numeroOrdinazioniPerAddetto){
            dataSeries1.getData().add(new XYChart.Data<>(val.getUsername(), val.getnumeroOrdinazioni()));
        }

        // Aggiungo il dataseries al chart

        ordAddChart.getData().add(dataSeries1);



        // NUOVO SERIES

        // Creo una series di statistiche

        XYChart.Series dataSeries2 = new XYChart.Series();
        dataSeries2.setName("Ordinazioni in media per giorno");

        // Aggiungo i dati dalla lista al dataseries

        for(MediaOrdinazioniPerGiornate val : mediaOrdinazioniPerGiornate){
            dataSeries2.getData().add(new XYChart.Data<>(val.getUsername(), val.getmediaOrdinazioniCompletate()));
        }

        // Aggiungo il dataseries al chart

        ordAddChart.getData().add(dataSeries2);

        vbox.getChildren().add(ordAddChart);

    }

    private void loadBarchartValoreTotaleOrd() {

        vbox.getChildren().clear();

        ArrayList<ValoreTotalePerAddetto> valoreTotalePerAddetto = (ArrayList<ValoreTotalePerAddetto>) statController.getValoriTotaliPerAddetto(datePickerInizio.getValue(), datePickerFine.getValue());

        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Addetti");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Valore ordini");

        BarChart ordAddChart = new BarChart(xAxis, yAxis);

        ordAddChart.setCategoryGap(50);

        // Creo una series di statistiche

        XYChart.Series dataSeries3 = new XYChart.Series();
        dataSeries3.setName("Valore totale ordinazioni");


        // Aggiungo i dati dalla lista al dataseries

        for(ValoreTotalePerAddetto val : valoreTotalePerAddetto){
            dataSeries3.getData().add(new XYChart.Data<>(val.getUsername(), val.getSum()));
        }

        // Aggiungo il dataseries al chart

        ordAddChart.getData().add(dataSeries3);

        vbox.getChildren().add(ordAddChart);

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
