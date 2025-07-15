package com.cadmo.esStudenti.Services;

import com.cadmo.esStudenti.Models.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudenteService {
    private final StudenteDAO studenteDAO;

    public StudenteService(StudenteDAO studenteDAO){
        this.studenteDAO = studenteDAO;
    }

    public Studente aggiungi(Studente s){
        return studenteDAO.aggiungiStudente(s);
    }

    public Studente cercaPerID(int id){
        return studenteDAO.cercaPerId(id);
    }

    public List<Studente> cercaTutti(){
        return  studenteDAO.mostraStudenti();
    }

    public Studente modificaStudente(Studente s){
        return studenteDAO.modificaStudente(s);
    }

    public void rimuoviStudente(int id){
         studenteDAO.rimuoviStudenteId(id);
    }

    public void eliminaTutti(){
        studenteDAO.eliminaStudenti();
    }
    public double calcolaRetta(int id){
        return studenteDAO.importoRetta(id);
    }
}
