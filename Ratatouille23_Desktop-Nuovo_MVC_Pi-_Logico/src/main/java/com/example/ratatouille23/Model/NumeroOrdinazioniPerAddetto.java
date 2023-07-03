package com.example.ratatouille23.Model;

public class NumeroOrdinazioniPerAddetto {
    // Classe per indicare il numeroOrdinazioniale delle ordinazioni che ha effettuato un addetto

    private String username;
    private Long numeroOrdinazioni;

    public NumeroOrdinazioniPerAddetto(){};

    public NumeroOrdinazioniPerAddetto(String username, Long numeroOrdinazioni){
        this.username = username;
        this.numeroOrdinazioni = numeroOrdinazioni;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getnumeroOrdinazioni() {
        return numeroOrdinazioni;
    }

    public void setnumeroOrdinazioni(Long numeroOrdinazioni) {
        this.numeroOrdinazioni = numeroOrdinazioni;
    }

    @Override
    public String toString() {
        return "NumeroOrdinazioniPerAddetto{" +
                "username='" + username + '\'' +
                ", numeroOrdinazioni=" + numeroOrdinazioni +
                '}';
    }
}
