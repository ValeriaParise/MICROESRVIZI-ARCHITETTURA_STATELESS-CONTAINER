package com.cadmo.esStudenti.Models;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class StudenteDAO {

    public List<Studente> studenti = new ArrayList<>();
    int counter = 0;


    // Aggiungi studente
    public Studente aggiungiStudente(Studente studente){
        if(!studenti.contains(studente)){
            studenti.add(studente);
            studente.setId(counter++);
        return studente;}
        else System.out.println("Studente già presente nella lista.");
        return null;
    }

    //Cerca
    public Optional<Studente> cercaPerId(int id){
        return studenti.stream()
                .filter(s -> s.getId()==id).findFirst();
    }

    //Mostra tutti
    public List<Studente> mostraTutti(){
        return studenti;
    }

    //Modifica uno
    public Optional<Studente> modificaStudente(Studente s){
        Optional<Studente> studenteEsistente = studenti.stream().filter(stud-> stud.getId() == s.getId()).findFirst();
        if(studenteEsistente.isPresent()){
            Studente originale = studenteEsistente.get();
                originale.setCognome(s.getCognome());
                originale.setNome(s.getNome());
                originale.setFuoricorso(s.isFuoricorso());
                originale.setCorsoDiStudi(s.getCorsoDiStudi());
                originale.setRettaAnnuale(s.getRettaAnnuale());
                return Optional.of(originale);
        }
        return Optional.empty();
    }

    //Elimina per id
    public boolean rimuoviStudenteId(int id){
        for(Studente s : studenti){
            if (s.getId() == id){ return studenti.remove(s);}
        }
        return false;
    }

    //elimina tutti
    public boolean eliminaStudenti(){
        if (studenti.isEmpty()){return  false;}
        else{studenti.clear();
        return true;}
    }

    //Retta
    public double importoRetta(int id){
        Studente s = studenti.get(id);
        if(s!= null){
            if(s.isFuoricorso()){
                s.setRettaAnnuale(s.getRettaAnnuale()*1.25);
            }
        }
        return  s.getRettaAnnuale();
    }

}
