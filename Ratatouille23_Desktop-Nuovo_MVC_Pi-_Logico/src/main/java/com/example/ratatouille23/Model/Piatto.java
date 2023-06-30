package com.example.ratatouille23.Model;

import java.io.Serializable;
import java.util.Objects;

public class Piatto implements Serializable {

    private Long idPiatto;
    private String nome;
    private String costo;
    private String allergeni;
    private String descrizione;

    private Categoria categoria;


    public Piatto(Long idPiatto, String nomePiatto, String costoPiatto, String allergeni, String descrizione, Categoria categoria) {
        this.idPiatto = idPiatto;
        this.nome = nomePiatto;
        this.costo = costoPiatto;
        this.allergeni = allergeni;
        this.categoria = categoria;
        this.descrizione = descrizione;
    }


//    public Piatto(Long idPiatto, String nomePiatto, String costoPiatto, String allergeni, String descrizione) {
//        this.idPiatto = idPiatto;
//        this.nome = nomePiatto;
//        this.costo = costoPiatto;
//        this.allergeni = allergeni;
////        this.categoria = categoria;
//        this.descrizione = descrizione;
//    }

    public Piatto() {

    }

//    public void setIdPiatto(Long idPiatto){
//        this.idPiatto = idPiatto;
//    }
//
//    public Long getIdPiatto() {
//        return idPiatto;
//    }

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

    public Long getIdPiatto() {
        return idPiatto;
    }

    public void setIdPiatto(Long idPiatto) {
        this.idPiatto = idPiatto;
    }

    @Override
    public String toString() {
        return nome + " , €" + costo;
    }

        public Categoria getCategoria() {
        return categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Piatto piatto)) return false;
        return Objects.equals(nome, piatto.nome) && Objects.equals(costo, piatto.costo) && Objects.equals(allergeni, piatto.allergeni) && Objects.equals(descrizione, piatto.descrizione);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, costo, allergeni, descrizione);
    }


}
