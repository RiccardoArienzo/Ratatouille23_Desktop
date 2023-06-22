package com.example.ratatouille23.Model.DTO;

public class PiattoDTO {

    private Long idPiatto;
    private String nome;
    private String costo;
    private String descrizione;
    private String allergeni;
    private String nomeCategoria;


    public PiattoDTO(Long idPiatto, String nome, String costo, String descrizione, String allergeni, String nomeCategoria) {
        this.idPiatto = idPiatto;
        this.nome = nome;
        this.costo = costo;
        this.descrizione = descrizione;
        this.allergeni = allergeni;
        this.nomeCategoria = nomeCategoria;
    }

//    public PiattoDTO(Long idPiatto, String nome, String costo, String descrizione, String allergeni, String nomeCategoria) {
//        this.idPiatto = idPiatto;
//        this.nome = nome;
//        this.costo = costo;
//        this.descrizione = descrizione;
//        this.allergeni = allergeni;
//        this.nomeCategoria = nomeCategoria;
//    }

    public PiattoDTO() {

    }

//    public Long getIdPiatto(){
//        return idPiatto;
//    }
//
//    public void setIdPiatto(){
//        this.idPiatto = idPiatto;
//    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getAllergeni() {
        return allergeni;
    }

    public void setAllergeni(String allergeni) {
        this.allergeni = allergeni;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public Long getIdPiatto() {
        return idPiatto;
    }

    public void setIdPiatto(Long idPiatto) {
        this.idPiatto = idPiatto;
    }
}
