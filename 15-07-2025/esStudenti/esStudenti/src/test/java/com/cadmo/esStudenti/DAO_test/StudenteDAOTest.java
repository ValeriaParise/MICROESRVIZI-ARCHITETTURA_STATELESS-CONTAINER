package DAO;

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


    //TEST NON SUPERATO -  ATTENZIONE A COME VENGONO CONFRONTATI I DUE OGGETTI!!!
    @Test
    void testCercaPerID(){
        Studente atteso = new Studente(4, "Chiara", "Neri", "CHIMICA");
        Optional<Studente> studente_cercato = studenteDAO.cercaPerId(4);
        Studente res = studente_cercato.get();
        assertEquals(atteso , res);
        assertTrue(studenteDAO.studenti.contains(atteso));
    }



}
