package com.example.demo.controller;

import com.example.demo.models.Ordine;
import com.example.demo.services.OrdineServiceOLD;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/*
//@RestController
//@RequestMapping("/ordini")

public class OrdiniControllerOLD {
  //  @Autowired
    private OrdineServiceOLD service;

    public OrdiniControllerOLD(OrdineServiceOLD service) {
        this.service = service;
    }


    //Aggiungere filtro per utente
    @GetMapping("/cerca-ordini-utenti/{idUtente}")
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
        double totale = service.totaleOrdine(id).get();
        if (totale > 0) {
            return ResponseEntity.ok(totale);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


    @PostMapping("/aggiungi-ordine")
    public ResponseEntity<Ordine> aggiungiOrdine(@RequestBody Ordine ordine){
        Optional<Ordine> nuovo = service.aggiungiOrdine(ordine);
        if(nuovo.isPresent())
            return ResponseEntity.status(HttpStatus.CREATED).body(nuovo.get());
        return ResponseEntity.badRequest().build();

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


}
*/