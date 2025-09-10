package com.example.demo.services;

import com.example.demo.repository.OrdineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrdineService {

    @Autowired
    private OrdineRepository ordineRepository;




}
