package com.example.ratatouille23.Model.DTO;

public class OrdinazioneDTO {

    private String idTavolo;

    private boolean evasa;

    private String infoPiatto;

    public OrdinazioneDTO(){}

    public OrdinazioneDTO(String idTavolo, boolean evasa, String infoPiatto) {
        this.idTavolo = idTavolo;
        this.evasa = evasa;
        this.infoPiatto = infoPiatto;
    }

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

    public String getInfoPiatto() {
        return infoPiatto;
    }

    public void setInfoPiatto(String infoPiatto) {
        this.infoPiatto = infoPiatto;
    }

    @Override
    public String toString() {
        return "idTavolo='" + idTavolo + '\'' +
                ", evasa=" + evasa +
                ", infoPiatto='" + infoPiatto + '\'' +
                '}';
    }

    //@JsonDeserialize(keyUsing = MyCustomInfoPiattoDeserializer.class)

//private Map<Piatto, InfoOrdine> infoPiatto;
//
//    public OrdinazioneDTO(String idTavolo){
//        this.idTavolo = idTavolo;
//        this.infoPiatto = new HashMap<>();
////        this.evasa = false;
//    }
//
//    public OrdinazioneDTO(){
//        infoPiatto = new HashMap<>();
//    }
//
//    public String getIdTavolo() {
//        return idTavolo;
//    }
//
//    public void setIdTavolo(String idTavolo) {
//        this.idTavolo = idTavolo;
//    }
//
//    public Map<Piatto, InfoOrdine> getInfoPiatto() {
//        return infoPiatto;
//    }
//
//    public void setInfoPiatto(Map<Piatto, InfoOrdine> infoPiatto) {
//        this.infoPiatto = infoPiatto;
//    }
//
//    @Override
//    public String toString() {
//        return "Tavolo: " + idTavolo +
//                "\n\n" + infoPiatto;
//    }

}