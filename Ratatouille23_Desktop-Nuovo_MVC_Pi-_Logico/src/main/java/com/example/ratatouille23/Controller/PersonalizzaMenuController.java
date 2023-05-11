package com.example.ratatouille23.Controller;

import com.example.ratatouille23.Controller.Supervisore.HomepageSupervisoreController;
import com.example.ratatouille23.Homepage;
import com.example.ratatouille23.Model.Categoria;
import com.example.ratatouille23.Model.DAO.DAOImplUnirest.CategoriaDAOImplUnirest;
import com.example.ratatouille23.Model.DAO.DAOInterface.CategoriaDAO;
import com.example.ratatouille23.View.Admin.HomepageAdminView;
import com.example.ratatouille23.View.NuovoPiattoView;
import com.example.ratatouille23.View.PersonalizzaMenuView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class PersonalizzaMenuController {

    private PersonalizzaMenuView personalizzaMenu;
    private CategoriaDAO categoriaDAO;


    public PersonalizzaMenuController(PersonalizzaMenuView view){
        this.personalizzaMenu = view;
        categoriaDAO = new CategoriaDAOImplUnirest();
    };




    public void onPulsanteAggiungiCategoriaClicked() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Crea nuova categoria");
        dialog.setHeaderText("Inserisci il nome della nuova categoria");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(name -> {
//            AnchorPane newPanelContent = new AnchorPane();
//            newPanelContent.getChildren().add(new Label("Hello World"));
//            TitledPane pane = new TitledPane(name, newPanelContent);
            //personalizzaMenu.listaCategorie.getPanes().add(pane);

            Categoria cat = new Categoria(name);
            categoriaDAO.addCategoria(cat);

        });
    }

    public void onPulsanteEliminaCategoriaClicked() {
        // Carica il file fxml per la nuova finestra
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/elimina-categoria.fxml"));

        // Crea un nuovo stage per la finestra
        Stage newStage = new Stage();
        newStage.initModality(Modality.APPLICATION_MODAL); // Questa riga rende la nuova finestra modale rispetto alla finestra principale
        try {
            newStage.setScene(new Scene(loader.load()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        newStage.show();
    }
    public void onPulsanteEliminaPiattoClicked() {
        // Carica il file fxml per la nuova finestra
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/elimina-piatto.fxml"));

// Crea un nuovo stage per la finestra
        Stage newStage = new Stage();
        newStage.initModality(Modality.APPLICATION_MODAL); // Questa riga rende la nuova finestra modale rispetto alla finestra principale
        try {
            newStage.setScene(new Scene(loader.load()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        newStage.show();
    }


    public List<Categoria> ottieniCategorie() {
       return categoriaDAO.getCategorie();
    }
}
