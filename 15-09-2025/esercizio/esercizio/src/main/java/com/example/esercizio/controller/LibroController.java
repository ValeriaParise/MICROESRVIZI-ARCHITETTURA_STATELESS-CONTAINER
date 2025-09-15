package com.example.esercizio.controller;

import com.example.esercizio.model.Libro;
import com.example.esercizio.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Libri")
public class LibroController {

    @Autowired
    LibroService libroService;

    // GET

    @GetMapping()
    public Optional<List<Libro>> getAll(){
        return libroService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Libro> findById(@PathVariable Long id){
        return libroService.findById(id);
    }

    @GetMapping("/titoli")
    public Optional<List<Libro>> findByTitolo(@RequestParam(required = false) String titolo){
        //GESTIRE IL REQ Param
        return libroService.findByTitolo(titolo);
    }

    @GetMapping("/autore")
    public Optional<List<Libro>> findByAutore(@RequestParam() String autore){
        return libroService.findByAutore(autore);
    }


}
