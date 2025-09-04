package com.example.demo.dao;

import com.example.demo.model.Oggetti;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class OggettiDAO {
    private List<Oggetti> oggetti = new ArrayList<>();

    public OggettiDAO() {
        oggetti.add(new Oggetti(1, "Logitech", "Mouse",  10.50));
        oggetti.add(new Oggetti(2, "Logitech", "Tastiera", 20));
        oggetti.add(new Oggetti(3, "Samsung", "Monitor 24p", 99.99));
        oggetti.add(new Oggetti(4, "Sandisk", "Chiavetta USB 128GB", 15));
        oggetti.add(new Oggetti(5, "Samsung", "MicroSD 32GB", 8.5));
        oggetti.add(new Oggetti(6, "Sony", "Cuffie Wireless", 120));
        oggetti.add(new Oggetti(7, "Apple", "iPad", 250));
        oggetti.add(new Oggetti(8, "Anker", "PowerBank", 38));
        oggetti.add(new Oggetti(9, "Xiaomi", "Smartwatch", 55));
        oggetti.add(new Oggetti(10, "TP-Link", "Router Wi-Fi", 18));
    }

    public Optional<Oggetti> trovaPerId(int id) {
        return oggetti.stream().filter(o -> o.getId() == id).findFirst();
    }
}
