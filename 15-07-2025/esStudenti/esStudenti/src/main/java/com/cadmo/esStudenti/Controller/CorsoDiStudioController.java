package com.cadmo.esStudenti.Controller;

import com.cadmo.esStudenti.Models.CorsoDiStudio;
import com.cadmo.esStudenti.Models.Studente;
import com.cadmo.esStudenti.Services.CorsoDiStudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/corsi")
public class CorsoDiStudioController {
    @Autowired
    private final CorsoDiStudioService service ;

    public CorsoDiStudioController(CorsoDiStudioService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<CorsoDiStudio>> getCorsiDiStudio(){
        List<CorsoDiStudio> corsi = service.getCorsiDiStudio();
        if(corsi.isEmpty()){
            return ResponseEntity.noContent().build(); //204 lista vuota
        }
        return ResponseEntity.ok(corsi);
    }

    @GetMapping("/cerca-corso/{id}")
    public ResponseEntity<CorsoDiStudio> cercaCorsoPerID(@PathVariable int id){
        Optional<CorsoDiStudio> corsoTrovato = service.cercaCorsoPerID(id);
        if(corsoTrovato.isPresent()){return ResponseEntity.ok(corsoTrovato.get());}
        else{return ResponseEntity.status(HttpStatus.NOT_FOUND).build();}
    }

    @PostMapping("/aggiungi-corso")
    public ResponseEntity<CorsoDiStudio> aggiungiCorso(@RequestBody CorsoDiStudio corso) {
        CorsoDiStudio nuovo = service.aggiungiCorsoDiStudio(corso);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuovo);
    }

    // NON FUNZIONA
    @PutMapping("/modifica-corso/{id}")
    public ResponseEntity<CorsoDiStudio> modificaCorso(@PathVariable int id,
                                                       @RequestBody CorsoDiStudio nuovoCorso) {
        Optional<CorsoDiStudio> corsoModificato = service.modificaCorsoDiStudi(id, nuovoCorso);
        if (corsoModificato.isPresent()) {
            return ResponseEntity.ok(corsoModificato.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/rimuovi-corso/{id}")
    public ResponseEntity<String> rimuoviCorso(@PathVariable int id) {
        boolean isEliminato = service.rimuoviCorsoDiStudi(id);
        if (isEliminato) {
            return ResponseEntity.ok("Corso rimosso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Corso non trovato");
        }
    }

    @DeleteMapping("/rimuovi-corsi")
    public ResponseEntity<String> rimuoviTuttiCorsi() {
        boolean rimossi = service.rimuoviTuttiCorsi();
        if (rimossi) {
            return ResponseEntity.ok("Corsi di studio rimossi");
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Nessun corso da rimuovere");
        }
    }

}
