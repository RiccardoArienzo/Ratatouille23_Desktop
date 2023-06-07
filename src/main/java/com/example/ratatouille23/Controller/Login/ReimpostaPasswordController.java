package com.example.ratatouille23.Controller.Login;

import com.example.ratatouille23.View.Login.ReimpostaPasswordView;
import com.example.ratatouille23.Model.Utente;
import com.example.ratatouille23.View.Admin.HomepageAdminView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import software.amazon.awssdk.services.cognitoidentityprovider.model.CognitoIdentityProviderException;

import java.io.IOException;
import java.util.Optional;

public class ReimpostaPasswordController {

    private ReimpostaPasswordView reimpostaPassword;
    private Stage stage;

    private Scene scene;

    public ReimpostaPasswordController(ReimpostaPasswordView reimpostaPassword) {
        this.reimpostaPassword = reimpostaPassword;
        this.stage = new Stage();
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

    public void onBtnConfermaNuovaPasswordClicked() {
        try {
            if (verificaPasswordUguali()) {
                    Utente.ReimpostaPasswordPrimoAccesso(reimpostaPassword.getNewPasswordText());

                    switch (Utente.getGroup()) {
                        case "Amministratori":
                            FXMLLoader loaderAdmin = new FXMLLoader(getClass().getResource("/homepage-admin.fxml"));
                            scene = new Scene(loaderAdmin.load());
                            stage.setTitle("Ratatouille23");
                            stage.close();
                            stage.setScene(scene);
                            stage.show();
                            break;
                        case "Supervisori":
                            FXMLLoader loaderSuperv = new FXMLLoader(getClass().getResource("/homepage-supervisore.fxml"));
                            scene = new Scene(loaderSuperv.load());
                            stage.setTitle("Ratatouille23");
                            stage.close();
                            stage.setScene(scene);
                            stage.show();
                            break;
                        case "Addetti_Alla_Cucina":
                            FXMLLoader loaderCucina = new FXMLLoader(getClass().getResource("/homepage-cucina.fxml"));
                            scene = new Scene(loaderCucina.load());
                            stage.setTitle("Ratatouille23");
                            stage.close();
                            stage.setScene(scene);
                            stage.show();
                            break;
                        case "Addetti_Alla_Sala":
                            FXMLLoader loaderSala = new FXMLLoader(getClass().getResource("/homepage-sala.fxml"));
                            scene = new Scene(loaderSala.load());
                            stage.setTitle("Ratatouille23");
                            stage.close();
                            stage.setScene(scene);
                            stage.show();
                            break;
                    }
                }
            } catch(IOException e) {
                throw new RuntimeException(e);
            } catch (
                CognitoIdentityProviderException e) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Conferma");
                 alert.setHeaderText(e.awsErrorDetails().errorMessage());
                 Optional<ButtonType> result = alert.showAndWait();
                 if (result.get() == ButtonType.OK) {
                //
                 }
              }
        }

}
