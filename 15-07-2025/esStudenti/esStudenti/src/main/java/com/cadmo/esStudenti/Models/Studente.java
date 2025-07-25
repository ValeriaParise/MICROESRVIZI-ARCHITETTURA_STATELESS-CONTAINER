package com.cadmo.esStudenti.Models;

import java.util.ArrayList;
import java.util.List;

public class Studente {
    private int id;
    private String nome;
    private String cognome;
    private String corsoDiStudio;
    private boolean fuoricorso = false;
    private double rettaAnnuale = 300.00;

    // Collego lo studente con Esami
    private List<Esame> esamiStudente = new ArrayList<>();

    public Studente() {
        // Costruttore vuoto necessario per Jackson (deserializzazione JSON)
    }

    public Studente(int id, String nome, String cognome,boolean fc, String corsoDiStudio){
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.corsoDiStudio = corsoDiStudio;
        this.fuoricorso=fc;
    }
    public Studente(int id, String nome, String cognome, String corsoDiStudio){
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.corsoDiStudio = corsoDiStudio;
    }
    public Studente(int id, String nome, String cognome, String corsoDiStudio,List<Esame> esamiStudente){
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.corsoDiStudio = corsoDiStudio;
        this.esamiStudente = esamiStudente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCorsoDiStudio() {
        return corsoDiStudio;
    }

    public void setCorsoDiStudio(String corsoDiStudio) {
        this.corsoDiStudio = corsoDiStudio;
    }

    public double getRettaAnnuale() {
        return rettaAnnuale;
    }

    public void setRettaAnnuale(double rettaAnnuale) {
        this.rettaAnnuale = rettaAnnuale;
    }

    public boolean isFuoricorso() {
        return fuoricorso;
    }

    public void setFuoricorso(boolean fuoricorso) {
        this.fuoricorso = fuoricorso;
    }

    public List<Esame> getEsamiStudente() {
        return esamiStudente;
    }

    public void setEsamiStudente(List<Esame> esamiStudente) {
        this.esamiStudente = esamiStudente;
    }

    @Override
    public String toString() {

        return "Studente : " +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", corsoDiStudi=" + corsoDiStudio +
                ", fuoricorso=" + (isFuoricorso()? "fuori corso" : "in corso" ) +
                ", rettaAnnuale=" + rettaAnnuale;
    }
}
