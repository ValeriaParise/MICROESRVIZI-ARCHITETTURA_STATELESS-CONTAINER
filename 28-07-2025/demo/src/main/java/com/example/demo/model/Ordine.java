package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.List;

public class Ordine {
    private int id;
    private int userID;
    private LocalDateTime data;
    private OggettiOrdinati oggettiOrdinati;
    private StatoOrdine stato;
    private double importoOrdine;


    public Ordine(int id, int userID, LocalDateTime data, OggettiOrdinati oggettiOrdinati,
                  StatoOrdine stato, double importoOrdine) {
        this.id = id;
        this.userID = userID;
        this.data = data;
        this.oggettiOrdinati = oggettiOrdinati;
        this.stato = stato;
        this.importoOrdine = importoOrdine;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public OggettiOrdinati getOggettiOrdinati() {
        return oggettiOrdinati;
    }

    public void setOggetti(OggettiOrdinati oggettiOrdianti) {
        this.oggettiOrdinati = oggettiOrdinati;
    }

    public StatoOrdine getStato() {
        return stato;
    }

    public void setStato(StatoOrdine stato) {
        this.stato = stato;
    }

    public double getImportoOrdine() {
        return importoOrdine;
    }

    public void setImportoOrdine(double importoOrdine) {
        this.importoOrdine = importoOrdine;
    }

    @Override
    public String toString() {
        return "Ordine{" +
                "id=" + id +
                ", userID=" + userID +
                ", data=" + data +
                ", oggetti=" + oggettiOrdinati +
                ", stato=" + stato +
                ", importoOrdine=" + importoOrdine +
                '}';
    }
}
