package com.example.ratatouille23.Model;

import java.io.Serializable;
import java.util.Objects;

public class Piatto implements Serializable {
    private String nomePiatto;
    private String costoPiatto;
    private String allergeni;
    private String descrizione;

    public Piatto(String nomePiatto, String costoPiatto, String allergeni, String descrizione) {
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

    @Override
    public String toString() {
        return nomePiatto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Piatto piatto)) return false;
        return Objects.equals(nomePiatto, piatto.nomePiatto) && Objects.equals(costoPiatto, piatto.costoPiatto) && Objects.equals(allergeni, piatto.allergeni) && Objects.equals(descrizione, piatto.descrizione);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomePiatto, costoPiatto, allergeni, descrizione);
    }
}
