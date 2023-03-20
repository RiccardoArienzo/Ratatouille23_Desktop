package com.example.ratatouille23.homepage;

import com.example.ratatouille23.Model.Utente;
import com.example.ratatouille23.View;
import com.example.ratatouille23.View2;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HomepageView extends View2 {

    @FXML
    BorderPane borderPane;
    @FXML
    Label labelUsername;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private String nomeNodo = "HomePage";

    HomepageController homepageController;

    // *********************



    @FXML
    public void initialize(){
        labelUsername.setText(Utente.getUsername());
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



    @Override
    public Node caricaNodo() throws IOException {
        return FXMLLoader.load(getClass().getResource("/homepage/homepage.fxml"));
    }


}
