package com.example.ratatouille23.Model;

import com.example.ratatouille23.Model.DTO.UtenteDTO;

public class UtenteAvviso {

    private UtenteDTO utente;
    private Avviso avviso;
    private boolean letto;
    private boolean nascosto;

    public UtenteAvviso(UtenteDTO utente, Avviso avviso, boolean letto, boolean nascosto) {
        this.utente = utente;
        this.avviso = avviso;
        this.letto = letto;
        this.nascosto = nascosto;
    }

    public UtenteAvviso(){}

    public UtenteDTO getUtente() {
        return utente;
    }

    public void setUtente(UtenteDTO utente) {
        this.utente = utente;
    }

    public Avviso getAvviso() {
        return avviso;
    }

    public void setAvviso(Avviso avviso) {
        this.avviso = avviso;
    }

    public boolean isLetto() {
        return letto;
    }

    public void setLetto(boolean letto) {
        this.letto = letto;
    }

    public boolean isNascosto() {
        return nascosto;
    }

    public void setNascosto(boolean nascosto) {
        this.nascosto = nascosto;
    }


    @Override
    public String toString() {
        return "UtenteAvviso{" +
                "utente=" + utente +
                ", avviso=" + avviso +
                ", letto=" + letto +
                ", nascosto=" + nascosto +
                '}';
    }
}
