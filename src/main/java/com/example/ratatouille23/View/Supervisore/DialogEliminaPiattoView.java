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

        Piatto piatto1 = new Piatto("Pasta e cazzi", "€ 12",
                "Cazzi, coppole di minchia, palle, culi",
                "Un piatto contenente tanti bei cuolli di cazzo");

        Piatto piatto2 = new Piatto("Antipasto di minchia", "€ 16",
                "Nessuno", "Un ricco antipasto di capocchia imbuttunata");

        Piatto piatto3 = new Piatto("Il tributo di RobMcCum", "€69",
                "Liquido seminale", "Che dire. Un bel frullato di lasagne sborrate dal mitico rob Mcquack.");

        Piatto piatto4 = new Piatto("Abbasso l'università", "Dipende dall'ISEE",
                "Salvatore Corrado, Flavio Arienzo, SDM, Starace e tutt a maronn ro carmn", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");


        ArrayList<Piatto> lista = new ArrayList<>();

        lista.add(piatto1);
        lista.add(piatto2);
        lista.add(piatto3);
        lista.add(piatto4);


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
