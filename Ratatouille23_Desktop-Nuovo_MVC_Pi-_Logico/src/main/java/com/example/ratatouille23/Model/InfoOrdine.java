package com.example.ratatouille23.Model;

public class InfoOrdine {

        private Piatto piatto;

        private Ordinazione ordinazione;

        private StatoOrdine stato;

        private int quantity;

        private String username;

        public InfoOrdine(int quantity, StatoOrdine stato) {
            this.quantity = quantity;
            this.stato = stato;
        }

        public InfoOrdine(int quantity){
            this.quantity = quantity;
            this.stato = StatoOrdine.DA_PREPARARE;
        }

        public InfoOrdine() {
        }

        public Piatto getPiatto() {
            return piatto;
        }

        public void setPiatto(Piatto piatto) {
            this.piatto = piatto;
        }

        public Ordinazione getOrdinazione() {
            return ordinazione;
        }

        public void setOrdinazione(Ordinazione ordinazione) {
            this.ordinazione = ordinazione;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "[quantity:'" + quantity + '\'' +
                ", stato:'" + stato + '\'' + "]";

    }

        public enum StatoOrdine{
            DA_PREPARARE,
            IN_PREPARAZIONE,
            COMPLETATO;
        }

    }

