package com.example.ratatouille23.View;

import com.example.ratatouille23.Controller.PersonalizzaMenuController;
import com.example.ratatouille23.Model.Categoria;
import com.example.ratatouille23.Model.Piatto;
import com.example.ratatouille23.ViewInterface;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class PersonalizzaMenuView implements ViewInterface {

    @FXML
    private Accordion listaCategorie;

    @FXML
    private Button btnAggiungiCategoria;

    @FXML
    private Button btnAggiungiPiatto;
    private Node node;
    private PersonalizzaMenuController personalizzaMenuController;


    @FXML
    public void initialize(){

        this.personalizzaMenuController = new PersonalizzaMenuController(this);
        popolaMenuAccordion();

    }

    public void popolaMenuAccordion(){
       ArrayList<Categoria> listaCat = (ArrayList<Categoria>) personalizzaMenuController.ottieniCategorie();

//       long categoriaCounter = 0;
//       long piattoCounter = 0;

       for (Categoria cat : listaCat) {
            TitledPane titledPane = new TitledPane();
            titledPane.setText(cat.getNome()); // imposto il titolo del TitledPane con il nome della cat
//            categoriaCounter++;
//            personalizzaMenuController.aggiornaContatoreCategoria(cat.getIdCategoria(), categoriaCounter);

            Accordion accordion = new Accordion();

            for (Piatto piatto : cat.getPiatti()){
                TitledPane TPPiatto = new TitledPane();
                TPPiatto.setText(piatto.getNomePiatto());
//                piattoCounter++;
//                personalizzaMenuController.aggiornaContatorePiatto(piatto.getIdPiatto() ,piattoCounter);

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

                Text boldText4 = new Text("Nome: ");
                boldText4.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
                Text plainText4 = new Text(piatto.getAllergeni());
                plainText4.setFont(Font.font("Tahoma", 16));

                allergeniPiatto.getChildren().addAll(boldText4, plainText4);


                VBox content = new VBox();
                content.getChildren().addAll(nomePiatto, costoPiatto, descrizionePiatto, allergeniPiatto);

                TPPiatto.setContent(content);
                accordion.getPanes().add(TPPiatto);
            }
            titledPane.setContent(accordion);
            listaCategorie.getPanes().add(titledPane);
        }
    }




    // Metodi di View Interface

    @Override
    public Node getNode(){
        return this.node;
    }
    @Override
    public void setNode(Node node) {
        this.node = node;
    }


    public void clickBtnAggiungiCategoria() {
        personalizzaMenuController.onPulsanteAggiungiCategoriaClicked();
    }


    public PersonalizzaMenuController getPersonalizzaMenuController() {
        return personalizzaMenuController;
    }

    public void clickBtnEliminaCategoria(){
        personalizzaMenuController.onPulsanteEliminaCategoriaClicked();
    }

    public void clickBtnEliminaPiatto(){
        personalizzaMenuController.onPulsanteEliminaPiattoClicked();
    }

    public void clickBtnOrdinaCategorie() {
        personalizzaMenuController.onBtnOrdinaCategorieClicked();
    }

    public void clickBtnOrdinaPiatti() {
        personalizzaMenuController.onBtnOrdinaPiattiClicked();
    }
}





