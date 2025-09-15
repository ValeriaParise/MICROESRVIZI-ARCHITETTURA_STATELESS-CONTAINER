/*
package com.example.demo.repository;


import com.example.demo.models.Oggetti;
import com.example.demo.models.Carrello;
import com.example.demo.models.Ordine;
import com.example.demo.models.StatoOrdine;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@Component
public class OrdineDAO {
    public List<Ordine> ordini = new ArrayList<>();
    private final OggettiDAO oggettiDAO;


    public OrdineDAO(OggettiDAO oggettiDAO) {

        this.oggettiDAO = oggettiDAO;

        List<Oggetti> l1 = List.of(
                oggettiDAO.trovaPerId(1),
                oggettiDAO.trovaPerId(2)
        );

        List<Oggetti> l2 = List.of(
                oggettiDAO.trovaPerId(4),
                oggettiDAO.trovaPerId(5)
        );

        Carrello c1 = new Carrello(new ArrayList<>(l1));
        Carrello c2 = new Carrello(new ArrayList<>(l2));

        //Ordine o1 = new Ordine(1, 100,LocalDateTime.now(), c1,StatoOrdine.CREATO);
        //Ordine o2 = new Ordine(2, 103, LocalDateTime.now().plusDays(4),c2, StatoOrdine.CREATO);

       // ordini.add(o1);
        //ordini.add(o2);
    }


    //cerca ordine per id
    public Optional<Ordine> getOrdine(int idOrdine){
        return ordini.stream().
                filter(ordine -> ordine.getId() == idOrdine).
                findFirst();
    }

    //recupera importo totale dell'ordine
    public Optional<Double> totaleOrdine(int idOrdine){
        Optional<Ordine> trovato =  getOrdine(idOrdine);
        if(trovato.isPresent())
            return Optional.of(trovato.get().getCarrello().getTotaleCarrello());
        return Optional.empty();
    }

    // cerca ordini per id utente
    //public List<Ordine> getOrdiniIdUtente(int idUtente){
        //return ordini.stream().
            //    filter(ordine -> ordine.getUserID()==idUtente)
              //  .toList();
    //}

    //aggiungi ordine
    public Optional<Ordine> aggiungiOrdine(Ordine nuovoOrdine){
        if(!ordini.contains(nuovoOrdine)){
            ordini.add(nuovoOrdine);
        }
        return Optional.of(nuovoOrdine);
    }

    //modifica ordine esistente
    public Optional<Ordine> modificaOrdine(int idOrdine, Ordine nuovoOrdine){
        Optional<Ordine> daModificare = getOrdine(idOrdine);
        if(daModificare.isPresent()){
            int index = ordini.indexOf(daModificare.get());
            ordini.set(index,nuovoOrdine);
            return Optional.of(nuovoOrdine);
        }
        return  Optional.empty();
    }

    //elimina ordine da id
    public boolean eliminaOrdine(int idOrdine){
        Optional<Ordine> daElimare = getOrdine(idOrdine);
        if(daElimare.isEmpty()){return false;}
        ordini.remove(daElimare.get());
        return true;
    }

}

*/