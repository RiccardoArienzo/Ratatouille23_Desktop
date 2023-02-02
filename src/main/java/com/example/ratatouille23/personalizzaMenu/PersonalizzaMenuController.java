package com.example.ratatouille23.personalizzaMenu;

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

    private HomepageController homepageController;



    public void apriSchermataPersonalizzaMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/personalizzaMenu/personalizza-menu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void clickPulsantePiu(ActionEvent e){
        AnchorPane newPanelContent = new AnchorPane();
        newPanelContent.getChildren().add(new Label("Hello World"));
        TitledPane pane = new TitledPane("World Pane", newPanelContent);
        listaCategorie.getPanes().add(pane);
    }


    public void clickPulsanteIndietro(ActionEvent event){
        try{
            FXMLLoader loaderHPC = new FXMLLoader(getClass().getResource("/homepage/homepage.fxml"));
            root = loaderHPC.load();
            homepageController = loaderHPC.getController();
            homepageController.apriSchermataHome(event);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
