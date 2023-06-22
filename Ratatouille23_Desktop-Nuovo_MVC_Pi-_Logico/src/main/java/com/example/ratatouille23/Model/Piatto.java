package com.example.ratatouille23.Model;

public class Piatto {

    private Long idPiatto;
    private String nome;
    private String costo;
    private String allergeni;
    private String descrizione;

    private Categoria categoria;


    public Piatto(Long idPiatto, String nomePiatto, String costoPiatto, String allergeni, String descrizione) {
        this.idPiatto = idPiatto;
        this.nome = nomePiatto;
        this.costo = costoPiatto;
        this.allergeni = allergeni;
//        this.categoria = categoria;
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
        return "[nome='" + nome + '\'' +
                ", costo='" + costo + '\'' +
                ", allergeni='" + allergeni + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", categoria=" + categoria + "]";
    }

    //    public Categoria getCategoria() {
//        return categoria;
//    }
}
