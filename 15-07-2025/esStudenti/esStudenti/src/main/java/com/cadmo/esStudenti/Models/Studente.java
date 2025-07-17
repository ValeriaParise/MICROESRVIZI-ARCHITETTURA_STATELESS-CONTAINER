package com.cadmo.esStudenti.Models;

public class Studente {
    private int id;
    private String nome;
    private String cognome;
    private Corsi corsoDiStudi;
    private boolean fuoricorso = false;
    private double rettaAnnuale = 300.00;

    public Studente(int id, String nome, String cognome, Corsi corsi){
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.corsoDiStudi = corsi;
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

    public Corsi getCorsoDiStudi() {
        return corsoDiStudi;
    }

    public void setCorsoDiStudi(Corsi corsi) {
        this.corsoDiStudi = corsi;
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

    @Override
    public String toString() {

        return "Studente : " +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", corsoDiStudi=" + corsoDiStudi +
                ", fuoricorso=" + (isFuoricorso()? "fuori corso" : "in corso" ) +
                ", rettaAnnuale=" + rettaAnnuale;
    }
}
