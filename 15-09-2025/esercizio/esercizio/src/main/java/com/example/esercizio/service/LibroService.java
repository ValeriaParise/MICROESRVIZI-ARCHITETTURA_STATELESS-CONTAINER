package com.example.esercizio.service;


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
    public Optional<List<Libro>> findAll(){
        return Optional.of(libroRepository.findAll());
    }
    public Optional<Libro> findById(Long id){
        return libroRepository.findById(id);
    }

    public Optional<List<Libro>> findByTitolo(String titolo){
        return libroRepository.getByTitoloContainingIgnoreCase(titolo);
    }

    public Optional<List<Libro>> findByAutore(String autore){
        return libroRepository.getByAutoreContainingIgnoreCase(autore);
    }

    public Optional<Libro> findByIsbn (String isbn){
        return libroRepository.getByIsbnContainingIgnoreCase(isbn);
    }

    public Optional<List<Libro>> findByAnno(int anno){
        return libroRepository.getByAnnoPubblicazione(anno);
    }

    public Optional<List<Libro>> findByEditore(String editore){
        return libroRepository.getByEditoreContainingIgnoreCase(editore);
    }

    public Optional<List<Libro>> findByGenere(String genere){
        return libroRepository.getByGenereContainingIgnoreCase(genere);
    }

    // Create

    public Optional<Libro> createLibro(Libro libro){
        return Optional.of(libroRepository.save(libro));
    }

    // Update

    public Optional<Libro> updateLibro(Long id, Libro nuovo){
        int index = libroRepository.findAll().indexOf(findById(id).get());
        List<Libro> libri = libroRepository.findAll();
        return Optional.ofNullable(libri.set(index, nuovo));
    }

    //Delete

    public boolean delete(Long id){
        Optional<Libro> find = libroRepository.findById(id);
        if(find.isPresent()) {
            libroRepository.delete(find.get());
            return true;
        }
        return false;
        //return  libroRepository.existsById(find.get().getId());
    }

}
