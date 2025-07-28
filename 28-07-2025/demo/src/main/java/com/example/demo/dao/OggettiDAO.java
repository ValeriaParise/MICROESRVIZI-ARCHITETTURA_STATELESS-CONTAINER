package com.example.demo.dao;

import com.example.demo.model.Oggetti;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OggettiDAO {
    private List<Oggetti> oggetti = new ArrayList<>();

    public OggettiDAO() {
        oggetti.add(new Oggetti(10.50, "Logitech", "Mouse", 1));
        oggetti.add(new Oggetti(20.00, "Logitech", "Tastiera", 2));
        oggetti.add(new Oggetti(99.99, "Samsung", "Monitor 24p", 3));
        oggetti.add(new Oggetti(15.00, "Sandisk", "Chiavetta USB 128GB", 4));
        oggetti.add(new Oggetti(8.50, "Samsung", "MicroSD 32GB", 5));
        oggetti.add(new Oggetti(120.00, "Sony", "Cuffie Wireless", 6));
        oggetti.add(new Oggetti(250.00, "Apple", "iPad", 7));
        oggetti.add(new Oggetti(35.00, "Anker", "PowerBank", 8));
        oggetti.add(new Oggetti(55.00, "Xiaomi", "Smartwatch", 9));
        oggetti.add(new Oggetti(18.00, "TP-Link", "Router Wi-Fi", 10));
    }

}
