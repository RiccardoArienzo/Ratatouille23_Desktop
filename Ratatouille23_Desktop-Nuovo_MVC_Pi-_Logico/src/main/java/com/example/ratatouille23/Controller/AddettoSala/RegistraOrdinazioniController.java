package com.example.ratatouille23.Controller.AddettoSala;

import com.example.ratatouille23.Model.Categoria;
import com.example.ratatouille23.Model.DAO.DAOImplUnirest.CategoriaDAOImplUnirest;
import com.example.ratatouille23.Model.DAO.DAOInterface.CategoriaDAO;
import com.example.ratatouille23.View.AddettoSala.RegistraOrdinazioniView;

import java.util.ArrayList;
import java.util.Optional;

public class RegistraOrdinazioniController {

private RegistraOrdinazioniView registraOrdinazioni;
private CategoriaDAO categoriaDAO;

    public RegistraOrdinazioniController(RegistraOrdinazioniView view) {
        this.registraOrdinazioni = view;
        this.categoriaDAO = new CategoriaDAOImplUnirest();
    }


    public ArrayList<Categoria> getCategorie() {
        return (ArrayList<Categoria>) categoriaDAO.getCategorie();
    }

    public Categoria getCategoriaByNome(String nomeCategoria) {
        return categoriaDAO.getCategoriaByName(nomeCategoria);
    }
}
