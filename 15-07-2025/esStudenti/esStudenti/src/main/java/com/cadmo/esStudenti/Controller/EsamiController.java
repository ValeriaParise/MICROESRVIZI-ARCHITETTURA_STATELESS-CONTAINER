package com.cadmo.esStudenti.Controller;

import com.cadmo.esStudenti.Models.Esame;
import com.cadmo.esStudenti.Models.Studente;
import com.cadmo.esStudenti.Services.EsamiService;
import com.cadmo.esStudenti.Services.StudenteService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/aggiungiEsame")
    public Esame aggiungiEsame(@RequestBody Esame e){
        return service.aggiungiEsame(e);
    }

    @GetMapping("/cercaEsame")
    public Optional<Esame> cercaPerID(@RequestParam int id){
        return service.cercaEsamePerID(id);
    }

    @GetMapping("/listaEsami")
    public List<Esame> listaEsame(){
        return service.cercaTuttiEsami();
    }

    @PutMapping("/modificaEsame")
    public Optional<Esame> modificaEsame(@RequestParam int id, @RequestBody Esame e){
        return service.modificaEsame(id,e);
    }

    @DeleteMapping("/rimuoviEsameID")
    public boolean rimuoviEsame(@RequestParam int id){
        return service.rimuoviEsame(id);
    }

    @DeleteMapping("/rimuoviEsami")
    public boolean rimuoviTuttiEsami(){
        return service.eliminaTuttiEsami();
    }
}
