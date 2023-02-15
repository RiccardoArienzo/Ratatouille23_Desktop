package com.example.ratatouille23.Model;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Categoria> categorie;

    public Menu() {
        categorie = new ArrayList<>();
    }

    public List<Categoria> getCategorie() {
        return categorie;
    }

    public void setCategorie(List<Categoria> categorie) {
        this.categorie = categorie;
    }
}
