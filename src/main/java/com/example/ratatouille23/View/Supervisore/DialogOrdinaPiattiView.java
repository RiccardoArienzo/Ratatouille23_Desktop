package com.example.ratatouille23.View.Supervisore;

import com.example.ratatouille23.Controller.Supervisore.DialogOrdinaCategorieController;
import com.example.ratatouille23.Controller.Supervisore.DialogOrdinaPiattiController;
import com.example.ratatouille23.Model.Categoria;
import com.example.ratatouille23.Model.Piatto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.util.ArrayList;
import java.util.List;

public class DialogOrdinaPiattiView {

    private DialogOrdinaPiattiController ordinaPiattiController;

    @FXML
    private HBox hboxButtons;

    @FXML
    private VBox vboxListview;

    private FlowPane flowpane;

    private ObservableList<Piatto> piatti;

    private ListView<Piatto> listaPiatti;

    private List<Categoria> listaCategorie;

    @FXML
    private Button btnConferma;

    private static final DataFormat PIATTO_DATA_FORMAT = new DataFormat(
            "application/piatto"
    );

    @FXML
    public void initialize() {

        this.ordinaPiattiController = new DialogOrdinaPiattiController(this);


        // QUI VA LA CHIAMATA AL CONTROLLER, con un categoriaDAO.getCategorie.
        // Ci inserisco dati farlocchi adesso.

        listaCategorie = new ArrayList<>();

        //TODO fare listaCategorie = controller.getCategorie;

        Piatto piatto1 = new Piatto("Pasta e cazzi", "€ 12",
                "Cazzi, coppole di minchia, palle, culi",
                "Un piatto contenente tanti bei cuolli di cazzo");

        Piatto piatto2 = new Piatto("Piatto 2", "€ 12",
                "Cazzi, coppole di minchia, palle, culi",
                "Un piatto contenente tanti bei cuolli di cazzo");

        Piatto piatto3 = new Piatto("Piatto 3", "€ 12",
                "Cazzi, coppole di minchia, palle, culi",
                "Un piatto contenente tanti bei cuolli di cazzo");

        ArrayList<Piatto> lista1 = new ArrayList<Piatto>();
        lista1.add(piatto1);
        lista1.add(piatto2);

        ArrayList<Piatto> lista2 = new ArrayList<Piatto>();
        lista2.add(piatto2);
        lista2.add(piatto3);
        lista2.add(piatto1);

        ArrayList<Piatto> lista3 = new ArrayList<Piatto>();
        lista3.add(piatto1);
        lista3.add(piatto3);
        lista3.add(piatto2);



        Categoria cat1 = new Categoria("Antipasti", lista1);

        Categoria cat2 = new Categoria("Primi piatti", lista2);

        Categoria cat3 = new Categoria("Secondi piatti", lista3);

        Categoria cat4 = new Categoria("Secondi piatti", lista3);
        Categoria cat5 = new Categoria("Secondi piatti", lista3);
        Categoria cat6 = new Categoria("Secondi piatti", lista3);
        Categoria cat7 = new Categoria("Secondi piatti", lista3);


        listaCategorie.add(cat1);
        listaCategorie.add(cat2);
        listaCategorie.add(cat3);
        listaCategorie.add(cat4);
        listaCategorie.add(cat5);
        listaCategorie.add(cat6);
        listaCategorie.add(cat7);

        flowpane = new FlowPane();
        flowpane.setPrefWidth(480);

        sceltaCategoriaDaOrdinare();
    }




    private void sceltaCategoriaDaOrdinare() {

        hboxButtons.getChildren().add(flowpane);
        ToggleGroup toggleGroup = new ToggleGroup();

        for (Categoria cat : listaCategorie) {
            ToggleButton btnCategoria = new ToggleButton(cat.getNome());
            btnCategoria.setPrefSize(120, 40);
            btnCategoria.setStyle("-fx-font-family: Tahoma; -fx-font-size: 16px; -fx-text-fill: white");
            btnCategoria.getStyleClass().add("button-orders");
            btnCategoria.setToggleGroup(toggleGroup);

            flowpane.getChildren().add(btnCategoria);

            btnCategoria.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    popolaListview(cat);
                }

            });

        }
    }


    private void popolaListview(Categoria cat) {

            piatti = FXCollections.observableArrayList(cat.getPiatti());

            listaPiatti = new ListView<>(piatti);

            listaPiatti.setCellFactory(param -> new DialogOrdinaPiattiView.PiattoCell());
            listaPiatti.setPrefSize(
                    430, 180
            );

            vboxListview.getChildren().clear();
            vboxListview.getChildren().add(listaPiatti);

        }





    private class PiattoCell extends ListCell<Piatto> {
        public PiattoCell() {
            final ListCell<Piatto> thisCell = this;

            setOnDragDetected(event -> {
                if (getItem() == null) {
                    return;
                }

                Dragboard dragboard = startDragAndDrop(TransferMode.MOVE);
                ClipboardContent content = new ClipboardContent();
                content.putString(getItem().toString());
                content.put(PIATTO_DATA_FORMAT, getItem());

                dragboard.setContent(content);

                event.consume();
            });

            setOnDragOver(event -> {
                if (event.getGestureSource() != thisCell &&
                        event.getDragboard().hasContent(PIATTO_DATA_FORMAT)) {
                    event.acceptTransferModes(TransferMode.MOVE);
                }

                event.consume();
            });

            setOnDragEntered(event -> {
                if (event.getGestureSource() != thisCell &&
                        event.getDragboard().hasContent(PIATTO_DATA_FORMAT)) {
                    setOpacity(0.3);
                }
            });

            setOnDragExited(event -> {
                if (event.getGestureSource() != thisCell &&
                        event.getDragboard().hasContent(PIATTO_DATA_FORMAT)) {
                    setOpacity(1);
                }
            });

            setOnDragDropped(event -> {
                if (getItem() == null) {
                    return;
                }

                Dragboard db = event.getDragboard();
                boolean success = false;

                if (db.hasContent(PIATTO_DATA_FORMAT)) {
                    Piatto droppedPiatto = (Piatto) db.getContent(
                            PIATTO_DATA_FORMAT
                    );


                    ObservableList<Piatto> items = getListView().getItems();
                    int draggedIdx = items.indexOf(
                            droppedPiatto
                    );


                    int thisIdx = items.indexOf(getItem());


                    System.out.println("Piatto era :" + piatti);


                    Piatto temp = piatti.get(draggedIdx);
                    piatti.set(draggedIdx, piatti.get(thisIdx));
                    piatti.set(thisIdx, temp);

                    System.out.println("Piatto è :" + piatti);

                    success = true;
                }
                event.setDropCompleted(success);

                event.consume();

            });

            setOnDragDone(DragEvent::consume);
        }

        @Override
        protected void updateItem(Piatto item, boolean empty) {
            super.updateItem(item, empty);

            setText(
                    (empty || item == null)
                            ? null
                            : item.getNomePiatto()
            );
        }
    }


    public void clickBtnConferma(){
        ordinaPiattiController.onBtnConfermaClicked();
    }

    public ListView<Piatto> getListaPiatti() {
        return listaPiatti;
    }
}
