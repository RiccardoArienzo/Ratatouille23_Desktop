package com.example.ratatouille23.Controller;

import com.example.ratatouille23.View.Admin.HomepageAdminView;
import com.example.ratatouille23.View.PersonalizzaMenuView;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;

import java.util.Optional;

public class PersonalizzaMenuController {

    PersonalizzaMenuView personalizzaMenu;
    HomepageAdminView homepage;

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

    public void onPulsanteAggiungiPiattoClicked() {
        homepage.updateRightView(homepage.getHomepageController().getNuovoPiattoNode());
    }



    public void setHomepageView(HomepageAdminView home) {
        this.homepage = home;
    }
}
