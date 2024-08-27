package br.gov.fatec.springLab4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.fatec.springLab4.entity.Anotation;

public interface AnotationRepository extends JpaRepository<Anotation, Long>{
    
}
