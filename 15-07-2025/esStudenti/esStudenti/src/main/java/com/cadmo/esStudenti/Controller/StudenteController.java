package com.cadmo.esStudenti.Controller;

import com.cadmo.esStudenti.Models.Studente;
import com.cadmo.esStudenti.Services.StudenteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudenteController {
    private final StudenteService service;

    public StudenteController(StudenteService service) {
        this.service = service;
    }


    @PostMapping("/aggiungiStudente")
    public Studente aggiungiStudente(Studente s){
        return service.aggiungi(s);
    }

    @GetMapping("/cerca/{id}")
    public Studente cercaPerID(@PathVariable int id) {
        return  service.cercaPerID(id);
    }

    @GetMapping("/studentiFindAll")
    public List<Studente> cercaStudenti(){
        return service.cercaTutti();
    }

    @PutMapping("/modificaStudente{id}")
    public Studente modificaStudente(@PathVariable int id, @PathVariable Studente s){
        s.setId(id);
        return service.modificaStudente(s);
    }

    @PutMapping("/{id}/retta")
        public double calcolaRetta(@PathVariable int id){
            return service.calcolaRetta(id);
        }


    @DeleteMapping("/rimuovi{id}")
    public void rimuoviStudente(@PathVariable int id){
        service.rimuoviStudente(id);
    }

    @DeleteMapping("/rimuoviTutti")
    public void rimuoviTutti(){
        service.eliminaTutti();
    }
}
