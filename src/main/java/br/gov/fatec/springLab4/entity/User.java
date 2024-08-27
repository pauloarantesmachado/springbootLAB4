package br.gov.fatec.springLab4.entity;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.*;

@Entity
@Table(name="usr_usuario")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="usr_id")
    @JsonView(Views.UserInfo.class)
    private Long id;

    @Column(name="usr_nome")
    @JsonView(Views.UserInfo.class)
    private String nome;

    @Column(name="usr_senha")
    private String senha;

    @OneToMany(mappedBy = "usuario")
    private List<Anotation> anotation;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "uau_usuario_autorizacao",
            joinColumns = { @JoinColumn(name = "usr_id")},
            inverseJoinColumns = { @JoinColumn(name = "aut_id")})
    private Set<Authorization> autorizacoes;

    public User(){

    }

    public User(String nome, String senha){
        this.nome = nome;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
