package com.example.ratatouille23.creaUtente;

import com.example.ratatouille23.homepage.Homepage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SchermataCreaUtente extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CreaUtenteController.class.getResource("/creaUtente/crea-utente.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("A capocchj");
        stage.setScene(scene);
        stage.show();

    }
}
