package com.cadmo.esStudenti.ServiceTest;

import com.cadmo.esStudenti.DAO.StudenteDAO;
import com.cadmo.esStudenti.Models.Studente;
import com.cadmo.esStudenti.Services.StudenteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudenteServiceTest {

    private StudenteDAO studenteDao;
    private StudenteService studenteService;

    @BeforeEach
    void setup(){
        studenteDao = new StudenteDAO();
        studenteService = new StudenteService(studenteDao);
    }

    @Test
    void CalcolaRettaInCorso(){
        Optional<Studente> studente_opt = studenteDao.cercaPerId(1);
        assertTrue(studente_opt.isPresent());

        Studente s = studente_opt.get();
        assertEquals(false, s.isFuoricorso());
        s.setRettaAnnuale(500);
        double rettaRes = studenteService.calcolaRetta(s.getId());
        assertEquals(500, rettaRes, "Per lo studente in corso la retta deve rimanere invariata");
    }

    @Test
    void CalcolaRettaFuoriCorso(){
        Optional<Studente> studente_opt = studenteDao.cercaPerId(1);
        assertTrue(studente_opt.isPresent());

        Studente s = studente_opt.get();
        s.setFuoricorso(true);
        s.setRettaAnnuale(500);
        double rettaRes = studenteService.calcolaRetta(s.getId());
        assertEquals(500*1.25 , rettaRes, "Per lo studente fuori corso la retta deve essere maggiorata");
    }

    @Test
    void calcolaRettaStudenteNonTrovato(){
        double rettaRes = studenteService.calcolaRetta(500); //studente inesistente
        assertEquals(0,rettaRes);
    }
}
