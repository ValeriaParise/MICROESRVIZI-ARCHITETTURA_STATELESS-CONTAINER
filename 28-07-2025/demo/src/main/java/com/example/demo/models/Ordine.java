package com.example.demo.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="ordine") //nome nel db

public class Ordine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // autoincrement
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    //Devo puntare alla tabella user, sulla colonna userid
    private User user;

    @Column(name = "data_ordine", nullable = false)
    private LocalDateTime data;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "carrello_id", referencedColumnName = "id")
    private Carrello carrello;

    @Enumerated(EnumType.STRING)
    private StatoOrdine stato;


    public Ordine(){} //Richiesto di jpa
    public Ordine(int id, User user, LocalDateTime data, Carrello carrello,
                  StatoOrdine stato) {
        this.id = id;
        this.user = user;
        this.data = data;
        this.carrello = carrello;
        this.stato = stato;

    }


    //DA GESTIRE


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public void setCarrello(Carrello carrello) {
        this.carrello = carrello;
    }

    public StatoOrdine getStato() {
        return stato;
    }

    public void setStato(StatoOrdine stato) {
        this.stato = stato;
    }
}




