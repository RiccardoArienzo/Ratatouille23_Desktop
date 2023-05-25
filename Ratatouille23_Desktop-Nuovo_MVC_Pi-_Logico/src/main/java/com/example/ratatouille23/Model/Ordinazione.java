package com.example.ratatouille23.Model;

import com.example.ratatouille23.Model.DTO.OrdinazioneDTO;

import java.util.HashMap;
import java.util.Map;

public class Ordinazione {

    private String idTavolo;

    private boolean evasa;

    private Map<Piatto, InfoOrdine> infoPiatto;

    public Ordinazione(String idTavolo){
        this.idTavolo = idTavolo;
        this.infoPiatto = new HashMap<>();
        this.evasa = false;
    }

    public Ordinazione(){
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

    public boolean getStato() {
        return evasa;
    }

    public boolean isEvasa() {
        return evasa;
    }

    public void setEvasa(boolean evasa) {
        this.evasa = evasa;
    }

    public Map<Piatto, InfoOrdine> getInfoPiatto() {
        return infoPiatto;
    }

    public void setInfoPiatto(Map<Piatto, InfoOrdine> infoPiatto) {
        this.infoPiatto = infoPiatto;
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

        public InfoOrdine(int quantity, StatoOrdine stato) {
            this.quantity = quantity;
            this.stato = stato;
        }

        public InfoOrdine(int quantity){
            this.quantity = quantity;
            this.stato = StatoOrdine.DA_PREPARARE;
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

        @Override
        public String toString() {
            return  " x" + quantity + "\n";

        }

    }

    public enum StatoOrdine{
        DA_PREPARARE,
        IN_PREPARAZIONE,
        COMPLETATO;
    }
}
