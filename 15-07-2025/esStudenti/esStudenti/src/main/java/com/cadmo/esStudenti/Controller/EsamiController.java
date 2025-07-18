package com.cadmo.esStudenti.Controller;

import com.cadmo.esStudenti.Models.CorsoDiStudio;
import com.cadmo.esStudenti.Models.Esame;
import com.cadmo.esStudenti.Models.Studente;
import com.cadmo.esStudenti.Services.EsamiService;
import com.cadmo.esStudenti.Services.StudenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/esami")
public class EsamiController {

    @Autowired
    private final EsamiService service;

    public EsamiController(EsamiService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<Esame>> listaEsame(){
        List<Esame> esami = service.cercaTuttiEsami();
        if(esami.isEmpty()){
            return ResponseEntity.noContent().build(); //204 lista vuota
        }
        return ResponseEntity.ok(esami);
    }

    @GetMapping("/cerca-esame/{id}")
    public ResponseEntity<Esame> cercaEsameID(@PathVariable int id){
        Optional<Esame> trovato = service.cercaEsamePerID(id);
        if(trovato.isPresent()){return ResponseEntity.ok(trovato.get());}
        else{return ResponseEntity.status(HttpStatus.NOT_FOUND).build();}
    }

    @PostMapping("/aggiungi-esame")
    public ResponseEntity<Esame> aggiungiEsame(@RequestBody Esame esame) {
        Esame nuovo = service.aggiungiEsame(esame);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuovo);
    }

    @PutMapping("/modifica-esame/{id}")
    public ResponseEntity<Esame> modificaEsame(@PathVariable int id, @RequestBody Esame e){
        Optional<Esame> modificato = service.modificaEsame(id,e);
        if(modificato.isPresent()){return ResponseEntity.ok(modificato.get());}
        else{return ResponseEntity.status(HttpStatus.NOT_FOUND).build();}
    }

    @DeleteMapping("/rimuovi-esame/{id}")
    public ResponseEntity<String> rimuoviEsame(@PathVariable int id) {
        boolean isEliminato = service.rimuoviEsame(id);
        if (isEliminato) {
            return ResponseEntity.ok("Esame rimosso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Esame non trovato");
        }
    }

    @DeleteMapping("/rimuovi-esami")
    public ResponseEntity<String> rimuoviTuttiEsami() {
        boolean rimossi = service.eliminaTuttiEsami();
        if (rimossi) {
            return ResponseEntity.ok("Esami rimossi");
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Nessun Esame da eliminare");
        }
    }
}
