package com.example.demo.models;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.List;


@Entity
@Table(name="carrello") //nome nel db
public class Carrello {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement
    private int id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //fetch eager fa caricare ad hibernate i dati (eager)subito
    @JoinColumn(name = "carrello_id") // crea la foreign key su Oggetti
    private List<Oggetti> carrello;


    @Transient // non salvare nel DB, è calcolato
    private double totaleCarrello;

    // Costruttore vuoto richiesto da JPA
    public Carrello() {}

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


    //DA GESTIRE
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
