package com.cadmo.esStudenti.Controller;

import com.cadmo.esStudenti.Models.Studente;
import com.cadmo.esStudenti.Services.StudenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudenteController {
    @Autowired
    private final StudenteService service;

    public StudenteController(StudenteService service) {
        this.service = service;
    }


    @PostMapping("/aggiungiStudente")
    public Studente aggiungiStudente(@RequestBody Studente s){
        return service.aggiungi(s);
    }


    ///cerca?id=3
    @GetMapping("/cerca")
    public Optional<Studente> cercaPerID(@RequestParam int id) {
        return  service.cercaPerID(id);
    }

    @GetMapping("/lista")
    public List<Studente> cercaStudenti(){
        return service.cercaTutti();
    }

    @PutMapping("/modificaStudente")
    public Optional<Studente> modificaStudente(@RequestParam int id, @RequestBody Studente s){
        //s.setId(id);
        return service.modificaStudente(s);
    }

    @PutMapping("/retta")
        public double calcolaRetta(@RequestParam int id){
            return service.calcolaRetta(id);
        }


    @DeleteMapping("/rimuovi")
    public boolean rimuoviStudente(@RequestParam int id){
        return service.rimuoviStudente(id);
    }

    @DeleteMapping("/rimuoviTutti")
    public boolean rimuoviTutti(){
        return service.eliminaTutti();
    }
}
