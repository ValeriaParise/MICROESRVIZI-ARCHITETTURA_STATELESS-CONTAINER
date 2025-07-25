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

    public StudenteDAO(List<Studente> studenti){
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
        if(!studenti.contains(studente)){
            studenti.add(studente);
            studente.setId(counter++);
        return studente;}
        else System.out.println("Studente già presente nella lista.");
        return null;
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
        Optional<Studente> studenteEsistente = cercaPerId(idStud);
        if(studenteEsistente.isPresent()){
            Studente originale = studenteEsistente.get();
                originale.setCognome(s.getCognome());
                originale.setNome(s.getNome());
                originale.setFuoricorso(s.isFuoricorso());
                originale.setCorsoDiStudio(s.getCorsoDiStudio());
                originale.setRettaAnnuale(s.getRettaAnnuale());
                return Optional.of(originale);
        }
        return Optional.empty();
    }

    //Elimina per id
    public boolean rimuoviStudenteId(int id){
        for(Studente s : studenti){
            if (s.getId() == id){ return studenti.remove(s);}
        }
        return false;
    }

    //elimina tutti
    public boolean eliminaStudenti(){
        if (studenti.isEmpty()){return  false;}
        else{studenti.clear();
        return true;}
    }

    //Calcola Retta
    public double importoRetta(int id){
        Studente s = studenti.get(id);
        if(s!= null){
            if(s.isFuoricorso()){
                s.setRettaAnnuale(s.getRettaAnnuale()*1.25);
            }
        }
        return  s.getRettaAnnuale();
    }

    //Implementa il metodo che consenta di aggiornare lo stato di un esame per uno studente.

    public boolean aggiornaStatoEsame(int idStudente, int idEsame, boolean newStato){
        Optional<Studente> studenteSelezionato = cercaPerId(idStudente);

        if(studenteSelezionato.isPresent()){
            Studente s = studenteSelezionato.get();
            Optional<Esame> esameDaAggiornare = s.getEsamiStudente()
                    .stream().filter(esame -> esame.getIdEsame() == idEsame).findFirst();

            if(esameDaAggiornare.isPresent()){
                Esame esameSelezionato = esameDaAggiornare.get();
                esameSelezionato.setSostenuto(newStato);
                return true;
            }
        }
        return false;
    }

    //7. Implementa il metodo per recuperare la lista completa degli esami associati ad uno
    //studente.

    public List<Esame> listaEsamiPerStudente (int idStudente){
        Optional<Studente> studenteSelezionato = cercaPerId(idStudente);

        if(studenteSelezionato.isPresent()){
            Studente s = studenteSelezionato.get();
            return s.getEsamiStudente();
        }
        return null;
    }

    //8. Implementa il metodo per recuperare la lista degli esami sostenuti da uno studente.

    public List<Esame> listaEsamiSostenutiStudente(int idStudente){
        Optional<Studente> studenteSelezionato = cercaPerId(idStudente);

        if(studenteSelezionato.isPresent()){
            Studente s = studenteSelezionato.get();
            return (s.getEsamiStudente().stream().filter(esame -> esame.isSostenuto())).toList();
        }
        return null;
    }

//9. Implementa il metodo che consenta di recuperare la lista degli esami che l’utente
   // deve sostenere.

    public List<Esame> listaEsamiDaSostenereStudente(int idStudente){
        Optional<Studente> studenteSelezionato = cercaPerId(idStudente);

        if(studenteSelezionato.isPresent()){
            Studente s = studenteSelezionato.get();
            return (s.getEsamiStudente().stream().filter(esame -> !esame.isSostenuto())).toList();
        }
        return null;
    }

    //10. Implementa il metodo che consenta di recuperare la media dei voti di uno studente.

    public Double mediaVotiPerStudente(int idStudente){
        Optional<Studente> studenteSelezionato = cercaPerId(idStudente);

        if(studenteSelezionato.isPresent()){
            double somma = 0;
            Studente s = studenteSelezionato.get();
            List<Esame> esami =listaEsamiSostenutiStudente(studenti.indexOf(s));
            if(!esami.isEmpty()) {
                for (Esame e : esami) {
                    somma += e.getVoto();
                }
                double media = (somma/esami.size());
                double mediaRound = Math.round(media*100)/100;
                return mediaRound;
               // return Optional.of((double) (mediaRound)).get();
            }
        }
        return 0.0;
    }
}
