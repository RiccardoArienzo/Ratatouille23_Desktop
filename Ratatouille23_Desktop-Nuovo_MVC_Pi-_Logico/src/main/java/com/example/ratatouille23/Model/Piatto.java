package com.example.ratatouille23.Model;

public class Piatto {
    private String nomePiatto;
    private String costoPiatto;
    private String allergeni;
    private String descrizione;

    private Categoria categoria;

    public Piatto(String nomePiatto, String costoPiatto, String allergeni, Categoria categoria, String descrizione) {
        this.nomePiatto = nomePiatto;
        this.costoPiatto = costoPiatto;
        this.allergeni = allergeni;
        this.categoria = categoria;
        this.descrizione = descrizione;
    }

    public String getNomePiatto() {
        return nomePiatto;
    }

    public void setNomePiatto(String nomePiatto) {
        this.nomePiatto = nomePiatto;
    }

    public String getCostoPiatto() {
        return costoPiatto;
    }

    public void setCostoPiatto(String costoPiatto) {
        this.costoPiatto = costoPiatto;
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
