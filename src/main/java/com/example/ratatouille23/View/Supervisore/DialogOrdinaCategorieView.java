package com.example.ratatouille23.View.Supervisore;

import com.example.ratatouille23.Controller.AddettoCucina.OrdinazioniEvaseController;
import com.example.ratatouille23.Controller.Supervisore.DialogOrdinaCategorieController;
import com.example.ratatouille23.Model.Categoria;
import com.example.ratatouille23.Model.Piatto;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
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
        Piatto piatto1 = new Piatto("Pasta e cazzi", "€ 12",
                "Cazzi, coppole di minchia, palle, culi",
                "Un piatto contenente tanti bei cuolli di cazzo");

        ArrayList<Piatto> lista1 = new ArrayList<Piatto>();

        lista1.add(piatto1);


        Categoria cat1 = new Categoria("Antipasti", lista1);

        Categoria cat2 = new Categoria("Primi piatti", lista1);

        Categoria cat3 = new Categoria("Secondi piatti", lista1);

        Categoria cat4 = new Categoria("Dessert", lista1);



        ArrayList<Categoria> listaCat = new ArrayList<Categoria>();

        listaCat.add(cat1);
        listaCat.add(cat2);
        listaCat.add(cat3);
        listaCat.add(cat4);


        categorie = FXCollections.observableArrayList(listaCat);

        ListView<Categoria> listaCategorie = new ListView<>(categorie);

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

}






    /*

    private class CategoriaCell extends ListCell<Categoria> {



        public CategoriaCell() {
            final ListCell<Categoria> thisCell = this;

            setOnDragDetected(event -> {
                if (getItem()==null) {
                    return;
                }

                Dragboard dragboard = startDragAndDrop(TransferMode.MOVE);
                ClipboardContent content = new ClipboardContent();
                //content.putString(getItem().toString());
                content.put(CATEGORY_DATA_FORMAT, getItem());

                dragboard.setContent(content);

                System.out.println("il content della dragboard è " + dragboard.getContent(CATEGORY_DATA_FORMAT));

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

                System.out.println("ho draggato su " + getItem());

                if (getItem().equals(null)) {
                    return;
                }

                Dragboard db = event.getDragboard();
                boolean success = false;

                if (db.hasContent(CATEGORY_DATA_FORMAT)) {
                    Categoria droppedCategory = (Categoria) db.getContent(
                            CATEGORY_DATA_FORMAT
                    );

                    System.out.println("nell'HasContent, droppedcategory è " + droppedCategory);


                    ObservableList<Categoria> items = getListView().getItems();

                    System.out.println("items è " + items);

                    int draggedIdx = items.indexOf(droppedCategory);

                    System.out.println("l'index di droppedcategory è " + draggedIdx);



                    int thisIdx = items.indexOf(getItem());

                    System.out.println("l'index di thisidx è " + thisIdx);

                    Categoria temp = categorie.get(draggedIdx);
                    categorie.set(draggedIdx, categorie.get(thisIdx));
                    categorie.set(thisIdx, temp);

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
                    (empty || item.equals(null))
                            ? null
                            : item.getNome()
            );
        }


    }


     */




