package com.example.ratatouille23.Controller.Login;

import com.example.ratatouille23.Model.Utente;
import com.example.ratatouille23.View.Login.LoginView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import software.amazon.awssdk.services.cognitoidentityprovider.model.CognitoIdentityProviderException;

import java.io.IOException;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginController {

    private LoginView loginView;
    private Stage stage;
    private Scene scene;


    public LoginController(LoginView view) {this.loginView = view;
    this.stage = new Stage();
    }

    public void onPulsanteLoginClicked() {
        try {
            String username = loginView.getUsernameText();
            String pass = loginView.getPasswordText();

           // if (MailPasswordValidi(mail, pass)) {
                if (Utente.Login(username, pass) == null) {
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
                        case "Addetti_alla_Sala":
                            System.out.println("SONO IN ADDETTI SALA");
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
                /*
            } else {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Mail/password errata");
                alert.setHeaderText("I dati che hai inserito non hanno una forma corretta.");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    //
                }
            }

                 */
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




    // Utilities


    public boolean MailPasswordValidi(String mail, String password) throws IllegalArgumentException{
        return MailValida(mail) && PasswordValida(password);
    }

    public boolean MailValida(String mail) throws IllegalArgumentException{
        if (mail == null){
            throw new IllegalArgumentException();
        } else {
            String regex = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})";
            Pattern path = Pattern.compile(regex);
            Matcher matcher = path.matcher(mail);
            return matcher.matches();
        }
    }

    public boolean PasswordValida(String pass) throws IllegalArgumentException {
        if (pass == null) {
            throw new IllegalArgumentException();
        } else {
            String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\\\d)(?=.*[@#$%^&+=]).{8,}$";
            Pattern path = Pattern.compile(regex);
            Matcher matcher = path.matcher(pass);
            return matcher.matches();
        }
    }
}
