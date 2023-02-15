package com.example.ratatouille23.Model;

public class Piatto {
    private String nomePiatto;
    private float costoPiatto;
    private String allergeni;
    private String descrizione;

    public Piatto(String nomePiatto, float costoPiatto, String allergeni, String descrizione) {
        this.nomePiatto = nomePiatto;
        this.costoPiatto = costoPiatto;
        this.allergeni = allergeni;
        this.descrizione = descrizione;
    }

    public String getNomePiatto() {
        return nomePiatto;
    }

    public void setNomePiatto(String nomePiatto) {
        this.nomePiatto = nomePiatto;
    }

    public float getCostoPiatto() {
        return costoPiatto;
    }

    public void setCostoPiatto(float costoPiatto) {
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
}
