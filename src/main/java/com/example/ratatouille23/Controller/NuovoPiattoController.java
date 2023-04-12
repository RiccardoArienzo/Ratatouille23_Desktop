package com.example.ratatouille23.Controller;

import com.example.ratatouille23.Homepage;
import com.example.ratatouille23.View.Admin.HomepageAdminView;
import com.example.ratatouille23.View.NuovoPiattoView;

public class NuovoPiattoController {

    private NuovoPiattoView nuovoPiatto;

    public NuovoPiattoController(NuovoPiattoView view) {
        this.nuovoPiatto = view;
    }


    // Event Handler

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

}
