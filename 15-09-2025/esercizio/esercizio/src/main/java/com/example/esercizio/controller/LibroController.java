package com.example.esercizio.controller;

import com.example.esercizio.model.Genere;
import com.example.esercizio.model.Libro;
import com.example.esercizio.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/libri")
public class LibroController {

    @Autowired
    LibroService libroService;

    // GET

    @GetMapping
    public List<Libro> getAll(){
        return libroService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Libro> findById(@PathVariable Long id){
        return libroService.findById(id);
    }


    //contiene il param
    @GetMapping("/ricerca/titolo")
    public List<Libro> findByTitolo(@RequestParam String titolo){
        return libroService.findByTitolo(titolo);
    }

    @GetMapping("/ricerca/autore")
    public List<Libro> findByAutore(@RequestParam() String autore){
        return libroService.findByAutore(autore);
    }

    // GET by ISBN  -- 404
    @GetMapping("/ricerca/isbn")
    public Optional<Libro> findByIsbn(@RequestParam String isbn) {
        return libroService.findByIsbn(isbn);
    }

    // GET by anno
    @GetMapping("/ricerca/anno")
    public List<Libro> findByAnno(@RequestParam int anno) {
        return libroService.findByAnno(anno);
    }

    // GET by editore
    @GetMapping("/ricerca/editore")
    public List<Libro> findByEditore(@RequestParam String editore) {
        return libroService.findByEditore(editore);
    }

    // GET by genere
    @GetMapping("/ricerca/genere")
    public List<Libro> findByGenere(@RequestParam Genere genere) {
        return libroService.findByGenere(genere);
    }

    // CREATE
    @PostMapping
    public Libro createLibro(@RequestBody Libro libro) {
        return libroService.createLibro(libro);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Optional<Libro> updateLibro(@PathVariable Long id, @RequestBody Libro nuovo) {
        return libroService.updateLibro(id, nuovo);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return libroService.delete(id);
    }

}
