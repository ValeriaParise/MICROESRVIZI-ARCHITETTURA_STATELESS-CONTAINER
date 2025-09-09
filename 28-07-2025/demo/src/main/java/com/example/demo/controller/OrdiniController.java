package com.example.demo.controller;

import com.example.demo.model.Ordine;
import com.example.demo.services.OrdineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/ordini")

public class OrdiniController {
    @Autowired
    private final OrdineService service;

    public OrdiniController(OrdineService service) {
        this.service = service;
    }


    //Aggiungere filtro per utente
    @GetMapping("/cerca-ordini-utenti/{id}")
    public ResponseEntity<List<Ordine>> listaOrdineUtente(@PathVariable int idUtente){
        List<Ordine> ordiniPerUtente = service.cercaOrdiniPerUtente(idUtente);
        if (ordiniPerUtente.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(ordiniPerUtente);
    }

    @GetMapping("/cerca-ordine/{id}")
    public ResponseEntity<Ordine> cercaOrdinePerID(@PathVariable int id){
        Optional<Ordine> find = service.cercaPerID(id);
        if(find.isPresent()){
            return ResponseEntity.ok(find.get());
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/totale/{id}")
    public ResponseEntity<Double> calcolaTotaleOrdine(@PathVariable int id){
        Optional<Ordine> ordine = service.cercaPerID(id);
        if(ordine.isPresent()){
            double totale = ordine.get().getCarrello().calcolaTotale();
            return ResponseEntity.ok(totale);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


    @PostMapping("/aggiungi-ordine")
    public ResponseEntity<Optional<Ordine>> aggiungiOrdine(@RequestBody Ordine ordine){
        Optional<Ordine> nuovo = service.aggiungiOrdine(ordine);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuovo);
    }

    @PutMapping("/modifica-ordine/{id}")
    public ResponseEntity<Ordine> modificaOrdine (@PathVariable int id, @RequestBody Ordine ordine){
        Optional<Ordine> modificato = service.modificaOrdine(id , ordine);
        if(modificato.isPresent()){return  ResponseEntity.ok(modificato.get());}
        else{return ResponseEntity.status(HttpStatus.NOT_FOUND).build();}
    }

    @DeleteMapping("/rimuovi-ordine/{id}")
    public ResponseEntity<String> rimuoviOrdine (@PathVariable int id){
        boolean isEliminato = service.eliminaOrdine(id);
        if(isEliminato){return ResponseEntity.ok("Ordine Rimosso");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ordine non trovato");
        }
    }



    //

}
