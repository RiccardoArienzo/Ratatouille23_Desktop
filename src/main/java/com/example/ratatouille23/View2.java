package com.example.ratatouille23;

import javafx.scene.Node;

import java.io.IOException;

public abstract class View2 {

    String nomeNodo;
    public abstract Node caricaNodo() throws IOException;

}
