package com.example.ratatouille23.Model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Avviso {

    private String mittente;
    private String oggettoAvviso;
    private String bodyAvviso;
    private LocalDate dataInvio;
    private LocalTime orarioInvio;


    public Avviso(String mittente,
                  String oggettoAvviso,
                  String bodyAvviso,
                  LocalDate dataInvio,
                  LocalTime orarioInvio) {

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

    public LocalDate getDataInvio() {
        return dataInvio;
    }

    public void setDataInvio(LocalDate dataInvio) {
        this.dataInvio = dataInvio;
    }

    public LocalTime getOrarioInvio() {
        return orarioInvio;
    }

    public void setOrarioInvio(LocalTime orarioInvio) {
        this.orarioInvio = orarioInvio;
    }

    @Override
    public String toString() {
        return "Avviso{" +
                "mittente='" + mittente + '\'' +
                ", oggettoAvviso='" + oggettoAvviso + '\'' +
                ", bodyAvviso='" + bodyAvviso + '\'' +
                ", dataInvio=" + dataInvio +
                ", orarioInvio=" + orarioInvio +
                '}';
    }
}
