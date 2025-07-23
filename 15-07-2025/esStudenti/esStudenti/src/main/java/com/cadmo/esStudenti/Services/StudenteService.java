package com.cadmo.esStudenti.Services;

import com.cadmo.esStudenti.Models.*;
import org.springframework.stereotype.Service;

import java.util.Collections;
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
        Optional<Studente> esistente = studenteDAO.cercaPerId(id);
        if(esistente.isPresent()){
            return studenteDAO.modificaStudente(id,s);
        }
        else return Optional.empty();
    }

    public boolean rimuoviStudente(int id){
        Optional<Studente> daRimuovere = cercaStudentePerID(id);
        if(daRimuovere.isEmpty()) {
            return false;
        }
        studenteDAO.rimuoviStudenteId(id);
        return true;
    }

    public boolean eliminaTuttiStudenti(){
        return studenteDAO.eliminaStudenti();
    }

    public double calcolaRetta(int id){
        if(studenteDAO.cercaPerId(id).isPresent()){
            Studente s = studenteDAO.cercaPerId(id).get();
            if(s.isFuoricorso()){
                return studenteDAO.aggiornaRetta(id);
            }
            else return s.getRettaAnnuale();
    }
        return 0;
    }

    public boolean aggiornaStatoEsame(int idStudente, int idEsame, boolean newStato){
        Optional<Studente> s = studenteDAO.cercaPerId(idStudente);
        if(s.isPresent()){
            Optional<Esame> esameDaAggiornare = s.get().getEsamiStudente()
                    .stream().filter(esame -> esame.getIdEsame() == idEsame).findFirst();
            if(esameDaAggiornare.isPresent()){
               studenteDAO.aggiornaStatoEsame(idStudente, idEsame, newStato);
                return true;
            }
        }
        return false;
    }

    public List<Esame> listaEsamiPerStudente(int idStudente){
        Optional<Studente> s = studenteDAO.cercaPerId(idStudente);
        if(s.isPresent()){
            return studenteDAO.listaEsamiPerStudente(idStudente);
        }
        return null;
    }

    public List<Esame> listaEsamiSostenutiStudente(int idStudente){
        Optional<Studente> s = studenteDAO.cercaPerId(idStudente);
        if(s.isEmpty()){
            return Collections.emptyList();
        }
        return studenteDAO.listaEsamiSostenutiStudente(idStudente);
    }

    public List<Esame> listaEsamiDaSostenereStudente(int idStudente){
        Optional<Studente> s = studenteDAO.cercaPerId(idStudente);
        if(s.isEmpty()){
            return Collections.emptyList();
        }
        return studenteDAO.listaEsamiDaSostenereStudente(idStudente);
    }

    public double mediaVotiPerStudente(int idStudente){
        Optional<Studente> s = studenteDAO.cercaPerId(idStudente);
        if(s.isPresent() && studenteDAO.listaEsamiDaSostenereStudente(idStudente)!= null){
            return studenteDAO.mediaVotiPerStudente(idStudente);
        }
        return 0;
    }




}
