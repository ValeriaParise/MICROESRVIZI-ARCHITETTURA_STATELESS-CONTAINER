package com.example.demo.DAOTEST;

import com.example.demo.dao.OggettiDAO;
import com.example.demo.dao.OrdineDAO;
import com.example.demo.model.OggettiOrdinati;
import com.example.demo.model.Ordine;
import com.example.demo.model.StatoOrdine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrdineDAOTest {

    private OrdineDAO ordDAO;
   private OggettiDAO oggDAO;

    @BeforeEach
    void setUp(){
        oggDAO = new OggettiDAO();
        ordDAO = new OrdineDAO(oggDAO);

    }

    @Test
    void testCercaPerId(){
        Optional<Ordine> cercato = ordDAO.cercaPerID(1);
        assertTrue(cercato.isPresent());
        assertEquals(1, cercato.get().getId());
    }

    @Test
    void testEliminaPerID(){
        boolean isEliminato = ordDAO.eliminaPerID(1);
        assertTrue(isEliminato);
        assertTrue(!ordDAO.cercaPerID(1).isPresent());
    }

    @Test
    void testCalcolaTotaleOrdine() {
        OggettiDAO oggettiDAO = new OggettiDAO();   // creo catalogo
        OrdineDAO ordDAO = new OrdineDAO(oggettiDAO);

        // 2 cuffie (id=6 -> prezzo 120) + monitor (id=3 -> prezzo 99.99)
        List<OggettiOrdinati> ordinati = Arrays.asList(
                new OggettiOrdinati(oggettiDAO.trovaPerId(6).get(), 2),  // 120*2 = 240
                new OggettiOrdinati(oggettiDAO.trovaPerId(3).get(), 1)   // 99.99
        );

        Ordine o = new Ordine(99, 199, LocalDateTime.now(),
                ordinati, StatoOrdine.CREATO, 0);

        double tot = ordDAO.calcolaTotaleOrdine(o);

        assertEquals(339.99, tot, 0.001, "Totale corretto");
    }
}
