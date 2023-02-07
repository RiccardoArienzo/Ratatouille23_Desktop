package com.example.ratatouille23.personalizzaMenu;

import com.example.ratatouille23.homepage.Homepage;
import com.example.ratatouille23.homepage.HomepageController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class PersonalizzaMenuController {

    @FXML
    Accordion listaCategorie;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private Homepage home = new Homepage();

    private SchermataPersonalizzaMenu personalizzaMenu = new SchermataPersonalizzaMenu();

    private SchermataNuovoPiatto nuovoPiatto = new SchermataNuovoPiatto();




    public void clickPulsantePiu(ActionEvent e){
        AnchorPane newPanelContent = new AnchorPane();
        newPanelContent.getChildren().add(new Label("Hello World"));
        TitledPane pane = new TitledPane("World Pane", newPanelContent);
        listaCategorie.getPanes().add(pane);
    }

    public void clickPulsanteAggiungiPiatto(ActionEvent event){
        try {
            nuovoPiatto.apriSchermataNuovoPiatto(event);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickPulsanteIndietroPersonalizzaMenu(ActionEvent event){
        try {
            home.apriSchermataHome(event);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickPulsanteIndietroNuovoPiatto(ActionEvent event){
        try {
            personalizzaMenu.apriSchermataPersonalizzaMenu(event);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
