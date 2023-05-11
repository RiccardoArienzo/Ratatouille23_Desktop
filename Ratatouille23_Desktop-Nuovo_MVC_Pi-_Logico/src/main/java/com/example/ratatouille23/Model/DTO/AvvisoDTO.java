package com.example.ratatouille23.Model.DTO;


public class AvvisoDTO {

    private String mittente;
    private String oggettoAvviso;
    private String bodyAvviso;
    private String dataInvio;
    private String orarioInvio;

    public AvvisoDTO(String mittente, String oggettoAvviso, String bodyAvviso, String dataInvio, String orarioInvio) {
        this.mittente = mittente;
        this.oggettoAvviso = oggettoAvviso;
        this.bodyAvviso = bodyAvviso;
        this.dataInvio = dataInvio;
        this.orarioInvio = orarioInvio;
    }

    public AvvisoDTO() {



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

    public void setOrarioInvio(String orarioInvio) {
        this.orarioInvio = orarioInvio;
    }

}
