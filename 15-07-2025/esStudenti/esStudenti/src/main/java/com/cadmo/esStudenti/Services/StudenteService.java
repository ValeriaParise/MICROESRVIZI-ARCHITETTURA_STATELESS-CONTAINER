package com.cadmo.esStudenti.Services;

import com.cadmo.esStudenti.Models.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudenteService {
    private final StudenteDAO studenteDAO;

    public StudenteService(StudenteDAO studenteDAO){
        this.studenteDAO = studenteDAO;
    }

    public Studente aggiungiStudente(Studente s){
        return studenteDAO.aggiungiStudente(s);
    }

    public Optional<Studente> cercaStudentePerID(int id){
        return studenteDAO.cercaPerId(id);
    }

    public List<Studente> cercaTutti(){
        return  studenteDAO.mostraTutti();
    }

    public Optional<Studente> modificaStudente(int id,Studente s){
        return studenteDAO.modificaStudente(id,s);
    }

    public boolean rimuoviStudente(int id){
         return studenteDAO.rimuoviStudenteId(id);
    }

    public boolean eliminaTuttiStudenti(){
        return studenteDAO.eliminaStudenti();
    }
    public double calcolaRetta(int id){
        return studenteDAO.importoRetta(id);
    }
}
