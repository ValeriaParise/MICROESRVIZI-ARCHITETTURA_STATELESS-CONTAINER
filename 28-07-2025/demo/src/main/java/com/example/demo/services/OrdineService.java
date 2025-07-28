package com.example.demo.services;

import com.example.demo.dao.OrdineDAO;
import com.example.demo.model.Ordine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    //Cerca Per ID
    public Ordine cercaPerID(int id){
        if (dao.ordini.contains(id)){
            return dao.cercaPerID(id);
        }
        return null;
    }

    //Aggiungi Ordine
    public boolean aggiungiOrdine(Ordine o){
        if(!dao.ordini.contains(o)){
             dao.aggiungiOrdine(o);
             return true;
        }
        return false;
    }

    //Modifica
    public Ordine modificaOrdine(int id, Ordine nuovo){
        if(dao.ordini.contains(id)){
            dao.modificaOrdine(id,nuovo);
            return dao.cercaPerID(id);
        }
        return null;
    }

    //Elimina Ordine
    public boolean eliminaOrdine(int id){
        if(dao.ordini.contains(id)){
            dao.eliminaPerID(id);
            return true;
        }
        return false;
    }

    //Elimina tutti
    public boolean eliminaTutti(){
        if(dao.ordini.size()!=0){
             dao.eliminaTutti();
        }
        return true;
    }

}
