package com.cadmo.esStudenti.Models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.List;


public class CorsoDiStudio {
    private int idCorso;
    private String nomeCorso;
    private int durata; // in anni
    private List<Esame> esamiCorso;

    public CorsoDiStudio(int idCorso, String nomeCorso, int durata, List<Esame> esamiCorso) {
        this.idCorso = idCorso;
        this.nomeCorso = nomeCorso;
        this.durata = durata;
        this.esamiCorso = esamiCorso;
    }

    public int getIdCorso() {
        return idCorso;
    }

    public void setIdCorso(int idCorso) {
        this.idCorso = idCorso;
    }

    public String getNomeCorso() {
        return nomeCorso;
    }

    public void setNomeCorso(String nomeCorso) {
        this.nomeCorso = nomeCorso;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public List<Esame> getEsamiCorso() {
        return esamiCorso;
    }

    public void setEsamiCorso(List<Esame> esamiCorso) {
        this.esamiCorso = esamiCorso;
    }
}