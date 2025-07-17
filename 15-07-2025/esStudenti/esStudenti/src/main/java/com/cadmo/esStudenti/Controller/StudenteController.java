package com.cadmo.esStudenti.Controller;

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

    @GetMapping("/lista")
    public List<Studente> listaStudenti(){
        return service.cercaTutti();
    }

    @PutMapping("/modificaStudente")
    public Optional<Studente> modificaStudente(@RequestParam int id, @RequestBody Studente s){
        //s.setId(id);
        return service.modificaStudente(id,s);
    }

    @PutMapping("/retta")
        public double calcolaRetta(@RequestParam int id){
            return service.calcolaRetta(id);
        }


    @DeleteMapping("/rimuoviStudenteID")
    public boolean rimuoviStudente(@RequestParam int id){
        return service.rimuoviStudente(id);
    }

    @DeleteMapping("/rimuoviStudenti")
    public boolean rimuoviTuttiStudenti(){
        return service.eliminaTuttiStudenti();
    }
}
