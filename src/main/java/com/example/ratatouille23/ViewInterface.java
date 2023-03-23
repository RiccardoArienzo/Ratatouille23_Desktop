package com.example.ratatouille23;

import javafx.scene.Node;

import java.io.IOException;

public interface ViewInterface {

    public Node loadNode() throws IOException;

    public Node getNode();

    public void setNode(Node node);
}
