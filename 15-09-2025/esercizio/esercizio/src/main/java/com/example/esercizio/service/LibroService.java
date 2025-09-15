package com.example.esercizio.service;


import com.example.esercizio.model.Genere;
import com.example.esercizio.model.Libro;
import com.example.esercizio.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;


    // FIND
    public List<Libro> findAll(){
        return libroRepository.findAll();
    }
    public Optional<Libro> findById(Long id){
        return libroRepository.findById(id);
    }

    public List<Libro> findByTitolo(String titolo){
        return libroRepository.findByTitoloIgnoreCase(titolo);
    }

    public List<Libro> findByAutore(String autore){
        return libroRepository.findByAutoreContainingIgnoreCase(autore);
    }



    public Optional<Libro> findByIsbn (String isbn){
        return libroRepository.findByIsbnIgnoreCase(isbn);
    }

    public List<Libro> findByAnno(int anno){
        return libroRepository.findByAnnoPubblicazione(anno);
    }

    public List<Libro> findByEditore(String editore){
        return libroRepository.findByEditoreContainingIgnoreCase(editore);
    }

    public List<Libro> findByGenere(Genere genere) {
        return libroRepository.findByGenere(genere);
    }

    // Create
    public Libro createLibro(Libro libro) {
        return libroRepository.save(libro);
    }
    // Update

    public Optional<Libro> updateLibro(Long id, Libro nuovo) {
        return libroRepository.findById(id).map(libro -> {
            libro.setTitolo(nuovo.getTitolo());
            libro.setAutore(nuovo.getAutore());
            libro.setIsbn(nuovo.getIsbn());
            libro.setAnnoPubblicazione(nuovo.getAnnoPubblicazione());
            libro.setEditore(nuovo.getEditore());
            libro.setGenere(nuovo.getGenere());
            return libroRepository.save(libro);
        });
    }

    //Delete

    public boolean delete(Long id){
        if(libroRepository.existsById(id)){
            libroRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
