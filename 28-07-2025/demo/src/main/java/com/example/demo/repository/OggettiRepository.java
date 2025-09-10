package com.example.demo.repository;

import com.example.demo.models.Oggetti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


//Integer tipo della chiave primaria id (wrapper)
@Repository
public interface OggettiRepository extends JpaRepository<Oggetti,Integer> {


    // esistenti:  findAll(), findById(Integer id),
    // save(Oggetti o), delete(Oggetti o)


    //Personalizzati
    List<Oggetti> findByMarca(String marca);
    List<Oggetti> findByNome(String nome);
}
