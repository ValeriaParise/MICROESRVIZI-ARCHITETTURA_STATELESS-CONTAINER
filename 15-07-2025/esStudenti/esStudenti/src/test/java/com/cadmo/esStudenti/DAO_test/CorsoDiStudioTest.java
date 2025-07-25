package com.cadmo.esStudenti.DAO_test;

import com.cadmo.esStudenti.DAO.CorsoDiStudioDAO;
import com.cadmo.esStudenti.Models.CorsoDiStudio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CorsoDiStudioTest {

    private CorsoDiStudioDAO cdsDAO;

    @BeforeEach
    void setupCorsoDiStudio(){
        cdsDAO = new CorsoDiStudioDAO();
    }

    @Test
    void testModificaCorsoEsistente(){
        int id = 3; // fisica
        CorsoDiStudio aggioramento = new CorsoDiStudio(0, "Chimica", 4, List.of());

        Optional<CorsoDiStudio> aggiornato = cdsDAO.modificaCorsoDiStudi(id,aggioramento);
        assertTrue(aggiornato.isPresent(), "verifico che sia presente il corso aggiornato");

        CorsoDiStudio agg = aggiornato.get();

        assertEquals(id, agg.getIdCorso(), "Verifico che l'id del corso aggiornato sia quello definito sopra");
        assertEquals("Chimica", agg.getNomeCorso(), "Verifico che il nome del corso sia stato aggiornato");
        assertEquals(4, agg.getDurata(), "Verfico che sia astata aggiornata la durata");
    }

    @Test
    void testModificaCorsoNonEsistente(){
        int id = 500; //non esistente
        CorsoDiStudio nuovo = new CorsoDiStudio(0, "NuovoCorso", 2, List.of());

        Optional<CorsoDiStudio> res = cdsDAO.modificaCorsoDiStudi(id,nuovo);
        assertTrue(res.isEmpty(), "Tenta di modifica un corso non esistente");

        // La lista non deve contentere NuovoCorso
        long count = cdsDAO.getCorsiDiStudio().stream().filter(corsoDiStudio ->
                nuovo.getNomeCorso().equals(corsoDiStudio.getNomeCorso())).count();

        assertEquals(0,count, "Non deve essere trovato alcun corso con nome NuovoCorso");


    }

}
