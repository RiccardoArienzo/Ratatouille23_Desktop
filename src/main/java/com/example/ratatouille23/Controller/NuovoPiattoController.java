package com.example.ratatouille23.Controller;

import com.example.ratatouille23.View.Admin.HomepageAdminView;
import com.example.ratatouille23.View.NuovoPiattoView;

public class NuovoPiattoController {

    NuovoPiattoView nuovoPiatto;
    HomepageAdminView homepage;

    public NuovoPiattoController(NuovoPiattoView view) {
        this.nuovoPiatto = view;
    }


    // Event Handler

    public void onBtnChiudiSchermataClicked() {
        //
        // if (verificaCampiNonVuoti()){
            homepage.removeRightView();
            /*
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Conferma");
            alert.setHeaderText("Sei sicuro di voler tornare indietro?");
            alert.setContentText("I dati inseriti non verranno salvati.");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                homepage.removeRightView();
            }
        }

             */
    }

    public void onBtnConfermaClicked() {
    }


    // Utility
    public boolean verificaCampiNonVuoti(){
        if (nuovoPiatto.getNomePiattoTextField().getText().isEmpty() &&
            nuovoPiatto.getCostoPiattoTextField().getText().isEmpty() &&
            nuovoPiatto.getAllergeniPiattoTextArea().getText().isEmpty() &&
            nuovoPiatto.getDescrizionePiattoTextArea().getText().isEmpty() &&
            nuovoPiatto.getCategoriaComboBox().getValue() == null){
            return true;
        } else {
            return false;
        }
    }

    public void setHomepageView(HomepageAdminView home) {
        this.homepage = home;
    }


}
