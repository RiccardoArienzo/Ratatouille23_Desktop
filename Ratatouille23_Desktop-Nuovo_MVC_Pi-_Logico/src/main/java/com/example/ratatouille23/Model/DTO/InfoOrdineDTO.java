package com.example.ratatouille23.Model.DTO;

import com.example.ratatouille23.Model.InfoOrdine;

public class InfoOrdineDTO {



    private Long piatto;
    private Long ordinazione;

    private InfoOrdine.StatoOrdine stato;

    public InfoOrdineDTO(Long piatto, Long ordinazione, InfoOrdine.StatoOrdine stato) {
        this.piatto = piatto;
        this.ordinazione = ordinazione;
        this.stato = stato;
    }

    public InfoOrdineDTO(){}

    public Long getPiatto() {
        return piatto;
    }

    public void setPiatto(Long piatto) {
        this.piatto = piatto;
    }

    public Long getOrdinazione() {
        return ordinazione;
    }

    public void setOrdinazione(Long ordinazione) {
        this.ordinazione = ordinazione;
    }

    public InfoOrdine.StatoOrdine getStato() {
        return stato;
    }

    public void setStato(InfoOrdine.StatoOrdine stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        return "InfoOrdineDTO{" +
                "piatto=" + piatto +
                ", ordinazione=" + ordinazione +
                ", stato=" + stato +
                '}';
    }

}
