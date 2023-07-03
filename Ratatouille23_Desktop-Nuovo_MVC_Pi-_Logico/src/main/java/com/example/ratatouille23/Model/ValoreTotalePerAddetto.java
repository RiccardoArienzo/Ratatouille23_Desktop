package com.example.ratatouille23.Model;

import com.example.ratatouille23.Model.DAO.DAOInterface.ValoreTotalePerAddettoDAO;
import com.example.ratatouille23.Model.DTO.UtenteDTO;

import java.util.HashMap;
import java.util.Map;

public class ValoreTotalePerAddetto {

    private String username;
    private Long sum;

    public ValoreTotalePerAddetto(){}

    public ValoreTotalePerAddetto(String username, Long sum){
        this.username = username;
        this.sum = sum;
    }

    public String getUsername() {
        return username;
    }

//    public void setUsername(String username) {
//        this.username = username;
//    }

    public Long getSum() {
        return sum;
    }

//    public void setSum(Long sum) {
//        this.sum = sum;
//    }

    @Override
    public String toString() {
        return "ValoreTotalePerAddetto{" +
                "username='" + username + '\'' +
                ", sum=" + sum +
                '}';
    }
}
