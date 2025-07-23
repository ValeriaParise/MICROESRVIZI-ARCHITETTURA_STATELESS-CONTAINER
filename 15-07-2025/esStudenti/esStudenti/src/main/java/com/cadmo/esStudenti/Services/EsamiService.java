package com.cadmo.esStudenti.Services;

import com.cadmo.esStudenti.Models.Esame;
import com.cadmo.esStudenti.DAO.EsameDAO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EsamiService {
    private final EsameDAO esameDAO;

    public EsamiService(EsameDAO esameDAO) {
        this.esameDAO = esameDAO;
    }

    public Esame aggiungiEsame(Esame e){
        return esameDAO.aggiungiEsame(e);
    }

    public Optional<Esame> cercaEsamePerID(int id){
        return esameDAO.cercaEsamePerID(id);
    }

    public List<Esame> cercaTuttiEsami(){
        return esameDAO.getListaEsami();
    }

    public Optional<Esame> modificaEsame(int id, Esame e){
        return esameDAO.modificaEsame(id,e);
    }

    public boolean rimuoviEsame(int id){
        return esameDAO.rimuoviEsame(id);
    }

    public boolean eliminaTuttiEsami(){
        return esameDAO.eliminaTuttiEsami();
    }



}
