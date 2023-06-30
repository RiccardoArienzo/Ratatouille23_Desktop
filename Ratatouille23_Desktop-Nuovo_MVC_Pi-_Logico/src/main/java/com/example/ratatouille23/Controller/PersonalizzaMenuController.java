package com.example.ratatouille23.Controller;

import com.example.ratatouille23.Main;
import com.example.ratatouille23.Model.Categoria;
import com.example.ratatouille23.Model.DAO.DAOImplUnirest.CategoriaDAOImplUnirest;
import com.example.ratatouille23.Model.DAO.DAOImplUnirest.PiattoDAOImplUnirest;
import com.example.ratatouille23.Model.DAO.DAOInterface.CategoriaDAO;
import com.example.ratatouille23.Model.DAO.DAOInterface.PiattoDAO;
import com.example.ratatouille23.View.PersonalizzaMenuView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class PersonalizzaMenuController {

    private PersonalizzaMenuView personalizzaMenu;
    private CategoriaDAO categoriaDAO;
    private PiattoDAO piattoDAO;


    public PersonalizzaMenuController(PersonalizzaMenuView view){
        this.personalizzaMenu = view;
        categoriaDAO = new CategoriaDAOImplUnirest();
        piattoDAO = new PiattoDAOImplUnirest();
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


    public List<Categoria> ottieniCategorie() {
       return categoriaDAO.getCategorie();
    }

//    public void aggiornaContatorePiatto(Long idPiatto, Long piattoCounter) {
//        piattoDAO.updateCounter(idPiatto, piattoCounter);
//
//    }

//    public void aggiornaContatoreCategoria(Long idCategoria, Long categoriaCounter) {
//        categoriaDAO.updateCounter(idCategoria, categoriaCounter);
//    }
}
