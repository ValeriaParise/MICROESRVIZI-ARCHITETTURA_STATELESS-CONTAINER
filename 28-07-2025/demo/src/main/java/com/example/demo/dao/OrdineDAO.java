package com.example.demo.dao;


import com.example.demo.model.Oggetti;
import com.example.demo.model.OggettiOrdinati;
import com.example.demo.model.Ordine;
import com.example.demo.model.StatoOrdine;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class OrdineDAO {
    public List<Ordine> ordini = new ArrayList<>();
    private final OggettiDAO oggettiDAO;


    public OrdineDAO(OggettiDAO oggettiDAO) {

        this.oggettiDAO = oggettiDAO;


        List<OggettiOrdinati> listaOggetti1 = Arrays.asList(
                creaOggettoOrdinato(1, 2),
                creaOggettoOrdinato(2, 1),
                creaOggettoOrdinato(5, 1)
        );

        List<OggettiOrdinati> listaOggetti2 = Arrays.asList(
                creaOggettoOrdinato(4, 1),
                creaOggettoOrdinato(1, 2));

        ordini.add(new Ordine(1, 100, LocalDateTime.now().minusDays(1),
                listaOggetti1, StatoOrdine.CREATO, totaleOrdine(listaOggetti1)));
        ordini.add(new Ordine(2, 103, LocalDateTime.now().minusDays(1),
                listaOggetti1, StatoOrdine.CREATO, totaleOrdine(listaOggetti2)));
    }

    // devo recuperare prezzo
    private OggettiOrdinati creaOggettoOrdinato(int idOggetto, int quantita) {
        Oggetti oggetto = oggettiDAO.trovaPerId(idOggetto)
                .orElseThrow(() -> new RuntimeException("Oggetto con id " + idOggetto + " non trovato"));
        return new OggettiOrdinati(oggetto, quantita);
    }

    //Totale Ordine
    private double totaleOrdine(List<OggettiOrdinati> listaOggetti) {
        double importo = 0;
        for (OggettiOrdinati ogg : listaOggetti) {
            importo += ogg.getPrezzoTotale();
        }
        return importo;
    }

    //Calcola il totale
    public double calcolaTotaleOrdine(Ordine ordine) {
        return totaleOrdine((ordine.getOggetti()));
    }


    // Mostra ordini
    public List<Ordine> mostraOrdiniPerUtente(int idUser) {
        return ordini.stream().filter(ordine -> ordine.getUserID()==idUser).toList();
    }

    //Cerca Ordine per ID
    public Optional<Ordine> cercaPerID(int id) {
        return ordini.stream().filter(ordine -> ordine.getId() == id).
                findFirst();
    }

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
            originale.setOggetti(nuovo.getOggetti());
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
    }
}

