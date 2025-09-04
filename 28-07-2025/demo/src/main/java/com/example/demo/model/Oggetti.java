package com.example.demo.model;

public class Oggetti {
    private int id;
    private String nome;
    private String marca;
    private double prezzo;

    public Oggetti(int id, String marca, String nome, double prezzo ) {
        this.prezzo = prezzo;
        this.marca = marca;
        this.nome = nome;
        this.id = id;
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
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }





}
