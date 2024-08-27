package br.gov.fatec.springLab4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.fatec.springLab4.entity.Anotation;
import br.gov.fatec.springLab4.service.AnotationService;

@RestController
@RequestMapping(value = "anotacao")
@CrossOrigin
public class AnotationController {

    @Autowired
    private AnotationService anotationService;

    @GetMapping
    public List<Anotation> buscarTodos(){
        return anotationService.todas();
    }
    
}
