package com.cadmo.esStudenti.DAO;

import com.cadmo.esStudenti.Models.Esame;
import com.cadmo.esStudenti.Models.Studente;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class StudenteDAO {

    public List<Studente> studenti = new ArrayList<>();
    int counter = 16;

    public StudenteDAO(){
        studenti.add(new Studente(0, "EMMA", "Russo", "LETTERE"));
        studenti.add(new Studente(1, "Mario", "Rossi", "INFORMATICA"));
        studenti.add(new Studente(2, "Lucia", "Bianchi", "ECONOMIA"));
        studenti.add(new Studente(3, "Giovanni", "Verdi", "INGEGNERIA_EDILE"));
        studenti.add(new Studente(4, "Chiara", "Neri", "CHIMICA"));
        studenti.add(new Studente(5, "Marco", "Russo", "MEDICINA"));
        studenti.add(new Studente(6, "Sara", "Costa", "INFORMATICA"));
        studenti.add(new Studente(7, "Paolo", "Ferrari", "INGEGNERIA_MECCANICA"));
        studenti.add(new Studente(8, "Elena", "Gallo", "FISICA"));
        studenti.add(new Studente(9, "Luca", "Fontana", "MEDICINA"));
        studenti.add(new Studente(10, "Giulia", "Moretti", "LETTERE"));


        // Studente 11
        studenti.add(new Studente(
                11, "Luca", "Rossi", "Ingegneria Informatica",
                Arrays.asList(
                        new Esame(1, "Algoritmi", LocalDate.of(2024, 3, 15), 28, 9, true),
                        new Esame(2, "Reti", LocalDate.of(2024, 5, 10), 30, 6, true),
                        new Esame(3, "Sistemi Operativi", LocalDate.of(2024, 6, 5), 27, 6, false)
                )
        ));

        // Studente 12
        studenti.add(new Studente(
                12, "Sara", "Bianchi", "Fisica",
                Arrays.asList(
                        new Esame(4, "Meccanica", LocalDate.of(2024, 2, 20), 29, 8, true),
                        new Esame(5, "Ottica", LocalDate.of(2024, 4, 10), 26, 6, true)
                )
        ));

        // Studente 13
        studenti.add(new Studente(
                13, "Giulia", "Verdi", "Matematica",
                Arrays.asList(
                        new Esame(6, "Analisi 1", LocalDate.of(2023, 11, 10), 30, 9, true),
                        new Esame(7, "Geometria", LocalDate.of(2024, 1, 15), 25, 6, true),
                        new Esame(8, "Logica", LocalDate.of(2024, 3, 20), 28, 6, true)
                )
        ));

        // Studente 14
        studenti.add(new Studente(
                14, "Marco", "Neri", "Chimica",
                Arrays.asList(
                        new Esame(9, "Chimica Organica", LocalDate.of(2024, 4, 5), 22, 9, true),
                        new Esame(10, "Analisi Chimica", LocalDate.of(2024, 5, 10), 24, 6, false)
                )
        ));

        // Studente 15
        studenti.add(new Studente(
                15, "Elena", "Russo", "Biologia",
                Arrays.asList(
                        new Esame(11, "Genetica", LocalDate.of(2023, 12, 2), 30, 6, true),
                        new Esame(12, "Biologia Molecolare", LocalDate.of(2024, 2, 8), 28, 9, true)
                )
        ));


        this.studenti = studenti;
    }
    // Aggiungi studente
    public Studente aggiungiStudente(Studente studente){
            studenti.add(studente);
            studente.setId(counter++);
        return studente;
    }

    //Cerca
    public Optional<Studente> cercaPerId(int id){
        return studenti.stream()
                .filter(s -> s.getId()==id).findFirst();
    }

    //Mostra tutti
    public List<Studente> mostraTutti(){
        return studenti;
    }


    //Modifica uno
    public Optional<Studente> modificaStudente(int idStud, Studente s){
            Studente originale = cercaPerId(idStud).get();
                originale.setCognome(s.getCognome());
                originale.setNome(s.getNome());
                originale.setFuoricorso(s.isFuoricorso());
                originale.setCorsoDiStudio(s.getCorsoDiStudio());
                originale.setRettaAnnuale(s.getRettaAnnuale());
                return Optional.of(originale);
    }

    //Elimina per id
    public boolean rimuoviStudenteId(int id){
        return studenti.remove(cercaPerId(id));
    }


    //elimina tutti
    public boolean eliminaStudenti(){
        studenti.clear();
        return true;
    }


    //Calcola Retta
    public double calcolaRetta(int id){
        Studente s = cercaPerId(id).get();
        s.setRettaAnnuale(s.getRettaAnnuale()*1.25);
        return  s.getRettaAnnuale();
    }

    //Implementa il metodo che consenta di aggiornare lo stato di un esame per uno studente.

    public void aggiornaStatoEsame(int idStudente, int idEsame, boolean newStato){
        studenti.get(idStudente).getEsamiStudente().stream().filter(esame -> esame.getIdEsame() == idEsame).findFirst().get()
                .setSostenuto(newStato);
    }

    //7. Implementa il metodo per recuperare la lista completa degli esami associati ad uno
    //studente.

    public List<Esame> listaEsamiPerStudente (int idStudente){
        Studente s = studenti.get(idStudente);
        return s.getEsamiStudente();
    }

    //8. Implementa il metodo per recuperare la lista degli esami sostenuti da uno studente.

    public List<Esame> listaEsamiSostenutiStudente(int idStudente){
        Studente s = studenti.get(idStudente);
        return (s.getEsamiStudente().stream().filter(esame -> esame.isSostenuto())).toList();
    }

//9. Implementa il metodo che consenta di recuperare la lista degli esami che l’utente
   // deve sostenere.

    public List<Esame> listaEsamiDaSostenereStudente(int idStudente){
        Studente s = studenti.get(idStudente);
        return (s.getEsamiStudente().stream().filter(esame -> !esame.isSostenuto())).toList();
    }

    //10. Implementa il metodo che consenta di recuperare la media dei voti di uno studente.

    public Double mediaVotiPerStudente(int idStudente) {
        double somma = 0;
        List<Esame> esami = listaEsamiSostenutiStudente(idStudente);
        for (Esame e : esami) {
            somma += e.getVoto();
        }
        double media = (somma / esami.size());
        double mediaRound = Math.round(media * 100) / 100;
        return mediaRound;
    }   // return Optional.of((double) (mediaRound)).get();

}

