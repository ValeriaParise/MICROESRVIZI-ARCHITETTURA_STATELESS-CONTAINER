package com.cadmo.esStudenti.DAO_test;

import com.cadmo.esStudenti.DAO.EsameDAO;
import com.cadmo.esStudenti.Models.Esame;
import com.cadmo.esStudenti.Models.Studente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class EsameDAO_test {

    private EsameDAO esameDAO;
    private Studente s;

    @BeforeEach
    void setupEsameDAO(){
        esameDAO = new EsameDAO();

    }

    @Test
    void testAggiungiEsame(){
        Esame nuovo = new Esame(0, "Corso", LocalDate.of(2025,07,25), 27,6,false);
        int lunghezzaIniziale = esameDAO.getListaEsami().size();

        Esame res = esameDAO.aggiungiEsame(nuovo);

        assertNotNull(res, "Restituisce esame aggiunto");
        assertEquals(lunghezzaIniziale+1, esameDAO.getListaEsami().size());
        assertTrue(esameDAO.getListaEsami().contains(nuovo));
        assertTrue(res.getIdEsame()>=50); // il contatore è impostato a 50 quindi dovrebbe aumentare di 1
    }


    @Test
    void testEsameDuplicato(){
        Optional<Esame> esameEsistente = esameDAO.cercaEsamePerID(1);
        assertTrue(esameEsistente.isPresent(), "esistenza dell'esame");

        Esame esistente = esameEsistente.get();
        int lunghezzaIniziale = esameDAO.getListaEsami().size();
        Esame res = esameDAO.aggiungiEsame(esistente);

        assertNull(res, "Null se l'esame già esiste");
        assertEquals(lunghezzaIniziale, esameDAO.getListaEsami().size());
    }
}
