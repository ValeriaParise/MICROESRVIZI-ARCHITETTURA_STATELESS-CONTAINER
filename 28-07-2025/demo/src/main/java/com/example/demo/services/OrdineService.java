package com.example.demo.services;

import com.example.demo.dao.OrdineDAO;
import com.example.demo.model.Ordine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdineService {
    @Autowired
    private final OrdineDAO dao;


    public OrdineService(OrdineDAO dao) {
        this.dao = dao;
    }


   //Mostra Ordini
    public List<Ordine> cercaTutti(){
        return dao.mostraTutti();
    }

    //Totale Ordine
    public double calcolaTotaleOrdine(Ordine o){
        return dao.calcolaTotaleOrdine(o);
    }

    //Cerca Per ID
    public Optional<Ordine> cercaPerID(int id){
        return dao.cercaPerID(id);
    }

    //Aggiungi Ordine
    public Ordine aggiungiOrdine(Ordine o){
        //calcolo totale dell'ordine
        o.setImportoOrdine(dao.calcolaTotaleOrdine(o));
        return dao.aggiungiOrdine(o);
    }

    //Modifica
    public Optional<Ordine> modificaOrdine(int id, Ordine nuovo){
        //calcolo il totale dell'ordine
        nuovo.setImportoOrdine(dao.calcolaTotaleOrdine(nuovo));
        return  dao.modificaOrdine(id, nuovo);
    }

    //Elimina Ordine
    public boolean eliminaOrdine(int id){
        return dao.eliminaPerID(id);
    }

    //Elimina tutti
    public boolean eliminaTutti(){
        if(dao.ordini.size()!=0){
             dao.eliminaTutti();
        }
        return true;
    }

}
