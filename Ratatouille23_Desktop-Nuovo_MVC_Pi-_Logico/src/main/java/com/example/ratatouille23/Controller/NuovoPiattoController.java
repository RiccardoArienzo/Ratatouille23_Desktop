package com.example.ratatouille23.Controller;

import com.example.ratatouille23.Model.Categoria;
import com.example.ratatouille23.Model.DAO.DAOImplUnirest.CategoriaDAOImplUnirest;
import com.example.ratatouille23.Model.DAO.DAOImplUnirest.PiattoDAOImplUnirest;
import com.example.ratatouille23.Model.DAO.DAOInterface.CategoriaDAO;
import com.example.ratatouille23.Model.DAO.DAOInterface.PiattoDAO;
import com.example.ratatouille23.Model.DTO.PiattoDTO;
import com.example.ratatouille23.View.NuovoPiattoView;

import java.io.IOException;
import java.util.ArrayList;

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

        PiattoDTO piattoDTO = new PiattoDTO();
        piattoDTO.setNome(nuovoPiatto.getNomePiattoTextField().getText());
        piattoDTO.setCosto(nuovoPiatto.getCostoPiattoTextField().getText());
        piattoDTO.setAllergeni(nuovoPiatto.getAllergeniPiattoTextArea().getText());
        piattoDTO.setDescrizione(nuovoPiatto.getDescrizionePiattoTextArea().getText());
        Categoria cat = (Categoria) nuovoPiatto.getCategoriaComboBox().getValue();
        piattoDTO.setNomeCategoria(cat.getNome());

        System.out.println(cat.getNome());
        System.out.println(piattoDTO.getNomeCategoria());

        piattoDAO.addPiatto(piattoDTO);


//        Piatto piatto = new Piatto(nuovoPiatto.getNomePiattoTextField().getText(),
//                                    nuovoPiatto.getCostoPiattoTextField().getText(),
//                nuovoPiatto.getAllergeniPiattoTextArea().getText(),
//                (Categoria) nuovoPiatto.getCategoriaComboBox().getValue(),
//                nuovoPiatto.getDescrizionePiattoTextArea().getText());
//        Categoria cat = (Categoria) nuovoPiatto.getCategoriaComboBox().getValue();
//        piatto.setIdCategoria(cat.getIdCategoria());


//        System.out.println(cat.getIdCategoria());
//                piattoDAO.addPiatto(piatto, cat.getIdCategoria());
//        piattoDAO.addPiatto(piatto, nuovoPia);
//        System.out.println(piatto.getCategoria());

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
