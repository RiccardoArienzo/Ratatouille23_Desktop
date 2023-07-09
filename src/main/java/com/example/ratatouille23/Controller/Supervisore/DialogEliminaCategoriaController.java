package com.example.ratatouille23.Controller.Supervisore;

import com.example.ratatouille23.Main;
import com.example.ratatouille23.Model.Categoria;
import com.example.ratatouille23.Model.Piatto;
import com.example.ratatouille23.View.Supervisore.DialogEliminaCategoriaView;
import com.example.ratatouille23.View.Supervisore.DialogEliminaPiattoView;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;

import java.util.ArrayList;
import java.util.Optional;

public class DialogEliminaCategoriaController {


    private DialogEliminaCategoriaView eliminaCategoriaView;
    private ArrayList<Categoria> categorieDaEliminare;


    public DialogEliminaCategoriaController(DialogEliminaCategoriaView view){
        this.eliminaCategoriaView = view;
        categorieDaEliminare = new ArrayList<>();
    };

    public void onBtnConfermaClicked() {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.initOwner(Main.getPrimaryStage());
        alert.setTitle("Conferma cancellazione categorie");
        alert.setContentText("Sei sicuro di voler cancellare le categorie selezionate?\nL'operazione è irreversibile.");

        Optional<ButtonType> result = alert.showAndWait();
        if(result.get() == ButtonType.OK){
            System.out.println("Le categorie da eliminare sono:");
            for (Categoria cat : categorieDaEliminare){
                System.out.println(cat);
                //TODO aggiungere chiamata al dao per eliminare categoria

                // Qui va richiamato il metodo del dao che dovrà essere del tipo:
                // deleteCategoria(Categoria cat)
                // da richiamare così:
                // categoriaDAO.deleteCategoria(cat);

            }
        } else {
        }

    }

    public ArrayList<Categoria> getCategorieDaEliminare() {
        return categorieDaEliminare;
    }
}
