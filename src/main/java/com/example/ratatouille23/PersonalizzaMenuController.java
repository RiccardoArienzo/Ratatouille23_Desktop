package com.example.ratatouille23;

import com.example.ratatouille23.HomepageController;
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
    {
        try {
            homepageController = loadHomePageController();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public HomepageController loadHomePageController() throws IOException {
        FXMLLoader loaderHomepageController = new FXMLLoader(getClass().getResource("homepage.fxml"));
        root = loaderHomepageController.load();
        return loaderHomepageController.getController();
    }
    public void apriSchermataMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("personalizza-menu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void clickPulsanteIndietro(ActionEvent e) throws IOException{
        homepageController.apriSchermataHome(e);
    }

    public void clickPulsantePiu(ActionEvent e){
        AnchorPane newPanelContent = new AnchorPane();
        newPanelContent.getChildren().add(new Label("Hello World"));
        TitledPane pane = new TitledPane("World Pane", newPanelContent);
        System.out.println(listaCategorie);
        listaCategorie.getPanes().add(pane);
    }

}
