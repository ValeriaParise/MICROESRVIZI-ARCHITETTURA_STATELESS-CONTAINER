package com.cadmo.esStudenti.Services;

import com.cadmo.esStudenti.Models.CorsoDiStudio;
import com.cadmo.esStudenti.DAO.CorsoDiStudioDAO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CorsoDiStudioService {
    private final CorsoDiStudioDAO corsoDiStudioDAO;

    public CorsoDiStudioService(CorsoDiStudioDAO corsoDiStudioDAO) {
        this.corsoDiStudioDAO = corsoDiStudioDAO;
    }

    public List<CorsoDiStudio> getCorsiDiStudio(){
        return corsoDiStudioDAO.getCorsiDiStudio();
    }
    public CorsoDiStudio aggiungiCorsoDiStudio(CorsoDiStudio c){
        return corsoDiStudioDAO.aggiungiCorsoDiStudio(c);
    }

    public Optional<CorsoDiStudio> cercaCorsoPerID(int id){
        return corsoDiStudioDAO.cercaCorsoPerID(id);
    }

    public Optional<CorsoDiStudio> modificaCorsoDiStudi(int idcorso,CorsoDiStudio nc){
        return corsoDiStudioDAO.modificaCorsoDiStudi(idcorso, nc);
    }

    public boolean rimuoviCorsoDiStudi(int id){
        return corsoDiStudioDAO.rimuoviCorsoDiStudi(id);
    }

    public boolean rimuoviTuttiCorsi(){
        return corsoDiStudioDAO.rimuoviTuttiCorsi();
    }
}
