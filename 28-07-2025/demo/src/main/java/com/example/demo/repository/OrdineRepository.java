package com.example.demo.repository;

import com.example.demo.models.Ordine;
import com.example.demo.models.StatoOrdine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdineRepository extends JpaRepository<Ordine, Integer> {

    //esistenti findAll(), findById(id), save(ordine), delete(ordine)

    //Personalizzati
    List<Ordine> findByUserId(Integer userId);

    List<Ordine> findByStato(StatoOrdine stato);


    //List<Ordine> findByDataBetween(LocalDateTime start, LocalDateTime end);

}
