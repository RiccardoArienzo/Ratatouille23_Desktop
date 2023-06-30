package com.example.ratatouille23.View.Supervisore;

import com.example.ratatouille23.Controller.Supervisore.DialogEliminaPiattoController;
import com.example.ratatouille23.Model.Piatto;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.util.Callback;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class DialogEliminaPiattoView {

    @FXML
    private Button btnConferma;
    @FXML
    private ListView<Piatto> listaPiatti;



    private DialogEliminaPiattoController dialogEliminaPiattoController;

    @FXML
    public void initialize(){
        this.dialogEliminaPiattoController = new DialogEliminaPiattoController(this);

        btnConferma.setDisable(true);

       popolaListView();

        // Aggiungi la cell factory alla ListView
        AtomicInteger counter = new AtomicInteger();
        listaPiatti.setCellFactory(CheckBoxListCell.forListView(new Callback<Piatto, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(Piatto piatto) {
                BooleanProperty observable = new SimpleBooleanProperty();
                observable.addListener((obs, wasSelected, isNowSelected) -> {
                    if (isNowSelected) {
                        if (counter.incrementAndGet() > 0){
                            btnConferma.setDisable(false);
                        }
                        dialogEliminaPiattoController.getPiattiDaEliminare().add(piatto);
                    } else {
                        dialogEliminaPiattoController.getPiattiDaEliminare().remove(piatto);
                        if (counter.decrementAndGet() == 0){
                            btnConferma.setDisable(true);
                        }
                    }
                });
                return observable ;
            }
        }));
    }

    private void popolaListView() {

        listaPiatti.getItems().clear();


        //TODO la chiamata deve essere a getPiattiDaEliminare o una chiamata al DAO?

        ArrayList<Piatto> lista = (ArrayList<Piatto>) dialogEliminaPiattoController.getPiatti();


        for (Piatto piatto: lista){
            listaPiatti.getItems().add(piatto);
        }

    }

    public void clickBtnConferma(){
        dialogEliminaPiattoController.onBtnConfermaClicked();
    }


    public ListView getListaPiatti() {
        return listaPiatti;
    }
}
