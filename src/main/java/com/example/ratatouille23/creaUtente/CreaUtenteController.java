package com.example.ratatouille23.creaUtente;

import com.example.ratatouille23.homepage.HomepageController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CreaUtenteController {

    private Stage stage;
    private Scene scene;
    private Parent root;


    public void tornaAllaHome(ActionEvent e) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/homepage/homepage.fxml"));
        root = loader.load();
        HomepageController homepageController = loader.getController();
        homepageController.apriSchermataHome(e);
    }


    public void apriSchermataCreaUtente(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/creaUtente/crea-utente.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
