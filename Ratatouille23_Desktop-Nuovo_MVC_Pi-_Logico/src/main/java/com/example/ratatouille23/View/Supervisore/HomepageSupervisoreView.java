package com.example.ratatouille23.View.Supervisore;

import com.example.ratatouille23.Controller.Amministratore.HomepageAdminController;
import com.example.ratatouille23.Controller.Supervisore.HomepageSupervisoreController;
import com.example.ratatouille23.Homepage;
import com.example.ratatouille23.Model.Utente;
import com.example.ratatouille23.ViewInterface;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HomepageSupervisoreView extends Homepage implements ViewInterface {


    @FXML
    private BorderPane borderPane;
    @FXML
    private Label labelUsername;
    @FXML
    private Label labelAvvisiDisponibili;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private Node node;

    private HomepageSupervisoreController homepageController;

    // *********************

    @FXML
    public void initialize(){
        labelUsername.setText(Utente.getUsername());
        this.homepageController = new HomepageSupervisoreController(this);
    }

    // Metodi di View Interface

    @Override
    public Node getNode(){
        return this.root;
    }

    @Override
    public void setNode(Node node){
        this.node = node;
    }

    //************************

    // Action event

    public void clickPulsantePersonalizzaMenu(){
        homepageController.onPersonalizzaMenuClicked();
    }

    public void clickPulsanteInserisciAvvisi(){
        homepageController.onInserisciAvvisiClicked();
    }

    public void clickBtnGestisciAvvisi() {
        homepageController.onGestisciAvvisiClicked();
    }

    public void apriSchermataHome() throws IOException {
        root = FXMLLoader.load(getClass().getResource("/homepage-admin.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    // Getter e Setter

    public Label getLabelAvvisiDisponibili() {
        return labelAvvisiDisponibili;
    }

}
