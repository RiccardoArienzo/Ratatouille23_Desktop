package com.example.ratatouille23.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Categoria implements Serializable {

    private Long idCategoria;
    private String nomeCategoria;
    private List<Piatto> listaPiatti;

    public Categoria(String nome) {
        this.nomeCategoria = nome;
        listaPiatti = new ArrayList<Piatto>();
    }

    public Categoria(String nome, List<Piatto> listaPiatti){
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria category = (Categoria) o;
        return Objects.equals(nomeCategoria, category.nomeCategoria) && Objects.equals(listaPiatti, category.listaPiatti);
    }
    @Override
    public int hashCode() {
        return Objects.hash(nomeCategoria, listaPiatti);
    }

}
