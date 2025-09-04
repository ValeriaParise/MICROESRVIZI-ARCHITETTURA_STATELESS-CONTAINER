package com.example.demo.DAOTEST;

import com.example.demo.dao.OrdineDAO;
import com.example.demo.model.Ordine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrdineDAOTest {

    private OrdineDAO dao;

    @BeforeEach
    void setUp(){
        dao = new OrdineDAO();
    }

    @Test
    void testCercaPerId(){
        Optional<Ordine> cercato = dao.cercaPerID(1);
        assertTrue(cercato.isPresent());
        assertEquals(1, cercato.get().getId());
    }

    @Test
    void testEliminaPerID(){
        boolean isEliminato = dao.eliminaPerID(1);
        assertTrue(isEliminato);
        assertTrue(!dao.cercaPerID(1).isPresent());
    }
}
