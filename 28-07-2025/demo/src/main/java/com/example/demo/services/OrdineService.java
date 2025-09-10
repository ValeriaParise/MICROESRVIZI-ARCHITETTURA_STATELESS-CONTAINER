package com.example.demo.services;

import com.example.demo.models.Ordine;
import com.example.demo.repository.OrdineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class OrdineService {

    private final OrdineRepository ordineRepository;

    @Autowired
    public OrdineService(OrdineRepository ordineRepository) {
        this.ordineRepository = ordineRepository;
    }


    //cerca ordine di un utente
    public List<Ordine> getOrdineByUserId(Integer userId){
        return  ordineRepository.findByUserId(userId);
    }

    //filtra ordine per stato
    public List<Ordine> getOrdineByStato(String stato){
        return ordineRepository.findByStato(stato);
    }

    //Cerca ordine tramite idOrdine
    public Optional<Ordine> getOrdineById(int idOrdine){
        return ordineRepository.findById(idOrdine);
    }

    //Salva ordine
    public Ordine saveOrdine(Ordine ordine){
        return ordineRepository.save(ordine);
    }

    //Modifica Ordine
    public Optional<Ordine> modificaOrdine(Integer id, Ordine nuovo){
        Optional<Ordine> originale = ordineRepository.findById(id);
        if(originale.isPresent()){
            Ordine o = originale.get();
            o.setStato(nuovo.getStato());
            o.setData(nuovo.getData());
            o.setUser(nuovo.getUser());
            o.setCarrello(nuovo.getCarrello());

            //aggiorno lo stato o con le nuove modifiche
            Ordine aggiornato = ordineRepository.save(o);
            return Optional.of(aggiornato);
        }
        return Optional.empty();
    }

    //elimina ordine tramite id
    public boolean deleteOrdine(int id){
        Optional<Ordine> o = ordineRepository.findById(id);
        if(o.isPresent()){
            ordineRepository.delete(o.get());
            return true;
        }
        return false;
    }

}
