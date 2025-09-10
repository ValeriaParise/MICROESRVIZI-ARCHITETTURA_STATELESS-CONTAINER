package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "oggetti")
public class Oggetti {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // autoincrement
    private int id;

    @Column(name = "modello" , nullable = false, length = 100)
    private String nome;
    @Column(name = "brand" , nullable = false, length = 100)
    private String marca;

    @Column
    private double costoSingoloOggetto;
    @Column
    private int quantita;
    @Transient
    private double costoTotale;


    // Costruttore vuoto richiesto da JPA
    public Oggetti() {}


    public Oggetti(int id, String marca, String nome, double costoSingoloOggetto, int quantita ) {
        this.costoSingoloOggetto = costoSingoloOggetto;
        this.marca = marca;
        this.nome = nome;
        this.id = id;
        this.quantita = quantita;
        this.costoTotale = getTotale();
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrezzo() {
        return costoSingoloOggetto;
    }

    public void setPrezzo(double prezzo) {
        this.costoSingoloOggetto = prezzo;
    }


    //calcolo del totale
    public double getTotale() {
        return quantita * costoSingoloOggetto;
    }

    @Override
    public String toString() {
        return "Oggetti{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", marca='" + marca + '\'' +
                ", costoSingoloOggetto=" + costoSingoloOggetto +
                ", quantita=" + quantita +
                ", costoTotale=" + costoTotale +
                '}';
    }
}
