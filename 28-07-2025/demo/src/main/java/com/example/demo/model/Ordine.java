package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.List;

public class Ordine {
    private int id;
    private int userID;
    private LocalDateTime data;
    private List<OggettiOrdinati> oggetti;
    private StatoOrdine stato;
    private double importoOrdine;


    public Ordine(int id, int userID, LocalDateTime data, List<OggettiOrdinati> oggetti, StatoOrdine stato, double importoOrdine) {
        this.id = id;
        this.userID = userID;
        this.data = data;
        this.oggetti = oggetti;
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

    public List<OggettiOrdinati> getOggetti() {
        return oggetti;
    }

    public void setOggetti(List<OggettiOrdinati> oggetti) {
        this.oggetti = oggetti;
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
}
