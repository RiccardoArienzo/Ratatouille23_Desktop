package com.example.ratatouille23.Model.DTO;

import com.example.ratatouille23.Model.Ordinazione;
import com.example.ratatouille23.Model.Piatto;

import java.util.HashMap;
import java.util.Map;

public class OrdinazioneDTO {

    private String idTavolo;
//    private boolean evasa;
    private Map<Piatto, Ordinazione.InfoOrdine> infoPiatto;

    public OrdinazioneDTO(String idTavolo){
        this.idTavolo = idTavolo;
        this.infoPiatto = new HashMap<>();
//        this.evasa = false;
    }

    public OrdinazioneDTO(){
        infoPiatto = new HashMap<>();
    }

    public String getIdTavolo() {
        return idTavolo;
    }

    public void setIdTavolo(String idTavolo) {
        this.idTavolo = idTavolo;
    }

//    public boolean isEvasa() {
//        return evasa;
//    }
//
//    public void setEvasa(boolean evasa) {
//        this.evasa = evasa;
//    }

    public Map<Piatto, Ordinazione.InfoOrdine> getInfoPiatto() {
        return infoPiatto;
    }

    public void setInfoPiatto(Map<Piatto, Ordinazione.InfoOrdine> infoPiatto) {
        this.infoPiatto = infoPiatto;
    }

    @Override
    public String toString() {
        return "Tavolo: " + idTavolo +
                "\n\n" + infoPiatto;
    }

/*
    public class Ordinazione.InfoOrdine{

        private int quantity;
        private StatoOrdine stato;

        public Ordinazione.InfoOrdine(int quantity, StatoOrdine stato) {
            this.quantity = quantity;
            this.stato = stato;
        }

        public Ordinazione.InfoOrdine(int quantity){
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
    }

    public enum StatoOrdine{
        DA_PREPARARE,
        IN_PREPARAZIONE,
        COMPLETATO;
    }
    
 */
}
