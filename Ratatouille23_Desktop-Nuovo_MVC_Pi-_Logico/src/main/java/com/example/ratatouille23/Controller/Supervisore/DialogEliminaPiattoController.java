package com.example.ratatouille23.Controller.Supervisore;

import com.example.ratatouille23.Main;
import com.example.ratatouille23.Model.DAO.DAOImplUnirest.PiattoDAOImplUnirest;
import com.example.ratatouille23.Model.DAO.DAOInterface.PiattoDAO;
import com.example.ratatouille23.Model.Piatto;
import com.example.ratatouille23.View.PersonalizzaMenuView;
import com.example.ratatouille23.View.Supervisore.DialogEliminaPiattoView;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.stage.Modality;
import javafx.util.Callback;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DialogEliminaPiattoController {

    private DialogEliminaPiattoView eliminaPiattoView;
    private ArrayList<Piatto> piattiDaEliminare;

    private PiattoDAO piattoDAO;


    public DialogEliminaPiattoController(DialogEliminaPiattoView view){
        this.eliminaPiattoView = view;
        this.piattoDAO = new PiattoDAOImplUnirest();
        piattiDaEliminare = new ArrayList<>();

    };

    public void onBtnConfermaClicked() {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Conferma cancellazione piatti");
        alert.setContentText("Sei sicuro di voler cancellare i piatti selezionati?\nL'operazione è irreversibile.");
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.initOwner(Main.getPrimaryStage());
        Optional<ButtonType> result = alert.showAndWait();
        if(result.get() == ButtonType.OK){
            System.out.println("I piatti da eliminare sono:");
//            CHIAMATA AL DAO TUTTO MAIUSCOLO PER RIEMPIRE "piattiDaEliminare"
            for (Piatto piatto : piattiDaEliminare){
                System.out.println(piatto);

                //TODO aggiungere chiamata al dao per eliminare piatti

                // Qui va richiamato il metodo del dao che dovrà essere del tipo:
                // deletePiatto(Piatto piatto);
                // da richiamare così:
                // piattoDAO.deletePiatto(piatto);

                piattoDAO.deletePiatto(piatto.getIdPiatto());


            }
        } else {
        }

    }

    public ArrayList<Piatto> getPiattiDaEliminare() {
        return piattiDaEliminare;
    }

    public List<Piatto> getPiatti() {
       return piattoDAO.getPiatti();
    }

}
