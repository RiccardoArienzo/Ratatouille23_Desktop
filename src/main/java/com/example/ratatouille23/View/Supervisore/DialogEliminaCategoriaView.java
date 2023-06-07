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

    private void popolaListView() {

        listaCat.getItems().clear();

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

        ArrayList<Piatto> listina = new ArrayList<Piatto>();
        listina.add(piatto1);
        listina.add(piatto2);
        listina.add(piatto3);
        listina.add(piatto4);
        listina.add(piatto4);
        listina.add(piatto3);
        listina.add(piatto1);



        Categoria cat1 = new Categoria("Antipasti", listina);

        Categoria cat2= new Categoria("Primi piatti", listina);

        ArrayList<Categoria> lista = new ArrayList<Categoria>();

        lista.add(cat1);
        lista.add(cat2);

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
