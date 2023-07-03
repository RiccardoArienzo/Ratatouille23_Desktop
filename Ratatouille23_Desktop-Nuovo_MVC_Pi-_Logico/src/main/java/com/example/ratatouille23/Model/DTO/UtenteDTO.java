package com.example.ratatouille23.Model.DTO;

import com.example.ratatouille23.Model.InfoOrdine;

import java.util.ArrayList;
import java.util.List;

public class UtenteDTO {

    private String email;
    private String username;
    private String gruppo;

    private List<InfoOrdine> infoOrdineList;


    public UtenteDTO(String username, String gruppo, String email) {
        this.username = username;
        this.gruppo = gruppo;
        this.email = email;
        infoOrdineList = new ArrayList<>();
    }

    public UtenteDTO(String username, String gruppo, String email, List<InfoOrdine> infoOrdineList) {
        this.username = username;
        this.gruppo = gruppo;
        this.email = email;
        this.infoOrdineList = infoOrdineList;
    }

    public UtenteDTO() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGruppo() {
        return gruppo;
    }

    public void setGruppo(String gruppo) {
        this.gruppo = gruppo;
    }

    public List<InfoOrdine> getInfoOrdineList() {
        return infoOrdineList;
    }

    public void setInfoOrdineList(List<InfoOrdine> infoOrdineList) {
        this.infoOrdineList = infoOrdineList;
    }

    @Override
    public String toString() {
        return "email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", gruppo='" + gruppo + '\'' +
                '}';
    }
}
