package com.example.ratatouille23.Model;

public class Piatto {
    private String nome;
    private String costo;
    private String allergeni;
    private String descrizione;

    private Categoria categoria;


    public Piatto(String nomePiatto, String costoPiatto, String allergeni, Categoria categoria, String descrizione) {
        this.nome = nomePiatto;
        this.costo = costoPiatto;
        this.allergeni = allergeni;
        this.categoria = categoria;
        this.descrizione = descrizione;
    }

    public String getNomePiatto() {
        return nome;
    }

    public void setNomePiatto(String nomePiatto) {
        this.nome = nomePiatto;
    }

    public String getCostoPiatto() {
        return costo;
    }

    public void setCostoPiatto(String costoPiatto) {
        this.costo = costoPiatto;
    }

    public String getAllergeni() {
        return allergeni;
    }

    public void setAllergeni(String allergeni) {
        this.allergeni = allergeni;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}
