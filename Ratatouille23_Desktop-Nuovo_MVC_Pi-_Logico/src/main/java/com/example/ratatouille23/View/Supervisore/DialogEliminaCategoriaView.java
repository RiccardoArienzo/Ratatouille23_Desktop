package com.example.ratatouille23.View.Supervisore;

import com.example.ratatouille23.Controller.Supervisore.DialogEliminaCategoriaController;
import com.example.ratatouille23.Controller.Supervisore.DialogEliminaPiattoController;
import com.example.ratatouille23.Model.Categoria;
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

public class DialogEliminaCategoriaView {
    @FXML
    private Button btnConferma;
    @FXML
    private ListView<Categoria> listaCat;



    private DialogEliminaCategoriaController dialogEliminaCategoriaController;

    @FXML
    public void initialize(){
        this.dialogEliminaCategoriaController = new DialogEliminaCategoriaController(this);

        btnConferma.setDisable(true);

        popolaListView();

        // Aggiungi la cell factory alla ListView
        AtomicInteger counter = new AtomicInteger();
        listaCat.setCellFactory(CheckBoxListCell.forListView(new Callback<Categoria, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(Categoria cat) {
                BooleanProperty observable = new SimpleBooleanProperty();
                observable.addListener((obs, wasSelected, isNowSelected) -> {
                    if (isNowSelected) {
                        if (counter.incrementAndGet() > 0){
                            btnConferma.setDisable(false);
                        }
                        dialogEliminaCategoriaController.getCategorieDaEliminare().add(cat);
                    } else {
                        dialogEliminaCategoriaController.getCategorieDaEliminare().remove(cat);
                        if (counter.decrementAndGet() == 0){
                            btnConferma.setDisable(true);
                        }
                    }
                });
                return observable ;
            }
        }));
    }

    public void popolaListView() {

        listaCat.getItems().clear();

        //TODO stesso discorso del piatto, forse va fatta una chiamata al DAO?

        ArrayList<Categoria> lista = (ArrayList<Categoria>) dialogEliminaCategoriaController.getCategorie();

        for (Categoria cat: lista){
            listaCat.getItems().add(cat);
        }

    }

    public void clickBtnConferma(){
        dialogEliminaCategoriaController.onBtnConfermaClicked();
    }


    public ListView getListaCategorie() {
        return listaCat;
    }
}
