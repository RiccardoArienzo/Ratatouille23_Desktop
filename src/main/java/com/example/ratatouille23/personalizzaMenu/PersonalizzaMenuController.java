package com.example.ratatouille23.personalizzaMenu;

import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;

import java.util.Optional;

public class PersonalizzaMenuController {

    PersonalizzaMenuView personalizzaMenu;

    PersonalizzaMenuController(PersonalizzaMenuView personalizzamenu){
        this.personalizzaMenu = personalizzamenu;
    }


    public void onPulsanteAggiungiCategoriaClicked() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Crea nuova categoria");
        dialog.setHeaderText("Inserisci il nome della nuova categoria");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(name -> {
            AnchorPane newPanelContent = new AnchorPane();
            newPanelContent.getChildren().add(new Label("Hello World"));
            TitledPane pane = new TitledPane(name, newPanelContent);
            personalizzaMenu.listaCategorie.getPanes().add(pane);

            //TODO aggiungere qui il codice che crea una categoria e la manda al db

        });
    }

    public void onPulsanteAggiungiPiattoClicked() {

        /*
            try {
            Dialog aggiungiPiattoDialog = new Dialog<>();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/personalizzaMenu/nuovo-piatto.fxml"));
            aggiungiPiattoDialog.getDialogPane().setContent(loader.load());

            aggiungiPiattoDialog.setTitle("Aggiungi piatto");
            aggiungiPiattoDialog.setResizable(false);

            aggiungiPiattoDialog.showAndWait();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

         */
    }


}
