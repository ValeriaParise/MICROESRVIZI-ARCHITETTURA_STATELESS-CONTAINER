package com.cadmo.esStudenti.Controller;

import com.cadmo.esStudenti.Models.Esame;
import com.cadmo.esStudenti.Models.Studente;
import com.cadmo.esStudenti.Services.StudenteService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/aggiungiStudente")
    public Studente aggiungiStudente(@RequestBody Studente s){
        return service.aggiungiStudente(s);
    }

    ///cerca?id=3
    @GetMapping("/cercaStudente")
    public Optional<Studente> cercaStudentePerID(@RequestParam int id) {
        return  service.cercaStudentePerID(id);
    }

    @GetMapping("/listaStudenti")
    public List<Studente> listaStudenti(){
        return service.cercaTutti();
    }

    @GetMapping("/retta")
    public double calcolaRetta(@RequestParam int id){
        return service.calcolaRetta(id);
    }

    @GetMapping("/listaEsamiStudente")
    public List<Esame> listaEsamiPerStudente(@RequestParam int id){return  service.listaEsamiPerStudente(id);}

    @GetMapping("/esamiSostenuti")
    public List<Esame> listaEsamiSostenutiStudente(@RequestParam int id){
        return  service.listaEsamiSostenutiStudente(id);
    }

    @GetMapping("/esamiDaSostenere")
    public List<Esame> listaEsamiDaSostenereStudente(int idStudente){return service.listaEsamiDaSostenereStudente(idStudente);}

    @GetMapping ("/mediavoti")
    public double mediaVotiPerStudente(@RequestParam int id){
        return service.mediaVotiPerStudente(id);
    }

    @PutMapping("/modificaStudente")
    public Optional<Studente> modificaStudente(@RequestParam int id, @RequestBody Studente s){
        //s.setId(id);
        return service.modificaStudente(id,s);
    }

    @PutMapping("/aggiornaStatoEsame")
    public boolean aggiornaStatoEsame(@RequestParam int idStudente,
                                  @RequestParam int idEsame ,
                                      @RequestParam boolean newStato) {
        return service.aggiornaStatoEsame(idStudente, idEsame, newStato);}


    @DeleteMapping("/rimuoviStudenteID")
    public boolean rimuoviStudente(@RequestParam int id){
        return service.rimuoviStudente(id);
    }

    @DeleteMapping("/rimuoviStudenti")
    public boolean rimuoviTuttiStudenti(){
        return service.eliminaTuttiStudenti();
    }
}
