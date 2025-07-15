package com.cadmo.esStudenti;


/*
* Realizza un microservizio JAva che permette di gestire l entità Studente implementando Tutte le operazioni crud.
* Studente dovra avere id nome cognme corsodi studi fuoricordo retta annuale da pagare. Il microservizio funziona senza connessione
* a db. i dati saranno gestiti tramite lista di studenti instanziata im una classe dao. Implementare i meteodi
* deleteAll per eliminare tutti gli elementi della lista, un medoto updateRetta che in base all'essere fuoricorso o meno dello
* studente aumenta la retta del 25%*/

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentiApplication.class, args);

	}
}
