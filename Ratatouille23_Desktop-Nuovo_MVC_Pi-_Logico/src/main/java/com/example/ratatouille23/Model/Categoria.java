package com.example.ratatouille23.Model;

import java.util.ArrayList;
import java.util.List;

public class Categoria {

    private Long idCategoria;
    private String nomeCategoria;
    private List<Piatto> listaPiatti;

    public Categoria(String nome) {
        this.nomeCategoria = nome;
        listaPiatti = new ArrayList<Piatto>();
    }

    public Categoria(String nome, ArrayList<Piatto> listaPiatti){
        this.nomeCategoria = nome;
        this.listaPiatti = listaPiatti;
    }

    public String getNome() {
        return nomeCategoria;
    }

    public void setNome(String nome) {
        this.nomeCategoria = nome;
    }

    public List<Piatto> getPiatti() {
        return listaPiatti;
    }

    public void setPiatti(List<Piatto> piatti) {
        this.listaPiatti = piatti;
    }

    @Override
    public String toString() {
        return nomeCategoria;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }


}
