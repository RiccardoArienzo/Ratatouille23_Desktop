package com.example.ratatouille23.Model;

import java.util.HashMap;
import java.util.Map;

public class Ordinazione {

    String idTavolo;

    Map<Piatto, InfoOrdine> infoPiatto;

    public Ordinazione(){
        infoPiatto = new HashMap<>();
    }

    public Ordinazione(String idTavolo){
        this.idTavolo = idTavolo;
        infoPiatto = new HashMap<>();
    }

    public void incrementaQuantitaPiatto(Piatto piatto) {
        if (infoPiatto.containsKey(piatto)){
            InfoOrdine info = infoPiatto.get(piatto);
            int quantity = info.getQuantity();
            info.setQuantity(quantity+1);
            infoPiatto.put(piatto, info);
        } else {
            InfoOrdine info = new InfoOrdine(1, StatoOrdine.DA_PREPARARE);
            infoPiatto.put(piatto, info);
        }
    }

    public void decrementaQuantitaPiatto(Piatto piatto) {
        if (infoPiatto.containsKey(piatto)) {
            InfoOrdine info = infoPiatto.get(piatto);
            int quantity = info.getQuantity();
            if (quantity>1){
                info.setQuantity(quantity-1);
                infoPiatto.put(piatto, info);
            } else {
                infoPiatto.remove(piatto);
            }

        }
    }

    // metodo fittizio, da utilizzre per popolare GestisciOrdinazioni. Va rimosso.
    public void aggiungiPiatto(Piatto piatto, int quantity){
        this.infoPiatto.put(piatto, new InfoOrdine(quantity));
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

    @Override
    public String toString() {
        return "Tavolo: " + idTavolo +
                "\n\n" + infoPiatto;
    }

    // Inner classes

    public class InfoOrdine{

        private int quantity;
        private StatoOrdine stato;
        private String addetto;

        public InfoOrdine(int quantity, StatoOrdine stato) {
            this.quantity = quantity;
            this.stato = stato;
            this.addetto = "Nessuno";
        }

        public InfoOrdine(int quantity){
            this.quantity = quantity;
            this.stato = StatoOrdine.DA_PREPARARE;
            this.addetto = "Nessuno";
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

        public String getAddetto() {
            return addetto;
        }

        public void setAddetto(String addetto) {
            this.addetto = addetto;
        }

        @Override
        public String toString() {
            return  " x" + quantity + "\n" + "Stato: " + stato + "\n";

        }
    }

    public enum StatoOrdine{
        DA_PREPARARE,
        IN_PREPARAZIONE,
        COMPLETATO;
    }
}
