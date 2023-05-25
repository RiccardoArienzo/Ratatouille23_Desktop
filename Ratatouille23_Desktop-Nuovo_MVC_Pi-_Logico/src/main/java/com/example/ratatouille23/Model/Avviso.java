package com.example.ratatouille23.Model;


import java.util.Date;

public class Avviso {

    //TODO inserire id

    private Long idAvviso;

    private String mittente;
    private String oggettoAvviso;
    private String bodyAvviso;
    private String dataInvio;
    private String orarioInvio;

     private boolean isLetto;

    public Avviso(String mittente,
                  String oggettoAvviso,
                  String bodyAvviso,
                  String dataInvio,
                  String orarioInvio) {

        this.mittente = mittente;
        this.oggettoAvviso = oggettoAvviso;
        this.bodyAvviso = bodyAvviso;
        this.dataInvio = dataInvio;
        this.orarioInvio = orarioInvio;
    }

    public String getMittente() {
        return mittente;
    }

    public void setMittente(String mittente) {
        this.mittente = mittente;
    }

    public String getOggettoAvviso() {
        return oggettoAvviso;
    }

    public void setOggettoAvviso(String oggettoAvviso) {
        this.oggettoAvviso = oggettoAvviso;
    }

    public String getBodyAvviso() {
        return bodyAvviso;
    }

    public void setBodyAvviso(String bodyAvviso) {
        this.bodyAvviso = bodyAvviso;
    }

    public String getDataInvio() {
        return dataInvio;
    }

    public void setDataInvio(String dataInvio) {
        this.dataInvio = dataInvio;
    }

    public String getOrarioInvio() {
        return orarioInvio;
    }

    public Long getIdAvviso() {
        return idAvviso;
    }

    public void setIdAvviso(Long idAvviso) {
        this.idAvviso = idAvviso;
    }

    public void setOrarioInvio(String orarioInvio) {
        this.orarioInvio = orarioInvio;
    }

    @Override
    public String toString() {
        return "Avviso{" +
                "idAvviso='" + idAvviso + '\'' +
                "mittente='" + mittente + '\'' +
                ", oggettoAvviso='" + oggettoAvviso + '\'' +
                ", bodyAvviso='" + bodyAvviso + '\'' +
                ", dataInvio=" + dataInvio +
                ", orarioInvio=" + orarioInvio +
                '}';
    }

    public boolean getStato() {
        return isLetto;
    }
}
