package com.example.ratatouille23;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;

public class HelloController {

    @FXML
    Circle myCircle = new Circle();
    private double x,y;
    public void up(ActionEvent e){
        myCircle.setCenterY(y-=10);
    }

    public void down(ActionEvent e){
        myCircle.setCenterY(y+=10);
    }

    public void left(ActionEvent e){
        myCircle.setCenterX(x-=10);
    }

    public void right(ActionEvent e){
        myCircle.setCenterX(x+=10);
    }
}