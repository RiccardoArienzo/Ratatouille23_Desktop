package com.example.ratatouille23.Model;

import java.util.HashMap;
import java.util.Map;

public class Ordinazione {

    String idTavolo;

    Map<Piatto, InfoOrdine> infoPiatto;

    public Ordinazione(String idTavolo){
        this.idTavolo = idTavolo;
        infoPiatto = new HashMap<>();
    }

    public void aggiungiPiatto(Piatto piatto, int quantita) {
        InfoOrdine info = new InfoOrdine(quantita, StatoOrdine.DA_PREPARARE);
        infoPiatto.put(piatto, info);
    }

    public void setStatoInPreparazione(Piatto piatto){
        InfoOrdine info = this.infoPiatto.get(piatto);
        info.setStato(StatoOrdine.IN_PREPARAZIONE);
        this.infoPiatto.put(piatto, info);
    }

    public void setStatoCompletato(Piatto piatto){
        InfoOrdine info = this.infoPiatto.get(piatto);
        info.setStato(StatoOrdine.COMPLETATO);
        this.infoPiatto.put(piatto, info);
    }

    //

    public String getIdTavolo() {
        return idTavolo;
    }

    public void setIdTavolo(String idTavolo) {
        this.idTavolo = idTavolo;
    }

    public Map<Piatto, InfoOrdine> getPiattiOrdinazione() {
        return infoPiatto;
    }

    // Inner classes

    public class InfoOrdine{

        private int quantity;
        private StatoOrdine stato;

        public InfoOrdine(int quantity, StatoOrdine stato) {
            this.quantity = quantity;
            this.stato = stato;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public StatoOrdine getStato() {
            return stato;
        }

        public void setStato(StatoOrdine stato) {
            this.stato = stato;
        }
    }

    public enum StatoOrdine{
        DA_PREPARARE,
        IN_PREPARAZIONE,
        COMPLETATO;
    }
}
