package com.cadmo.esStudenti.DAO;


import com.cadmo.esStudenti.Models.CorsoDiStudio;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CorsoDiStudioDAO {
    private int c_counter = 7;
    private List<CorsoDiStudio> corsiDiStudio = new ArrayList<>();

    // ISTANZE IN COSTRUTTORE
public CorsoDiStudioDAO(){

    corsiDiStudio.add(new CorsoDiStudio(1, "Ingegneria Informatica", 3, new ArrayList<>()));
    corsiDiStudio.add(new CorsoDiStudio(2, "Ingegneria Elettronica", 3, new ArrayList<>()));
    corsiDiStudio.add(new CorsoDiStudio(3, "Fisica", 3, new ArrayList<>()));
    corsiDiStudio.add(new CorsoDiStudio(4, "Matematica", 3, new ArrayList<>()));
    corsiDiStudio.add(new CorsoDiStudio(5, "Chimica", 3, new ArrayList<>()));
    corsiDiStudio.add(new CorsoDiStudio(6, "Biologia", 3, new ArrayList<>()));

    this.corsiDiStudio = corsiDiStudio;
}

    public CorsoDiStudio aggiungiCorsoDiStudio(CorsoDiStudio corso){
        if(!corsiDiStudio.contains(corso)){
            corso.setIdCorso(c_counter++);
            corsiDiStudio.add(corso);
            return corso;
        }
        return null;
    }

    public List<CorsoDiStudio> getCorsiDiStudio() {
        return corsiDiStudio;
    }

    public Optional<CorsoDiStudio> cercaCorsoPerID(int id){
        return corsiDiStudio.stream().filter(corso -> corso.getIdCorso() == id).findFirst();
    }

    public Optional<CorsoDiStudio> modificaCorsoDiStudi(int idcorso, CorsoDiStudio corso){
        Optional<CorsoDiStudio> corsoEsistente = cercaCorsoPerID(idcorso);
        if(corsoEsistente.isPresent()){
            CorsoDiStudio originale = corsoEsistente.get();
            //originale.setIdCorso(corso.getIdCorso());
            originale.setNomeCorso(corso.getNomeCorso());
            originale.setDurata(corso.getDurata());
            originale.setEsamiCorso(corso.getEsamiCorso());
            return Optional.of(originale);
        }
        return Optional.empty();
    }

    public boolean rimuoviCorsoDiStudi(int id) {
        return corsiDiStudio.removeIf(c -> c.getIdCorso() == id);
    }

    //Aggiungere rimuovi tutti
    public boolean rimuoviTuttiCorsi(){
        if (corsiDiStudio.isEmpty()){
            return  false;
        }
        else{corsiDiStudio.clear();
            return true;
        }
    }
}
