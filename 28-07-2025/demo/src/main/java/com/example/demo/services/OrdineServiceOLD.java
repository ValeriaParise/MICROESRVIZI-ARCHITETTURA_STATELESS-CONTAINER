package com.example.demo.services;

import com.example.demo.repository.OrdineDAO;
import com.example.demo.models.Ordine;

import java.util.Optional;

//@Service
public class OrdineServiceOLD {

    //@Autowired
    private final OrdineDAO dao;


    public OrdineServiceOLD(OrdineDAO dao) {
        this.dao = dao;
    }


   //Mostra Ordini Per utente
    //public List<Ordine> cercaOrdiniPerUtente(int idUtente){
      //  return dao.getOrdiniIdUtente(idUtente);
    //}

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
