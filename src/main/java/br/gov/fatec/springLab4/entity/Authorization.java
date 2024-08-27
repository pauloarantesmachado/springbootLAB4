package br.gov.fatec.springLab4.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "aut_autorizacao")
public class Authorization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aut_id")
    private Long id;

    @Column(name = "aut_nome")
    private String nome;

    @ManyToMany(mappedBy = "autorizacoes")
    private Set<User> usuarios;
}
