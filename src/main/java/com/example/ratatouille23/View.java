package com.example.ratatouille23;

import javafx.scene.Node;

import java.io.IOException;

public interface View {

    String nomeNodo = "";
    public Node caricaNodo() throws IOException;

}
