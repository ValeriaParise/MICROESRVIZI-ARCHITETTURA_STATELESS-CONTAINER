package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.processing.Pattern;

@Entity
@Table(name="utenti") //nome nel db

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // autoincrement
    private int id;

    @Column(nullable = false, length = 100)
    @NotBlank
    private String nome;

    @Column(nullable = false, length = 100)
    @NotBlank
    private String cognome;

    @Column(length = 250)
    private String indirizzo;

    @Column(length = 20)
    //@Pattern(regexp = "\\+?[0-9]*", message = "Numero di telefono non valido")
    private String numeroDiTelefono;

    @Column(nullable = false, unique = true, length = 150)
    @Email(message = "Email non valida")
    private String email;

    public User( String nome, String cognome, String indirizzo, String numeroDiTelefono, String email) {
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzo = indirizzo;
        this.numeroDiTelefono = numeroDiTelefono;
        this.email = email;
    }

    public User(){}  //Richiesto di jpa


    //DA GESTIRE
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

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getNumeroDiTelefono() {
        return numeroDiTelefono;
    }

    public void setNumeroDiTelefono(String numeroDiTelefono) {
        this.numeroDiTelefono = numeroDiTelefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", numeroDiTelefono='" + numeroDiTelefono + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


}
