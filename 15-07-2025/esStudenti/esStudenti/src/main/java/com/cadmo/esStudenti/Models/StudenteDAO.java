package com.cadmo.esStudenti.Models;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class StudenteDAO {

    public List<Studente> studenti = new ArrayList<>();
    int counter = 11;

    public StudenteDAO(){
        studenti.add(new Studente(1, "Mario", "Rossi", Corsi.INFORMATICA));
        studenti.add(new Studente(2, "Lucia", "Bianchi", Corsi.ECONOMIA));
        studenti.add(new Studente(3, "Giovanni", "Verdi", Corsi.INGEGNERIA_INFORMATICA));
        studenti.add(new Studente(4, "Chiara", "Neri", Corsi.CHIMICA));
        studenti.add(new Studente(5, "Marco", "Russo", Corsi.MEDICINA));
        studenti.add(new Studente(6, "Sara", "Costa", Corsi.INFORMATICA));
        studenti.add(new Studente(7, "Paolo", "Ferrari", Corsi.INGEGNERIA_MECCANICA));
        studenti.add(new Studente(8, "Elena", "Gallo", Corsi.FISICA));
        studenti.add(new Studente(9, "Luca", "Fontana", Corsi.MEDICINA));
        studenti.add(new Studente(10, "Giulia", "Moretti", Corsi.LETTERE));
    }
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
    public Optional<Studente> modificaStudente(int idStud, Studente s){
        Optional<Studente> studenteEsistente = cercaPerId(idStud);
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
