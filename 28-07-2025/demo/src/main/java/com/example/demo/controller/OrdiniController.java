package com.example.demo.controller;

import com.example.demo.services.OrdineServiceOLD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/ordini")
public class OrdiniController {
    @Autowired
    private OrdineServiceOLD service;


}
