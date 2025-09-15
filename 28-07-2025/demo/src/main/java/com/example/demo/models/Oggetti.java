package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "oggetti")
public class Oggetti {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // autoincrement
    private Integer id;

    @Column(name = "modello" , nullable = false, length = 100)
    private String nome;
    @Column(name = "brand" , nullable = false, length = 100)
    private String marca;

    @Column
    private double costoSingoloOggetto;
    @Column
    private int quantita;



    // Costruttore vuoto richiesto da JPA
    public Oggetti() {}


    public Oggetti( String marca, String nome, double costoSingoloOggetto, int quantita ) {
        this.costoSingoloOggetto = costoSingoloOggetto;
        this.marca = marca;
        this.nome = nome;
        this.quantita = quantita;
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

    public double getCostoSingoloOggetto() { return costoSingoloOggetto; }

    public void setCostoSingoloOggetto(double costoSingoloOggetto)
    { this.costoSingoloOggetto = costoSingoloOggetto; }

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
                ", costoTotale=" + getTotale() +
                '}';
    }
}
