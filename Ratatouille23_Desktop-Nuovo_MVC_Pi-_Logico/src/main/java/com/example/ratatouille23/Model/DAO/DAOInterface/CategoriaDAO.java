package com.example.ratatouille23.Model.DAO.DAOInterface;

import com.example.ratatouille23.Model.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaDAO {

    public List<Categoria> getCategorie();

    public Optional<Categoria> getCategoriaByID(Long idCategoria);

    public List<Categoria> getCategoriaByName(String nomeCategoria);

    public void addCategoria(Categoria categoria);

    public void deleteCategoria(Categoria categoria);

}
