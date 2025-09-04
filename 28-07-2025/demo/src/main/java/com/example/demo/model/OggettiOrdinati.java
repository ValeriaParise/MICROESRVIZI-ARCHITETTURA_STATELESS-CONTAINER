package com.example.demo.model;

import com.example.demo.dao.OggettiDAO;

import java.util.List;

public class OggettiOrdinati {

    private Oggetti oggetto;

    private int quantita;

    public OggettiOrdinati(Oggetti oggetto, int quantita) {
        this.oggetto = oggetto;
        this.quantita = quantita;
    }

    public Oggetti getOggetto() {
        return oggetto;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public double getPrezzoTotale() {
        return oggetto.getPrezzo() * quantita;
    }

}
