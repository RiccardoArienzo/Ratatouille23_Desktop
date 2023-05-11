package com.example.ratatouille23.Controller.Supervisore;
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
            piattiDaEliminare = new ArrayList<>();
            piattoDAO = new PiattoDAOImplUnirest();
        };

        public void onBtnConfermaClicked() {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Conferma cancellazione piatti");
            alert.setContentText("Sei sicuro di voler cancellare i piatti selezionati?\nL'operazione Ã¨ irreversibile.");

            Optional<ButtonType> result = alert.showAndWait();
            if(result.get() == ButtonType.OK){
                System.out.println("I piatti da eliminare sono:");
                for (Piatto piatto : piattiDaEliminare){
                    System.out.println("La cancellazione del piatto: " + piatto.getNomePiatto() + " ha ritornato stato: " + piattoDAO.deletePiatto(piatto));
                }
            } else {
            }

        }

        public ArrayList<Piatto> getPiattiDaEliminare() {
            return piattiDaEliminare;
        }

    public List<Piatto> ottieniPiatti() {
           return piattoDAO.getPiatti();
    }
}
