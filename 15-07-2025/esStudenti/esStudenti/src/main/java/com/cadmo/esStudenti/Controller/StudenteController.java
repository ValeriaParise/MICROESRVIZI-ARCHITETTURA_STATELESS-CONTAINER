package com.cadmo.esStudenti.Controller;

import com.cadmo.esStudenti.Models.CorsoDiStudio;
import com.cadmo.esStudenti.Models.Esame;
import com.cadmo.esStudenti.Models.Studente;
import com.cadmo.esStudenti.Services.StudenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/studenti")

public class StudenteController {
    @Autowired
    private final StudenteService service;

    public StudenteController(StudenteService service) {
        this.service = service;
    }

    //ok
    @PostMapping("/aggiungi-studente")
    public ResponseEntity<Studente> aggiungiStudente(@RequestBody Studente s) {
        Studente nuovo = service.aggiungiStudente(s);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuovo); // 201 Created
    }


    //ok
    @GetMapping()
    public ResponseEntity<List<Studente>> getStudenti(){
        List<Studente> studenti = service.cercaTutti();
        if(studenti.isEmpty()){
            return ResponseEntity.noContent().build(); //204 lista vuota
        }
        return ResponseEntity.ok(studenti);
    }

    /// ok
    @GetMapping("/cerca-studente/{id}")
    public ResponseEntity<Studente> cercaStudentePerID(@PathVariable int id){
        Optional<Studente> trovato = service.cercaStudentePerID(id);
        if(trovato.isPresent()){return ResponseEntity.ok(trovato.get());}
        else{return ResponseEntity.status(HttpStatus.NOT_FOUND).build();}
    }

    //  /studenti/{id}/calcolaRetta  --> @path Variable
    // /studenti/calcolaRetta?id={id} -->@Request param

    //ok
    @GetMapping("/retta/{id}")
    public ResponseEntity<Double> calcolaRetta(@PathVariable int id) {
        Optional<Studente> trovato = service.cercaStudentePerID(id);
        if(trovato.isPresent()){
            double retta = service.calcolaRetta(id);
            return ResponseEntity.ok(retta);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    //ok
    @GetMapping("/lista-esami/{id}")
    public ResponseEntity<List<Esame>> esamiStudente(@PathVariable int id) {
        List<Esame> esami = service.listaEsamiPerStudente(id);

        if (!esami.isEmpty()) {
            return ResponseEntity.ok(esami);
        } else if (esami.isEmpty()) {
            // 204 se studente esiste ma ha 0 esami
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            // 404 se studente non esiste
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/esami-sostenuti/{id}")
    public ResponseEntity<List<Esame>> esamiSostenuti(@PathVariable int id) {
        List<Esame> esami = service.listaEsamiSostenutiStudente(id);

        if (!esami.isEmpty()) {
            return ResponseEntity.ok(esami);
        } else if (esami.isEmpty()) {
            // 204 se studente esiste ma ha 0 esami
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            // 404 se studente non esiste
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @GetMapping("/esami-da-sostenere/{id}")
    public ResponseEntity<List<Esame>> esamiDaSostenre(@PathVariable int id) {
        List<Esame> esami = service.listaEsamiDaSostenereStudente(id);

        if (!esami.isEmpty()) {
            return ResponseEntity.ok(esami);
        } else if (esami.isEmpty()) {
            // 204 se studente esiste ma ha 0 esami
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            // 404 se studente non esiste
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/media-voti/{id}")
    public ResponseEntity<String> mediaVotiPerStudente(@PathVariable int id) {
        Optional<Double> media = Optional.of(service.mediaVotiPerStudente(id));
        if(media.isPresent()){
            return  ResponseEntity.ok("Media voti " + Math.round(media.get()*10)/10);
        }
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nessun esame o studente presente");
    }

    @PutMapping("/modifica-studente/{id}")
    public ResponseEntity<Studente> modificaStudente(@PathVariable int id, @RequestBody Studente s) {
        //s.setId(id);
        Optional<Studente> snuovo = service.modificaStudente(id, s);
        if (snuovo.isPresent()) {
            return ResponseEntity.ok(snuovo.get());
        } else return ResponseEntity.notFound().build();
    }

    @PutMapping("/aggiorna-stato/{idStudente}/{idEsame}")
    public ResponseEntity<String> aggiornaStatoEsame(@PathVariable int idStudente,
                                                     @PathVariable int idEsame,
                                                     @RequestParam boolean newStato) {
        boolean isAggiornato = service.aggiornaStatoEsame(idStudente, idEsame, newStato);
        if (isAggiornato) {
            return ResponseEntity.ok("Esame aggiornato");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Errore, esame o studente non trovato.");
    }

    @DeleteMapping("/rimuovi-studente/{id}")
    public ResponseEntity<String> rimuoviStudente(@PathVariable int id) {
        boolean isEliminato = service.rimuoviStudente(id);
        if (isEliminato) {
            return ResponseEntity.ok("Studente rimosso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Studente non trovato");
        }
    }

    @DeleteMapping("/rimuovi-studenti")
    public ResponseEntity<String> rimuoviTuttiStudenti() {
        boolean isRimossi = service.eliminaTuttiStudenti();
        if (isRimossi) {
            return ResponseEntity.ok("Studenti rimossi");
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Nessuno studente da eliminare");
        }
    }

}