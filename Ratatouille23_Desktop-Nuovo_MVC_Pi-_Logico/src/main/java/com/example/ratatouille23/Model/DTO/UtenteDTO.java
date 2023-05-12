package com.example.ratatouille23.Model.DTO;

public class UtenteDTO {

    private String email;
    private String username;
    private String gruppo;


    public UtenteDTO(String username, String gruppo) {
        this.username = username;
        this.gruppo = gruppo;
        this.email = email;
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
}
