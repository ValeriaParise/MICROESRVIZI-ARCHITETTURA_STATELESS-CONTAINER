package com.example.esercizio.repository;

import com.example.esercizio.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

    // Personalizzati
    public Optional<List<Libro>> getByTitoloContainingIgnoreCase(String titolo);
    public Optional<List<Libro>> getByAutoreContainingIgnoreCase(String autore);
    public Optional<Libro> getByIsbnContainingIgnoreCase(String isbn);
    public Optional<List<Libro>> getByAnnoPubblicazione(int annoPubblicazione);
    public Optional<List<Libro>> getByEditoreContainingIgnoreCase(String editore);
    public Optional<List<Libro>> getByGenereContainingIgnoreCase(String genere);


}
