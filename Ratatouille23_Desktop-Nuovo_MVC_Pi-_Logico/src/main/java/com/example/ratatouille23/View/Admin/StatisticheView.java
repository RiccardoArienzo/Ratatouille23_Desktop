package com.example.ratatouille23.View.Admin;

import com.example.ratatouille23.Controller.Amministratore.CreaUtenteController;
import com.example.ratatouille23.Controller.Amministratore.StatisticheController;
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

        // INIZIO DATI FARLOCCHI

        ArrayList<String> addetti = new ArrayList<>();
        addetti.add("Carlo");
        addetti.add("Riccardo");
        addetti.add("Leon Scott Kennedy");
        addetti.add("Franco Ricciardi");

        // questa è una count

        ArrayList<Double> ordinazioni = new ArrayList<>();
        ordinazioni.add(Double.valueOf(12));
        ordinazioni.add(Double.valueOf(45));
        ordinazioni.add(Double.valueOf(6));
        ordinazioni.add(Double.valueOf(20));


        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Addetti");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Ordini");

        BarChart ordAddChart = new BarChart(xAxis, yAxis);

        // Creo una series di statistiche

        XYChart.Series dataSeries1 = new XYChart.Series();
        dataSeries1.setName("Ordinazioni per addetto");

        // Aggiungo i dati dalla lista al dataseries

        for (int i = 0; i<4; i++) {
            dataSeries1.getData().add(new XYChart.Data<>(addetti.get(i), ordinazioni.get(i)));
        }

        // Aggiungo il dataseries al chart

        ordAddChart.getData().add(dataSeries1);



        // NUOVO SERIES

        ArrayList<Double> ordinazioniMediePerGiorno = new ArrayList<>();
        ordinazioniMediePerGiorno.add(Double.valueOf(7));
        ordinazioniMediePerGiorno.add(Double.valueOf(14));
        ordinazioniMediePerGiorno.add(Double.valueOf(5));
        ordinazioniMediePerGiorno.add(Double.valueOf(18));

        // Creo una series di statistiche

        XYChart.Series dataSeries2 = new XYChart.Series();
        dataSeries2.setName("Ordinazioni in media per giorno");

        // Aggiungo i dati dalla lista al dataseries

        for (int i = 0; i<4; i++) {
            dataSeries2.getData().add(new XYChart.Data<>(addetti.get(i), ordinazioniMediePerGiorno.get(i)));
        }

        // Aggiungo il dataseries al chart

        ordAddChart.getData().add(dataSeries2);

        vbox.getChildren().add(ordAddChart);

    }

    private void loadBarchartValoreTotaleOrd() {

        vbox.getChildren().clear();

        // INIZIO DATI FARLOCCHI

        ArrayList<String> addetti = new ArrayList<>();
        addetti.add("Carlo");
        addetti.add("Riccardo");
        addetti.add("Leon Scott Kennedy");
        addetti.add("Franco Ricciardi");


        ArrayList<Double> valoreTotOrd = new ArrayList<>();
        valoreTotOrd.add(Double.valueOf(567));
        valoreTotOrd.add(Double.valueOf(154));
        valoreTotOrd.add(Double.valueOf(25));
        valoreTotOrd.add(Double.valueOf(890));

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

        for (int i = 0; i<4; i++) {
            dataSeries3.getData().add(new XYChart.Data<>(addetti.get(i), valoreTotOrd.get(i)));
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
