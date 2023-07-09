package com.example.ratatouille23.Controller;

import com.example.ratatouille23.Controller.Supervisore.HomepageSupervisoreController;
import com.example.ratatouille23.Homepage;
import com.example.ratatouille23.Main;
import com.example.ratatouille23.View.Admin.HomepageAdminView;
import com.example.ratatouille23.View.NuovoPiattoView;
import com.example.ratatouille23.View.PersonalizzaMenuView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class PersonalizzaMenuController {

    private PersonalizzaMenuView personalizzaMenu;


    public PersonalizzaMenuController(PersonalizzaMenuView view){
        this.personalizzaMenu = view;
    };

    public void onPulsanteAggiungiCategoriaClicked() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Crea nuova categoria");
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(Main.getPrimaryStage());
        dialog.setHeaderText("Inserisci il nome della nuova categoria");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(name -> {
            AnchorPane newPanelContent = new AnchorPane();
            newPanelContent.getChildren().add(new Label("Hello World"));
            TitledPane pane = new TitledPane(name, newPanelContent);
            //personalizzaMenu.listaCategorie.getPanes().add(pane);

            //TODO aggiungere qui il codice che crea una categoria e la manda al db

        });
    }

    public void onPulsanteEliminaCategoriaClicked() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/elimina-categoria.fxml"));
            Stage newStage = new Stage();
            newStage.initOwner(Main.getPrimaryStage());
            newStage.initModality(Modality.APPLICATION_MODAL); // Questa riga rende la nuova finestra modale rispetto alla finestra principale
            newStage.setScene(new Scene(loader.load()));
            newStage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public void onPulsanteEliminaPiattoClicked() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/elimina-piatto.fxml"));
            Stage newStage = new Stage();
            newStage.initOwner(Main.getPrimaryStage());
            newStage.initModality(Modality.APPLICATION_MODAL); // Questa riga rende la nuova finestra modale rispetto alla finestra principale
            newStage.setScene(new Scene(loader.load()));
            newStage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void onBtnOrdinaCategorieClicked() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ordina-categorie.fxml"));
            Stage newStage = new Stage();
            newStage.initOwner(Main.getPrimaryStage());
            newStage.initModality(Modality.APPLICATION_MODAL); // Questa riga rende la nuova finestra modale rispetto alla finestra principale
            newStage.setScene(new Scene(loader.load()));
            newStage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void onBtnOrdinaPiattiClicked() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ordina-piatti.fxml"));
            Stage newStage = new Stage();
            newStage.initOwner(Main.getPrimaryStage());
            newStage.initModality(Modality.APPLICATION_MODAL); // Questa riga rende la nuova finestra modale rispetto alla finestra principale
            newStage.setScene(new Scene(loader.load()));
            newStage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
