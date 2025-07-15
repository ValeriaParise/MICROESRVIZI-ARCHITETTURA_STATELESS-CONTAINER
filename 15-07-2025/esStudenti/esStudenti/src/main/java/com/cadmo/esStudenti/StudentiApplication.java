package com.cadmo.esStudenti;


/*
* Realizza un microservizio JAva che permette di gestire l entità Studente implementando Tutte le operazioni crud.
* Studente dovra avere id nome cognme corsodi studi fuoricordo retta annuale da pagare. Il microservizio funziona senza connessione
* a db. i dati saranno gestiti tramite lista di studenti instanziata im una classe dao. Implementare i meteodi
* deleteAll per eliminare tutti gli elementi della lista, un medoto updateRetta che in base all'essere fuoricorso o meno dello
* studente aumenta la retta del 25%*/
import com.cadmo.esStudenti.Models.CorsoDiStudi;
import com.cadmo.esStudenti.Models.Studente;
import com.cadmo.esStudenti.Services.StudenteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudentiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentiApplication.class, args);
	}


	@Bean
	public CommandLineRunner initData(StudenteService service) {
		return args -> {
			service.aggiungi(new Studente(0, "Marco", "Bianchi", CorsoDiStudi.INFORMATICA));
			service.aggiungi(new Studente(0, "Giulia", "Russo", CorsoDiStudi.MATEMATICA));
			service.aggiungi(new Studente(0, "Luca", "Esposito", CorsoDiStudi.FISICA));
			service.aggiungi(new Studente(0, "Veronica", "Ferrari", CorsoDiStudi.CHIMICA));
			service.aggiungi(new Studente(0, "Alessandro", "Romano", CorsoDiStudi.INGEGNERIA_GESTIONALE));
		};
	}
}
