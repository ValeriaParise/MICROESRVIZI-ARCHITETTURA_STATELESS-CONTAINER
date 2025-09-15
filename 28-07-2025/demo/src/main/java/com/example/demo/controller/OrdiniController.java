package com.example.demo.controller;

import com.example.demo.models.Ordine;
import com.example.demo.models.StatoOrdine;
import com.example.demo.services.OrdineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/ordini")
public class OrdiniController {

    private OrdineService ordineService;

    @Autowired
    public void OrdineController(OrdineService ordineService) {
        this.ordineService = ordineService;
    }


    //GET ordine per idUser
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Ordine>> getOrdineByUserId(@PathVariable Integer userId){
        List<Ordine> listaOrdini = ordineService.getOrdineByUserId(userId);
        return ResponseEntity.ok(listaOrdini);
    }

    //GET ordine per stato
    @GetMapping("/stato/{stato}")
    public ResponseEntity<List<Ordine>> getOrdineByUserId(@PathVariable String stato){
        try {
            StatoOrdine s = StatoOrdine.valueOf(stato.toUpperCase());
            List<Ordine> listaOrdini = ordineService.getOrdineByStato(s);
            return ResponseEntity.ok(listaOrdini);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().build();
        }
    }

    //POSt crea
    @PostMapping
    public ResponseEntity<Ordine> creaOrdine(@RequestBody Ordine ordine){
         Ordine creato = ordineService.saveOrdine(ordine);
         return ResponseEntity.ok(creato);
    }

    //PUT modifica
    @PutMapping("{idOrdine}")
    public ResponseEntity<Ordine> modificaOrdine(@PathVariable Integer idOrdine,
                                                 @RequestBody Ordine nuovo){
        Optional<Ordine> modificato = ordineService.modificaOrdine(idOrdine, nuovo);
        if(modificato.isPresent()){
            return ResponseEntity.ok(modificato.get());
        }
        else
            return ResponseEntity.notFound().build();
    }

    //Delete ordine
    @DeleteMapping("/{idOrdine}")
    public ResponseEntity<String> deleteORdine(@PathVariable Integer idOrdine){
        if(ordineService.getOrdineById(idOrdine).isPresent()){
            ordineService.deleteOrdine(idOrdine);
            return ResponseEntity.ok("Ordine Rimosso");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ordine non trovato");
        }
    }

}


