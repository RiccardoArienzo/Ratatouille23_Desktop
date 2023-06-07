package com.example.ratatouille23.View.AddettoSala;

import com.example.ratatouille23.Controller.AddettoSala.RegistraOrdinazioniController;
import com.example.ratatouille23.Model.Categoria;
import com.example.ratatouille23.Model.Ordinazione;
import com.example.ratatouille23.Model.Piatto;
import com.example.ratatouille23.ViewInterface;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class RegistraOrdinazioniView implements ViewInterface {

    @FXML
    private BorderPane borderPane;
    @FXML
    private Accordion listaPiatti;
    @FXML
    private VBox vboxButtonsCategorie;
    @FXML
    private VBox riepilogoVbox;
    @FXML
    private ComboBox tavoloComboBox;
    @FXML
    private Button btnConfermaOrdinazione;
    @FXML
    private Button btnCancellaOrdinazione;

    private Node node;

    private Stage stage;

    private RegistraOrdinazioniController registraOrdinazioniController;


    @FXML
    public void initialize() {

        this.registraOrdinazioniController = new RegistraOrdinazioniController(this);

        btnConfermaOrdinazione.disableProperty().bind(
                Bindings.createBooleanBinding(
                        () -> riepilogoVbox.getChildren().isEmpty()  || tavoloComboBox.getValue() == null,
                        riepilogoVbox.getChildren(),
                        tavoloComboBox.valueProperty()
                )
        );


        popolaSchermataOrdinazioni();

        // Popolamento della lista con valori da 1 a 10
        for (int i = 1; i <= 10; i++) {
            tavoloComboBox.getItems().add(String.valueOf(i));
        }

        // Impostiamo il listener per la combobox
        tavoloComboBox.setOnAction(event -> {
        String selectedValue = (String) tavoloComboBox.getValue();
        registraOrdinazioniController.impostaTavolo(selectedValue);
        updateRiepilogo();

        });

        /*
        Text tavoloText = new Text("Tavolo non selezionato");
        tavoloText.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));

        riepilogoVbox.getChildren().add(tavoloText);


         */
    }







    public void popolaSchermataOrdinazioni(){

        //ArrayList<Categoria> listaCat = registraOrdinazioniController.getCategorie();

        Piatto piatto1 = new Piatto("Pasta e cazzi", "€ 12",
                "Cazzi, coppole di minchia, palle, culi",
                "Un piatto contenente tanti bei cuolli di cazzo");

        Piatto piatto2 = new Piatto("Antipasto di minchia", "€ 16",
                "Nessuno", "Un ricco antipasto di capocchia imbuttunata");

        Piatto piatto3 = new Piatto("Il tributo di RobMcCum", "€69",
                "Liquido seminale", "Che dire. Un bel frullato di lasagne sborrate dal mitico rob Mcquack.");

        Piatto piatto4 = new Piatto("Abbasso l'università", "Dipende dall'ISEE",
                "Salvatore Corrado, Flavio Arienzo, SDM, Starace e tutt a maronn ro carmn", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");

        ArrayList<Piatto> lista1 = new ArrayList<Piatto>();
        ArrayList<Piatto> lista2 = new ArrayList<Piatto>();

        lista1.add(piatto1);
        lista1.add(piatto2);
        lista2.add(piatto3);
        lista2.add(piatto4);




        Categoria cat1 = new Categoria("Antipasti", lista1);

        Categoria cat2= new Categoria("Primi piatti", lista2);

        ArrayList<Categoria> listaCat = new ArrayList<>();
        listaCat.add(cat1);
        listaCat.add(cat2);


        ToggleGroup toggleGroup = new ToggleGroup();

        for (Categoria cat : listaCat) {
            ToggleButton btnCategoria = new ToggleButton(cat.getNome());
            btnCategoria.setPrefSize(200, 63);
            btnCategoria.setStyle("-fx-font-family: Tahoma; -fx-font-size: 23px; -fx-text-fill: white");
            btnCategoria.getStyleClass().add("button-orders");
            btnCategoria.setToggleGroup(toggleGroup);

            vboxButtonsCategorie.getChildren().add(btnCategoria);

            btnCategoria.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {

                    listaPiatti.getPanes().clear();

                    // Questo funziona solo se utilizzato in questo modo. Va implementato nella versione con backend.
                   // ArrayList<Piatto> piatti = categoriaDao.getCategoriaByNome(btnCategoria.getText()).getPiatti();

                    ArrayList<Piatto> piatti = lista1;
                    // Da cancellare

                    for (Piatto piatto : piatti) {
                        TitledPane TPPiatto = new TitledPane();
                        TPPiatto.setText(piatto.getNomePiatto());

                        // Piatti


                        // Nome
                        TextFlow nomePiatto = new TextFlow();

                        Text boldText = new Text("Nome: ");
                        boldText.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
                        Text plainText = new Text(piatto.getNomePiatto());
                        plainText.setFont(Font.font("Tahoma", 16));

                        nomePiatto.getChildren().addAll(boldText, plainText);

                        // Costo
                        TextFlow costoPiatto = new TextFlow();

                        Text boldText2 = new Text("Costo: ");
                        boldText2.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
                        Text plainText2 = new Text(piatto.getCostoPiatto());
                        plainText2.setFont(Font.font("Tahoma", 16));

                        costoPiatto.getChildren().addAll(boldText2, plainText2);

                        // Descrizione
                        TextFlow descrizionePiatto = new TextFlow();

                        Text boldText3 = new Text("Descrizione: ");
                        boldText3.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
                        Text plainText3 = new Text(piatto.getDescrizione());
                        plainText3.setFont(Font.font("Tahoma", 16));

                        descrizionePiatto.getChildren().addAll(boldText3, plainText3);

                        // Allergeni
                        TextFlow allergeniPiatto = new TextFlow();

                        Text boldText4 = new Text("Allergeni: ");
                        boldText4.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
                        Text plainText4 = new Text(piatto.getAllergeni());
                        plainText4.setFont(Font.font("Tahoma", 16));

                        allergeniPiatto.getChildren().addAll(boldText4, plainText4);

                        // quantità
                        Button minus = new Button("-");
                       // TextField quantity = new TextField("0");
                        Button plus = new Button("+");

                      //  quantity.getStyleClass().add("textfield");
                       // quantity.setPrefWidth(30);
                      //  quantity.setPrefHeight(29);
                        minus.getStyleClass().add("circular-button");
                        plus.getStyleClass().add("circular-button");


                        minus.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                              //  int value = Integer.parseInt(quantity.getText());
                              //  if (value > 0) {
                                    registraOrdinazioniController.decrementaQuantity(piatto);
                                    updateRiepilogo();
                                }
                           // }
                        });

                        plus.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                registraOrdinazioniController.incrementaQuantity(piatto);
                                updateRiepilogo();
                            }
                        });

                        HBox chooseQuantity = new HBox();
                        chooseQuantity.getChildren().addAll(minus, plus);
                        chooseQuantity.setAlignment(Pos.CENTER);
                        chooseQuantity.setSpacing(8);


                        VBox content = new VBox();
                        content.getChildren().addAll(nomePiatto, costoPiatto, descrizionePiatto, allergeniPiatto, chooseQuantity);

                        TPPiatto.setContent(content);
                        listaPiatti.getPanes().add(TPPiatto);
                    }


               }
            });
        }
    }

    public void updateRiepilogo(){

        // Clear della Vbox per aggiornarla con i valori corretti
        riepilogoVbox.getChildren().clear();

        /*
        Text tavoloText;

        if (registraOrdinazioniController.getOrdinazione().getIdTavolo() == null){
            tavoloText = new Text("Tavolo non selezionato");
            tavoloText.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
        } else {
            tavoloText = new Text("Tavolo " + registraOrdinazioniController.getOrdinazione().getIdTavolo());
            tavoloText.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
        }

        riepilogoVbox.getChildren().add(tavoloText);
*/

        for (HashMap.Entry<Piatto, Ordinazione.InfoOrdine> map : registraOrdinazioniController.getOrdinazione().getPiattiOrdinazione().entrySet()){

            Text piatto = new Text(map.getKey().getNomePiatto() + ": " + "x" + map.getValue().getQuantity());
            piatto.setFont(Font.font("Tahoma", FontWeight.SEMI_BOLD, 16));

            riepilogoVbox.getChildren().add(piatto);

        }
    }


    // Action Event

    public void clickBtnConfermaOrdinazione(){
        registraOrdinazioniController.onBtnConfermaOrdinazioneClicked();
    }

    public void clickBtnCancellaOrdinazione(){
        registraOrdinazioniController.onBtnCancellaOrdinazioneClicked();
    }


    public ComboBox getTavoloComboBox() {
        return tavoloComboBox;
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

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
