package com.example.demo.model;

public class OggettiOrdinati {
    private int idOggetto;
    private int quantita;
    private double prezzoOggetto;

    public OggettiOrdinati(int idOggetto, int quantita, double prezzoOggetto) {
        this.idOggetto = idOggetto;
        this.quantita = quantita;
        this.prezzoOggetto = prezzoOggetto;
    }

    public int getIdOggetto() {
        return idOggetto;
    }

    public void setIdOggetto(int idOggetto) {
        this.idOggetto = idOggetto;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public double getPrezzoOggetto() {
        return prezzoOggetto;
    }

    public void setPrezzoOggetto(double prezzoOggetto) {
        this.prezzoOggetto = prezzoOggetto;
    }
}
