package com.example.ratatouille23.Controller;

import com.example.ratatouille23.Homepage;
import com.example.ratatouille23.Model.Categoria;
import com.example.ratatouille23.Model.DAO.DAOImplUnirest.CategoriaDAOImplUnirest;
import com.example.ratatouille23.Model.DAO.DAOImplUnirest.PiattoDAOImplUnirest;
import com.example.ratatouille23.Model.DAO.DAOInterface.CategoriaDAO;
import com.example.ratatouille23.Model.DAO.DAOInterface.PiattoDAO;
import com.example.ratatouille23.Model.Piatto;
import com.example.ratatouille23.View.Admin.HomepageAdminView;
import com.example.ratatouille23.View.NuovoPiattoView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;


import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class NuovoPiattoController {

    private static final String BASE_URL = "http://localhost:8080/api";

    private NuovoPiattoView nuovoPiatto;

    private CategoriaDAO categoriaDAO;
    private PiattoDAO piattoDAO;

    public NuovoPiattoController(NuovoPiattoView view) {
        this.nuovoPiatto = view;
        categoriaDAO = new CategoriaDAOImplUnirest();
        piattoDAO = new PiattoDAOImplUnirest();
    }


    // Event Handler

    public void onBtnConfermaClicked() {
        Piatto piatto = new Piatto(nuovoPiatto.getNomePiattoTextField().getText(),
                                    nuovoPiatto.getCostoPiattoTextField().getText(),
                nuovoPiatto.getAllergeniPiattoTextArea().getText(),
                (Categoria) nuovoPiatto.getCategoriaComboBox().getValue(),
                nuovoPiatto.getDescrizionePiattoTextArea().getText());

        piattoDAO.addPiatto(piatto);
        System.out.println(piatto.getCategoria());

    }

    public void riempiComboBoxCategoria() throws IOException {
      ArrayList<Categoria> cat  = (ArrayList<Categoria>) categoriaDAO.getCategorie();
        for(Categoria categoria : cat){
            nuovoPiatto.getCategoriaComboBox().getItems().add(categoria);

        }

    }




    // Utility
    public boolean verificaCampiNonVuoti(){
        if (nuovoPiatto.getNomePiattoTextField().getText().isEmpty() &&
            nuovoPiatto.getCostoPiattoTextField().getText().isEmpty() &&
            nuovoPiatto.getAllergeniPiattoTextArea().getText().isEmpty() &&
            nuovoPiatto.getDescrizionePiattoTextArea().getText().isEmpty() &&
            nuovoPiatto.getCategoriaComboBox().getValue() == null){
            return true;
        } else {
            return false;
        }
    }

}
