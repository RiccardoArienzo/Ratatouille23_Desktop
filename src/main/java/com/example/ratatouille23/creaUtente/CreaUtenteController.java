package com.example.ratatouille23.creaUtente;

import com.example.ratatouille23.homepage.HomepageView;

public class CreaUtenteController {

    CreaUtenteView creaUtente;

    CreaUtenteController(CreaUtenteView view){
        this.creaUtente = view;
    }

    public boolean verificaCampiVuoti(){
        if (creaUtente.emailTextField.getText().isEmpty() && creaUtente.nomeUtenteTextField.getText().isEmpty()){
            return true;
        } else {
            return false;
        }
    }

}
