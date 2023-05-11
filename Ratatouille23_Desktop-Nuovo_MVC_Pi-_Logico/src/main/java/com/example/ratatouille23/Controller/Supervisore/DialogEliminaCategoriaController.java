package com.example.ratatouille23.Controller.Supervisore;
import com.example.ratatouille23.Model.Categoria;
import com.example.ratatouille23.Model.DAO.DAOImplUnirest.CategoriaDAOImplUnirest;
import com.example.ratatouille23.Model.DAO.DAOInterface.CategoriaDAO;
import com.example.ratatouille23.Model.Piatto;
import com.example.ratatouille23.View.Supervisore.DialogEliminaCategoriaView;
import com.example.ratatouille23.View.Supervisore.DialogEliminaPiattoView;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DialogEliminaCategoriaController {


    private DialogEliminaCategoriaView eliminaCategoriaView;
    private ArrayList<Categoria> categorieDaEliminare;

    private CategoriaDAO categoriaDAO;


    public DialogEliminaCategoriaController(DialogEliminaCategoriaView view){
        this.eliminaCategoriaView = view;
        categorieDaEliminare = new ArrayList<>();
        categoriaDAO = new CategoriaDAOImplUnirest();
    };

    public void onBtnConfermaClicked() {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Conferma cancellazione categorie");
        alert.setContentText("Sei sicuro di voler cancellare le categorie selezionate?\nL'operazione è irreversibile.");

        Optional<ButtonType> result = alert.showAndWait();
        if(result.get() == ButtonType.OK){
            System.out.println("I piatti da eliminare sono:");
            for (Categoria cat : categorieDaEliminare){
                System.out.println(cat);
            }
        } else {
        }

    }

    public ArrayList<Categoria> getCategorieDaEliminare() {
        return categorieDaEliminare;
    }

    public List<Categoria> ottieniCategorie(){
       return categoriaDAO.getCategorie();
    }

}
