package com.example.ratatouille23.View.Supervisore;

//import com.example.ratatouille23.Controller.AddettoCucina.OrdinazioniEvaseController;
import com.example.ratatouille23.Controller.Supervisore.DialogOrdinaCategorieController;
import com.example.ratatouille23.Model.Categoria;
import com.example.ratatouille23.Model.Piatto;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.*;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

import java.util.ArrayList;
import java.util.List;

public class DialogOrdinaCategorieView {


    private DialogOrdinaCategorieController ordinaCategorieController;

    @FXML
    private VBox vbox;

    private ObservableList<Categoria> categorie;

    private ListView<Categoria> listaCategorie;

    @FXML
    private Button btnConferma;

    private static final DataFormat CATEGORY_DATA_FORMAT = new DataFormat(
            "application/categoria"
    );

    @FXML
    public void initialize() {

        this.ordinaCategorieController = new DialogOrdinaCategorieController(this);

        popolaListview();
    }

    private void popolaListview() {

        // popolare l'accordion. questo codice va messo in controller

        ArrayList<Categoria> listaCat = (ArrayList<Categoria>) ordinaCategorieController.getCategorie();


        categorie = FXCollections.observableArrayList(listaCat);

        listaCategorie = new ListView<>(categorie);

        listaCategorie.setCellFactory(param -> new CategoriaCell());
        listaCategorie.setPrefSize(
                430, 180
        );

        vbox.getChildren().add(listaCategorie);
    }

    private class CategoriaCell extends ListCell<Categoria> {
        public CategoriaCell() {
            final ListCell<Categoria> thisCell = this;

            setOnDragDetected(event -> {
                if (getItem() == null) {
                    return;
                }

                Dragboard dragboard = startDragAndDrop(TransferMode.MOVE);
                ClipboardContent content = new ClipboardContent();
                content.putString(getItem().toString());
                content.put(CATEGORY_DATA_FORMAT, getItem());

                dragboard.setContent(content);

                event.consume();
            });

            setOnDragOver(event -> {
                if (event.getGestureSource() != thisCell &&
                        event.getDragboard().hasContent(CATEGORY_DATA_FORMAT)) {
                    event.acceptTransferModes(TransferMode.MOVE);
                }

                event.consume();
            });

            setOnDragEntered(event -> {
                if (event.getGestureSource() != thisCell &&
                        event.getDragboard().hasContent(CATEGORY_DATA_FORMAT)) {
                    setOpacity(0.3);
                }
            });

            setOnDragExited(event -> {
                if (event.getGestureSource() != thisCell &&
                        event.getDragboard().hasContent(CATEGORY_DATA_FORMAT)) {
                    setOpacity(1);
                }
            });

            setOnDragDropped(event -> {
                if (getItem() == null) {
                    return;
                }

                Dragboard db = event.getDragboard();
                boolean success = false;

                if (db.hasContent(CATEGORY_DATA_FORMAT)) {
                    Categoria droppedCategory = (Categoria) db.getContent(
                            CATEGORY_DATA_FORMAT
                    );


                    ObservableList<Categoria> items = getListView().getItems();
                    int draggedIdx = items.indexOf(
                            droppedCategory
                    );

                    System.out.println("draggedidx è " + draggedIdx);

                    int thisIdx = items.indexOf(getItem());

                    System.out.println("thisidx è " + thisIdx);

                    System.out.println("Categorie era :" + categorie);


                    Categoria temp = categorie.get(draggedIdx);
                    categorie.set(draggedIdx, categorie.get(thisIdx));
                    categorie.set(thisIdx, temp);

                    System.out.println("Categorie è :" + categorie);

                    success = true;
                }
                event.setDropCompleted(success);

                event.consume();

            });

            setOnDragDone(DragEvent::consume);
        }

        @Override
        protected void updateItem(Categoria item, boolean empty) {
            super.updateItem(item, empty);

            setText(
                    (empty || item == null)
                            ? null
                            : item.getNome()
            );
        }
    }



    public void clickBtnConferma(){
        ordinaCategorieController.onBtnConfermaClicked();
    }

    public ListView<Categoria> getListaCategorie() {
        return listaCategorie;
    }
}






