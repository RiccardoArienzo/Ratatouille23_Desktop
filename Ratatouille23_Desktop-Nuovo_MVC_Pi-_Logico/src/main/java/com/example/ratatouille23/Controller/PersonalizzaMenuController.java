package com.example.ratatouille23.Controller;

import com.example.ratatouille23.Controller.Supervisore.HomepageSupervisoreController;
import com.example.ratatouille23.Homepage;
import com.example.ratatouille23.View.Admin.HomepageAdminView;
import com.example.ratatouille23.View.NuovoPiattoView;
import com.example.ratatouille23.View.PersonalizzaMenuView;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;

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

}
