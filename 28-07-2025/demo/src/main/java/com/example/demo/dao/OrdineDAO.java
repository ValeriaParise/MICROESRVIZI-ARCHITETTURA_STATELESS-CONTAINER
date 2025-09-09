package com.example.demo.dao;


import com.example.demo.model.Oggetti;
import com.example.demo.model.Carrello;
import com.example.demo.model.Ordine;
import com.example.demo.model.StatoOrdine;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class OrdineDAO {
    public List<Ordine> ordini = new ArrayList<>();
    private final OggettiDAO oggettiDAO;


    public OrdineDAO(OggettiDAO oggettiDAO) {

        this.oggettiDAO = oggettiDAO;

        List<Oggetti> l1 = new ArrayList<>();
        l1.add(oggettiDAO.trovaPerId(1));
        l1.add(oggettiDAO.trovaPerId(2));

        List<Oggetti> l2 = new ArrayList<>();
        l2.add(oggettiDAO.trovaPerId(4));
        l2.add(oggettiDAO.trovaPerId(5));

        Carrello c1 = new Carrello(l1);
        Carrello c2 = new Carrello(l2);

        Ordine o1 = new Ordine(1, 100,LocalDateTime.now(), c1,StatoOrdine.CREATO);
        Ordine o2 = new Ordine(2, 103, LocalDateTime.now().plusDays(4),c2, StatoOrdine.CREATO);

    }


    //cerca ordine per id
    public Optional<Ordine> getOrdine(int idOrdine){
        return ordini.stream().
                filter(ordine -> ordine.getId()==idOrdine).
                findFirst();
    }

    //recupera importo totale dell'ordine
    public double totaleOrdine(int idOrdine){
        Ordine trovato =  getOrdine(idOrdine).get();
        return trovato.getCarrello().getTotaleCarrello();
    }

    // cerca ordini per id utente
    public List<Ordine> getOrdiniIdUtente(int idUtente){
        return ordini.stream().
                filter(ordine -> ordine.getUserID()==idUtente)
                .toList();
    }

    //aggiungi ordine
    public Optional<Ordine> aggiungiOrdine(Ordine nuovoOrdine){
        if(!ordini.contains(nuovoOrdine)){
            ordini.add(nuovoOrdine);
        }
        return Optional.ofNullable(nuovoOrdine);
    }

    //modifica ordine esistente
    public Optional<Ordine> modificaOrdine(int idOrdine, Ordine nuovoOrdine){
        Optional<Ordine> daModificare = getOrdine(idOrdine);
        if(daModificare.isPresent()){
            int index = ordini.indexOf(daModificare.get());
            ordini.set(index,nuovoOrdine);
        }
        return getOrdine(idOrdine);
    }

    //elimina ordine da id
    public boolean eliminaOrdine(int idOrdine){
        Optional<Ordine> daElimare = getOrdine(idOrdine);
        if(daElimare.isEmpty()){return false;}
        ordini.remove(daElimare.get());
        return true;
    }





    /*









    // Aggiungi ordine
    public Ordine aggiungiOrdine(Ordine nuovo) {
        if (!ordini.contains(nuovo)) {
            ordini.add(nuovo);
            return nuovo;
        }
        //else System.out.println("Ordine gia presente");
        return null;
    }

    //Modifica ordine
    public Optional<Ordine> modificaOrdine(int id, Ordine nuovo) {
        Optional<Ordine> esistente = cercaPerID(id);
        if (esistente.isPresent()) {
            Ordine originale = esistente.get();
            originale.setData(nuovo.getData());
            originale.setImportoOrdine(nuovo.getImportoOrdine());
            originale.setStato(nuovo.getStato());
            originale.setUserID(nuovo.getUserID());
            originale.getOggettiOrdinati(nuovo.getOggetti());
            return Optional.of(originale);
        }
        return Optional.empty();
    }

    //Elimina ordine
    public boolean eliminaPerID(int id) {
        return ordini.removeIf(ordine -> ordine.getId() == id);
    }

    //Elimina tutti
    public boolean eliminaTutti() {
        if (ordini.isEmpty()) {
            return false;
        } else {
            ordini.clear();
            return true;
        }
    }*/

}

