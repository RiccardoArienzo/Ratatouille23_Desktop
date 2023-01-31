package com.example.ratatouille23.homepage;

import com.example.ratatouille23.personalizzaMenu.PersonalizzaMenuController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HomepageController {

    private Stage stage;
    private Scene scene;
    private Parent root;



    public void apriSchermataHome(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/homepage/homepage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void clickPulsantePersonalizzaMenu(ActionEvent e) throws IOException{
        FXMLLoader loaderPersonalizzaMenuContr = new FXMLLoader(getClass().getResource("/personalizzaMenu/personalizza-menu.fxml"));
        root = loaderPersonalizzaMenuContr.load();
        PersonalizzaMenuController persMenuController = loaderPersonalizzaMenuContr.getController();
        persMenuController.apriSchermataMenu(e);
    }

}
