package com.example.ratatouille23.Controller.Login;

import com.example.ratatouille23.View.AddettoSala.HomepageSalaView;
import com.example.ratatouille23.View.Login.LoginView;
import com.example.ratatouille23.View.Login.ReimpostaPasswordView;
import com.example.ratatouille23.Model.Utente;
import com.example.ratatouille23.View.Admin.HomepageAdminView;
import com.example.ratatouille23.View.Supervisore.HomepageSupervisoreView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import software.amazon.awssdk.services.cognitoidentityprovider.model.CognitoIdentityProviderException;

import java.io.IOException;
import java.util.Optional;

public class LoginController {

    private LoginView loginView;
    private Stage stage;
    private Scene scene;


    public LoginController(LoginView view) {this.loginView = view;
    this.stage = new Stage();
    }

    public void onPulsanteLoginClicked() {
        try {
            if (Utente.Login(loginView.getUsernameText(), loginView.getPasswordText()) == null) {
                switch (Utente.getGroup()){
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
            } else {
                FXMLLoader loaderReimposta = new FXMLLoader(getClass().getResource("/reimposta-password.fxml"));
                scene = new Scene(loaderReimposta.load());
                stage.setTitle("Ratatouille23");
                stage.setScene(scene);
                stage.show();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CognitoIdentityProviderException e) {
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
