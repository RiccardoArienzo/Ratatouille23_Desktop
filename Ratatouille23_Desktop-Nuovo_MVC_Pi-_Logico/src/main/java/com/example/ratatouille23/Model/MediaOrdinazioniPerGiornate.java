package com.example.ratatouille23.Model;

public class MediaOrdinazioniPerGiornate {

    private String username;
    private Long mediaOrdinazioniCompletate;

    public MediaOrdinazioniPerGiornate(){};

    public MediaOrdinazioniPerGiornate(String username, Long mediaOrdinazioniCompletate){
        this.username = username;
        this.mediaOrdinazioniCompletate = mediaOrdinazioniCompletate;
    }

    public String getUsername() {
        return username;
    }

    public Long getmediaOrdinazioniCompletate() {
        return mediaOrdinazioniCompletate;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setmediaOrdinazioniCompletate(Long mediaOrdinazioniCompletate) {
        this.mediaOrdinazioniCompletate = mediaOrdinazioniCompletate;
    }

    @Override
    public String toString() {
        return "MediaOrdinazioniPerGiornate{" +
                "username='" + username + '\'' +
                ", mediaOrdinazioniCompletate=" + mediaOrdinazioniCompletate +
                '}';
    }
}
