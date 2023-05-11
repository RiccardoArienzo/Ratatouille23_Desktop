package com.example.ratatouille23.Model.DTO;

import java.time.Instant;


public class AvvisoDTO {

    private String mittente;
    private String oggettoAvviso;
    private String bodyAvviso;
    private Instant dataInvio;
    private Instant orarioInvio;

    public AvvisoDTO(String mittente, String oggettoAvviso, String bodyAvviso, Instant dataInvio, Instant orarioInvio) {
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

    public Instant getDataInvio() {
        return dataInvio;
    }

    public void setDataInvio(Instant dataInvio) {
        this.dataInvio = dataInvio;
    }

    public Instant getOrarioInvio() {
        return orarioInvio;
    }

    public void setOrarioInvio(Instant orarioInvio) {
        this.orarioInvio = orarioInvio;
    }

}
