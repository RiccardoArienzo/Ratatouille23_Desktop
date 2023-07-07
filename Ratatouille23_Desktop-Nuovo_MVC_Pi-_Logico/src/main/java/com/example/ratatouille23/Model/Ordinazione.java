package com.example.ratatouille23.Model;

import com.example.ratatouille23.Model.DTO.OrdinazioneDTO;

import java.util.HashMap;
import java.util.Map;

public class Ordinazione {

    private Long idOrdinazione;

    private String idTavolo;

    private boolean evasa;

    private String dataInvio;

    private String orarioInvio;

    private Map<Piatto, InfoOrdine> infoPiatto;

    public Ordinazione(String idTavolo, String dataInvio, String orarioInvio){
        this.idTavolo = idTavolo;
        this.infoPiatto = new HashMap<>();
        this.evasa = false;
        this.dataInvio = dataInvio;
        this.orarioInvio = orarioInvio;
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
            InfoOrdine info = new InfoOrdine(1, InfoOrdine.StatoOrdine.DA_PREPARARE);
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
        InfoOrdine info = new InfoOrdine(quantita, InfoOrdine.StatoOrdine.DA_PREPARARE);
        infoPiatto.put(piatto, info);
    }

    public void setStatoInPreparazione(Piatto piatto, String username){
        InfoOrdine info = this.infoPiatto.get(piatto);
        info.setStato(InfoOrdine.StatoOrdine.IN_PREPARAZIONE);
        info.setUsername(username);
        this.infoPiatto.put(piatto, info);
    }

    public void setStatoCompletato(Piatto piatto, String username){
        InfoOrdine info = this.infoPiatto.get(piatto);
        info.setStato(InfoOrdine.StatoOrdine.COMPLETATO);
        info.setUsername(username);
        this.infoPiatto.put(piatto, info);
    }

    //

    public String getIdTavolo() {
        return idTavolo;
    }

    public void setIdTavolo(String idTavolo) {
        this.idTavolo = idTavolo;
    }

    public boolean isEvasa() {
        return evasa;
    }

    public void setEvasa(boolean evasa) {
        this.evasa = evasa;
    }

    public Long getIdOrdinazione() {
        return idOrdinazione;
    }

    public String getDataInvio() {
        return dataInvio;
    }

    public void setDataInvio(String dataInvio) {
        this.dataInvio = dataInvio;
    }

    public String getOrarioInvio() {
        return orarioInvio.substring(0, 5);
    }

    public void setOrarioInvio(String orarioInvio) {
        this.orarioInvio = orarioInvio;
    }

    public void setIdOrdinazione(Long idOrdinazione) {
        this.idOrdinazione = idOrdinazione;
    }

    public Map<Piatto, InfoOrdine> getInfoPiatto() {
        return infoPiatto;
    }

    public void setInfoPiatto(Map<Piatto, InfoOrdine> infoPiatto) {
        this.infoPiatto = infoPiatto;
    }

    @Override
    public String toString() {
        return "idTavolo: " + idTavolo +
                ", infoPiatto: " + infoPiatto +
                ", dataInvio: " + dataInvio +
                ", orarioInvio: " + orarioInvio;
    }

}
