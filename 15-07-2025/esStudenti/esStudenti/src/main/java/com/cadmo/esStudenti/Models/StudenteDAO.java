package com.cadmo.esStudenti.Models;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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
    public Studente cercaPerId(int id){
        return (Studente) studenti.stream().filter((s -> s.getId()==id));
    }

    //Mostra tutti
    public List<Studente> mostraStudenti(){
        return studenti;
    }

    //Modifica uno
    public Studente modificaStudente(Studente s){
        for (Studente originale : studenti){
            if (originale.getId() == s.getId())
            {
                originale.setCognome(s.getCognome());
                originale.setNome(s.getNome());
                originale.setFuoricorso(s.isFuoricorso());
                originale.setCorsoDiStudi(s.getCorsoDiStudi());
                originale.setRettaAnnuale(s.getRettaAnnuale());
            }
            System.out.println("Update avvenuto con successo");
            return originale;
        }
        return null;
    }

    //Elimina per id
    public void rimuoviStudenteId(int id){
        Studente daRimuovere = cercaPerId(id);
       if (studenti.contains(daRimuovere)){
           studenti.remove(id);
           System.out.println("Studente rimosso con successo");
        }
        System.out.println("Studente non trovato");
    }

    //elimina tutti
    public void eliminaStudenti(){
        studenti.clear();
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
