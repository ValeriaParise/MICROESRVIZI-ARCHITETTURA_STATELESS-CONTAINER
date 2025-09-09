package com.example.demo.model;

import java.util.List;

public class Carrello {

    private List<Oggetti> carrello;

    private double totaleCarrello;

    public Carrello(List<Oggetti> carrello) {
        this.carrello = carrello;
        totaleCarrello = calcolaTotale();
    }


    public double calcolaTotale(){
        double tot = 0;
        for (Oggetti o : carrello){
            tot += o.getTotale();
        }
        return tot;
    }

    public List<Oggetti> getCarrello() {
        return carrello;
    }

    public void setCarrello(List<Oggetti> carrello) {
        this.carrello = carrello;
    }

    public double getTotaleCarrello() {
        return totaleCarrello;
    }

    public void setTotaleCarrello(double totaleCarrello) {
        this.totaleCarrello = totaleCarrello;
    }


    @Override
    public String toString() {
        return "Carrello{" +
                "carrello=" + carrello +
                ", totaleCarrello=" + totaleCarrello +
                '}';
    }
}
