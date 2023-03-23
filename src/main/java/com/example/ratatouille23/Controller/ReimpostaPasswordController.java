package com.example.ratatouille23.Controller;

import com.example.ratatouille23.View.ReimpostaPasswordView;
import com.example.ratatouille23.Model.Utente;
import com.example.ratatouille23.View.HomepageView;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.io.IOException;
import java.util.Optional;

public class ReimpostaPasswordController {

    ReimpostaPasswordView reimpostaPassword;
    HomepageView homepage;

    public ReimpostaPasswordController(ReimpostaPasswordView reimpostaPassword, HomepageView homepage) {
        this.reimpostaPassword = reimpostaPassword;
        this.homepage = homepage;
    }

    public boolean verificaPasswordUguali() {
        if (reimpostaPassword.getOldPasswordText().equals(reimpostaPassword.getNewPasswordText())){
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Password errata");
            alert.setHeaderText("Le due password non coincidono. Inserire nuovamente le password.");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                //
            }
            return false;
        }
    }

    public void onPulsanteConfermaNuovaPasswordClicked() {
        try {
            if (verificaPasswordUguali()) {
                Utente.ReimpostaPasswordPrimoAccesso(reimpostaPassword.getNewPasswordText());
                homepage.apriSchermataHome();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
