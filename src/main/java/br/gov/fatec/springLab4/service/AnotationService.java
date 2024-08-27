package br.gov.fatec.springLab4.service;

import java.util.List;

import br.gov.fatec.springLab4.entity.Anotation;

public interface AnotationService {

    public List<Anotation> todas();

    public Anotation nova(Anotation anotacao);

}
