package com.cadmo.esStudenti.DAO;

import com.cadmo.esStudenti.Models.Esame;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class EsameDAO {

    private List<Esame> listaEsami = new ArrayList<>();
    private int e_counter = 50;


    // AGGIUNGERLI QUI GLI ESMAI
    public EsameDAO() {
// INFORMATICA
    listaEsami.add(new Esame(1, "Analisi 1", LocalDate.of(2024, 3, 15), 28, 9, true));
    listaEsami.add(new Esame(2, "Programmazione", LocalDate.of(2024, 4, 10), 30, 6, true));
    listaEsami.add(new Esame(3, "Algebra", LocalDate.of(2024, 5, 5), 27, 6, true));

    // ECONOMIA
    listaEsami.add(new Esame(4,  "Microeconomia", LocalDate.of(2024, 3, 12), 26, 6, false));
    listaEsami.add(new Esame(5,  "Matematica Finanziaria", LocalDate.of(2024, 4, 22), 29, 9, false));
    listaEsami.add(new Esame(6,  "Statistica", LocalDate.of(2024, 5, 17), 25, 6, true));

    // INGEGNERIA_EDILE
    listaEsami.add(new Esame(7,  "Fisica 1", LocalDate.of(2024, 3, 20), 24, 6, false));
    listaEsami.add(new Esame(8,  "Meccanica", LocalDate.of(2024, 4, 25), 27, 9, true));
    listaEsami.add(new Esame(9,  "Disegno Tecnico", LocalDate.of(2024, 5, 30), 28, 6, true));
    listaEsami.add(new Esame(10,  "Matematica 2", LocalDate.of(2024, 6, 15), 29, 9, false));




    this.listaEsami = listaEsami;
    }

    public List<Esame> getListaEsami(){
        return listaEsami;
    }

    public Optional<Esame> cercaEsamePerID(int id){
        return listaEsami.stream().filter(esame -> esame.getIdEsame() == id).findFirst();
    }

    public Esame aggiungiEsame(Esame esame){
        if(!listaEsami.contains(esame)){
            listaEsami.add(esame);
            esame.setIdEsame(e_counter++);
            return esame;}
        else System.out.println("Esame già presente nella lista.");
        return null;
    }

    public Optional<Esame> modificaEsame(int idex, Esame e){
        Optional<Esame> esameEsistente = cercaEsamePerID(idex);
        if(esameEsistente.isPresent()){
            Esame originale = esameEsistente.get();
            originale.setNome(e.getNome());
            originale.setData(e.getData());
            originale.setVoto(e.getVoto());
            originale.setCrediti(e.getCrediti());
            originale.setSostenuto(e.isSostenuto());
            return Optional.of(originale);
        }
        return Optional.empty();
    }

    //Elimina per id
    public boolean rimuoviEsame(int id){
        //Optional<Esame> esameDaEliminare = cercaEsamePerID(id);
        return  listaEsami.removeIf(esame -> esame.getIdEsame()==id);
                //(esame -> esame.getIdEsame()== id);
       /* for(Esame e : listaEsami){
            if (e.getIdEsame() == id){ return listaEsami.remove(e);}
        }
        return false;*/
    }

    //elimina tutti
    public boolean eliminaTuttiEsami(){
        if (listaEsami.isEmpty()){return  false;}
        else{listaEsami.clear();
            return true;}
    }


}
