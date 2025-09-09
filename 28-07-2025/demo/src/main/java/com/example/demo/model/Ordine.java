package com.example.demo.model;

import java.time.LocalDateTime;

public class Ordine {
    private int id;
    private int userID;
    private LocalDateTime data;
    private Carrello carrello;
    private StatoOrdine stato;



    public Ordine(int id, int userID, LocalDateTime data, Carrello carrello,
                  StatoOrdine stato) {
        this.id = id;
        this.userID = userID;
        this.data = data;
        this.carrello = carrello;
        this.stato = stato;

    }

    public int getId() {
        return id;
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

    public Carrello getCarrello() {
        return carrello;
    }

    public StatoOrdine getStato() {
        return stato;
    }

    public void setStato(StatoOrdine stato) {
        this.stato = stato;
    }


    @Override
    public String toString() {
        return "Ordine{" +
                "id=" + id +
                ", userID=" + userID +
                ", data=" + data +
                ", carrello=" + carrello +
                ", stato=" + stato +
                '}';
    }
}




