package com.example.ratatouille23.View.AddettoCucina;

import com.example.ratatouille23.Controller.AddettoCucina.HomepageCucinaController;
import com.example.ratatouille23.Controller.AddettoSala.HomepageSalaController;
import com.example.ratatouille23.Model.Utente;
import com.example.ratatouille23.ViewInterface;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HomepageCucinaView implements ViewInterface {

    @FXML
    private BorderPane borderPane;
    @FXML
    private Label labelUsername;
    @FXML
    private Label labelAvvisiDisponibili;
    @FXML
    private Button btnGestisciAvvisi;
    @FXML
    private Button btnGestisciOrdinazioni;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private Node node;

    private HomepageCucinaController homepageCucinaController;

    // *********************

    public HomepageCucinaView(){};

    @FXML
    public void initialize(){
        labelUsername.setText(Utente.getUsername());
        this.homepageCucinaController = new HomepageCucinaController(this);
    }


    // Event Handler

    public void clickBtnGestisciAvvisi(){
        homepageCucinaController.onGestisciAvvisiClicked();
    }

    public void clickBtnGestisciOrdinazioni(){
        homepageCucinaController.onGestisciOrdinazioniClicked();
    }

    // Metodi di View Interface
    @Override
    public Node loadNode() throws IOException {
        return FXMLLoader.load(getClass().getResource("/homepage-sala.fxml"));
    }

    @Override
    public Node getNode(){
        return this.root;
    }

    @Override
    public void setNode(Node node){
        this.node = node;
    }


    // Utility

    public void updateCenterView(Node node){
        borderPane.getChildren().remove(borderPane.getCenter());
        borderPane.setCenter(node);
    }

    public void removeRightView(){
        borderPane.getChildren().remove(borderPane.getRight());
        VBox placeholder = new VBox();
        placeholder.setPrefSize(440,700);
        borderPane.setRight(placeholder);
    }
}
