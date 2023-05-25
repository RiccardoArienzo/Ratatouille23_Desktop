package com.example.ratatouille23.Controller;

import com.example.ratatouille23.Model.Avviso;
import com.example.ratatouille23.Model.DAO.DAOImplUnirest.AvvisoDAOImplUnirest;
import com.example.ratatouille23.Model.DAO.DAOInterface.AvvisoDAO;
import com.example.ratatouille23.View.AvvisiNascostiView;

import java.util.ArrayList;
import java.util.List;

public class AvvisiNascostiController {

    private AvvisiNascostiView avvisiNascosti;
    private AvvisoDAO avvisoDAO;

    public AvvisiNascostiController(AvvisiNascostiView avvisiNascosti) {
        this.avvisiNascosti = avvisiNascosti;
        avvisoDAO = new AvvisoDAOImplUnirest();
    }

    public List<Avviso> getAvvisiNascosti() {
        return avvisoDAO.getAvvisiNascosti();
    }
}
