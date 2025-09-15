package com.example.demo.repository;

import com.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    //Trova utenti per nome
    List<User> findByNome(String nome);

    List<User> findByCognome(String cognome);

    List<User> findByNomeAndCognome(String nome, String cognome);

    User findByEmail(String email);


    //List<User> findByNomeContainingIgnoreCase(String nome);
    //List<User> findByCognomeContainingIgnoreCase(String cognome);
    // boolean existsByEmail(String email);
}
