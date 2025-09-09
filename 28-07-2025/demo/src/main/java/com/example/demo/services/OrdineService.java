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


   //Mostra Ordini Per utente
    public List<Ordine> cercaOrdiniPerUtente(int idUtente){
        return dao.getOrdiniIdUtente(idUtente);
    }

    //Cerca Per ID
    public Optional<Ordine> cercaPerID(int id){
        return dao.getOrdine(id);
    }

    //Aggiungi Ordine
    public Optional<Ordine> aggiungiOrdine(Ordine o){
        return  dao.aggiungiOrdine(o);
    }

    //Modifica
    public Optional<Ordine> modificaOrdine(int id, Ordine nuovo){
        return dao.modificaOrdine(id,nuovo);
    }

    //Elimina Ordine
    public boolean eliminaOrdine(int id){
        return dao.eliminaOrdine(id);
    }

    //Calcola totale ordine
    public Optional<Double> totaleOrdine(int idOrdine){
        return (dao.totaleOrdine(idOrdine));
    }


}
