package com.example.esercizio.repository;

import com.example.esercizio.model.Genere;
import com.example.esercizio.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

    // Personalizzati
    List<Libro> findByTitoloIgnoreCase(String titolo);
    List<Libro> findByAutoreContainingIgnoreCase(String autore);
    Optional<Libro> findByIsbnIgnoreCase(String isbn); // qui Optional va bene
    List<Libro> findByAnnoPubblicazione(int annoPubblicazione);
    List<Libro> findByEditoreContainingIgnoreCase(String editore);
    List<Libro> findByGenere(Genere genere);


}
