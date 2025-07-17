package com.cadmo.esStudenti.Models;
/*
* Introduci ora la gestione dell’entità Esame implementando tutte le operazioni CRUD.
L’entità Esame dovrà avere i seguenti attributi:
- id - nome  - data - voto - crediti - sostenuto
* */

import java.time.LocalDate;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Esame {
   // private static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");  // giorno/mese/anno ore:minuti


    private int idEsame;
    private String nome;
    private LocalDate data;
    private double voto;
    private int crediti;
    private boolean sostenuto;

    public Esame(int idEsame, String nome, LocalDate data, double voto, int crediti, boolean sostenuto) {
        this.idEsame = idEsame;
        this.nome = nome;
        this.data = data;
        this.voto = Math.round(voto*10)/10; //arrotonamento ad 1 cifra decimale;
        this.crediti = crediti;
        this.sostenuto = sostenuto;
    }

    public int getIdEsame() {
        return idEsame;
    }

    public void setIdEsame(int idEsame) {
        this.idEsame = idEsame;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getVoto() {
        return voto;
    }

    public void setVoto(double voto) {
        this.voto = (double) Math.round(voto * 10) /10; //arrotonamento ad 1 cifra decimale;
    }

    public int getCrediti() {
        return crediti;
    }

    public void setCrediti(int crediti) {
        this.crediti = crediti;
    }

    public boolean isSostenuto() {
        return sostenuto;
    }

    public void setSostenuto(boolean sostenuto) {
        this.sostenuto = sostenuto;
    }



}
