package com.example.demo.dao;


import com.example.demo.model.OggettiOrdinati;
import com.example.demo.model.Ordine;
import com.example.demo.model.StatoOrdine;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class OrdineDAO {
public List<Ordine> ordini = new ArrayList<>();

public OrdineDAO(){

    List<OggettiOrdinati> listaOggetti1 = Arrays.asList(
            new OggettiOrdinati(1, 2, 60),
       new OggettiOrdinati(2,1,89),
            new OggettiOrdinati(5,1,30)
    );

ordini.add(new Ordine(1, 100, LocalDateTime.now().minusDays(1),
        listaOggetti1, StatoOrdine.CREATO, totaleOrdine(listaOggetti1)));
}


//Totale Ordine
    private double totaleOrdine(List<OggettiOrdinati> listaOggetti){
        double importo = 0;
        for(OggettiOrdinati ogg : listaOggetti){
            importo += ogg.getPrezzoOggetto()* ogg.getQuantita();
        }
        return importo;
    }

// Mostra ordini
    public List<Ordine> mostraTutti(){
    return ordini;
    }

    //Cerca Ordine per ID
    public Ordine cercaPerID(int id){
    return ordini.stream().filter(ordine -> ordine.getId()==id).
            findFirst().orElse(null);
    }

    // Aggiungi ordine
    public void aggiungiOrdine(Ordine nuovo){
        ordini.add(nuovo);
    }

    //Modifica ordine
    public void modificaOrdine(int id,Ordine nuovo){
    Ordine originale = cercaPerID(id);
    originale.setData(nuovo.getData());
    originale.setImportoOrdine(nuovo.getImportoOrdine());
    originale.setStato(nuovo.getStato());
    originale.setUserID(nuovo.getUserID());
    originale.setOggetti(nuovo.getOggetti());
    }

    //Elimina ordine
    public void eliminaPerID(int id){
        ordini.remove(id);
    }

    //Elimina tutti
    public void eliminaTutti(){
        ordini.clear();
    }
}
