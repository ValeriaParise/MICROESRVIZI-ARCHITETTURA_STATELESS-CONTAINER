package com.cadmo.esStudenti.Models;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class StudenteDAO {

    public List<Studente> studenti = new ArrayList<>();
    int counter = 11;

    public StudenteDAO(List<Studente> studenti){
        studenti.add(new Studente(1, "Mario", "Rossi", "informatica"));
        studenti.add(new Studente(2, "Lucia", "Bianchi", "economia"));
        studenti.add(new Studente(3, "Giovanni", "Verdi", "INGEGNERIA_INFORMATICA"));
        studenti.add(new Studente(4, "Chiara", "Neri", "CHIMICA"));
        studenti.add(new Studente(5, "Marco", "Russo", "MEDICINA"));
        studenti.add(new Studente(6, "Sara", "Costa", "INFORMATICA"));
        studenti.add(new Studente(7, "Paolo", "Ferrari", "INGEGNERIA_MECCANICA"));
        studenti.add(new Studente(8, "Elena", "Gallo", "FISICA"));
        studenti.add(new Studente(9, "Luca", "Fontana", "MEDICINA"));
        studenti.add(new Studente(10, "Giulia", "Moretti", "LETTERE"));

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

    public Optional<Double> mediaVotiPerStudente(int idStudente){
        Optional<Studente> studenteSelezionato = cercaPerId(idStudente);

        if(studenteSelezionato.isPresent()){
            double somma = 0;
            Studente s = studenteSelezionato.get();
            List<Esame> esami =listaEsamiSostenutiStudente(studenti.indexOf(s));
            if(!esami.isEmpty()) {
                for (Esame e : esami) {
                    somma += e.getVoto();
                }
                double media = somma/esami.size();

                return Optional.of((double) (Math.round(media*100)/100));
            }
        }
        return Optional.empty();
    }
}
