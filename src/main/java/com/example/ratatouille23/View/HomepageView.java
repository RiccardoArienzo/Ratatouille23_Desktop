package com.example.ratatouille23.View;

import com.example.ratatouille23.Controller.HomepageController;
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

public class HomepageView implements ViewInterface {

    @FXML
    private BorderPane borderPane;
    @FXML
    private Label labelUsername;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private Node node;

    private String nomeNodo = "HomePage";

    private HomepageController homepageController;

    // *********************

    public HomepageView(){};

    @FXML
    public void initialize(){
        labelUsername.setText(Utente.getUsername());
        this.homepageController = new HomepageController(this);
    }

    // Metodi di View Interface
    @Override
    public Node loadNode() throws IOException {
        return FXMLLoader.load(getClass().getResource("/homepage/homepage.fxml"));
    }

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

    public void clickPulsanteCreaUtente(){
        homepageController.onCreaUtenteClicked();
    }

    public void clickPulsanteInserisciAvvisi(){
        homepageController.onInserisciAvvisiClicked();
    }

    public void apriSchermataHome() throws IOException {
        root = FXMLLoader.load(getClass().getResource("/homepage/homepage.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // Utility


     public void updateCenterView(Node node){
        borderPane.getChildren().remove(borderPane.getCenter());
        borderPane.setCenter(node);
     }

     public void updateRightView(Node node){
        borderPane.getChildren().remove(borderPane.getRight());
        borderPane.setCenter(node);
     }


    // Setter

    @FXML
    public void setHomepageController(HomepageController homepageController) {
        this.homepageController = homepageController;
    }
}
