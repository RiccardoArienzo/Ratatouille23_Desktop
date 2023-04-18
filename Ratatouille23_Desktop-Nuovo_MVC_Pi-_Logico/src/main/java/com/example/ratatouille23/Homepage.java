package com.example.ratatouille23;

import com.example.ratatouille23.Controller.Amministratore.CreaUtenteController;
import com.example.ratatouille23.Controller.Amministratore.HomepageAdminController;
import com.example.ratatouille23.View.Admin.CreaUtenteView;
import com.example.ratatouille23.View.GestisciAvvisiView;
import com.example.ratatouille23.View.InserisciAvvisiView;
import com.example.ratatouille23.View.NuovoPiattoView;
import com.example.ratatouille23.View.PersonalizzaMenuView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public abstract class Homepage {

    @FXML
    BorderPane borderPane;

    HomepageController homepageController;


    public void updateCenterView(Node node){
        borderPane.getChildren().remove(this.borderPane.getCenter());
        borderPane.setCenter(node);
    }

    public void updateRightView(Node node){
        this.borderPane.getChildren().remove(this.borderPane.getRight());
        this.borderPane.setRight(node);
    }

    public void removeRightView(){
        this.borderPane.getChildren().remove(this.borderPane.getRight());
        VBox placeholder = new VBox();
        placeholder.setPrefSize(440,700);
        this.borderPane.setRight(placeholder);
    }


    public HomepageController getHomepageController(){
        return this.homepageController;
    }


}
