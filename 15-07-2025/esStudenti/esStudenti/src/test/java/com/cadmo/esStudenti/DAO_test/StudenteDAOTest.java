package com.cadmo.esStudenti.DAO_test;

import com.cadmo.esStudenti.DAO.StudenteDAO;
import com.cadmo.esStudenti.Models.Studente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class StudenteDAOTest {

    private StudenteDAO studenteDAO;

    @BeforeEach
    void setupStudenteDAO(){
        studenteDAO = new StudenteDAO();
    }

    @Test
    void testAddStudente(){
        Studente s = new Studente(16, "EMMA", "COSTA", "LETTERE");
        studenteDAO.aggiungiStudente(s);
        assertEquals(17, studenteDAO.studenti.size());
        assertTrue(studenteDAO.studenti.contains(s));
    }


    @Test
    void testCercaPerID(){
        int id = 4; //         studenti.add(new Studente(4, "Chiara", "Neri", "CHIMICA"));

        Optional<Studente> studente_cercato = studenteDAO.cercaPerId(4);
        assertTrue(studente_cercato.isPresent(), "Verifico che ci sia uno studente");

        Studente cercato = studente_cercato.get();
        assertEquals(id ,cercato.getId(), "Verifico che l id sia uguale");
        assertEquals("Chiara", cercato.getNome());
        assertEquals("Neri", cercato.getCognome());

    }

    @Test
    void testCercaPerIDNonEsistente(){
        int id = 500;
        Optional<Studente> studente = studenteDAO.cercaPerId(id);
        assertTrue(studente.isEmpty(), "Nessuno studente con quell'id");
    }


}
