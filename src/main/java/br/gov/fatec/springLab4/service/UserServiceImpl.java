package br.gov.fatec.springLab4.service;

import java.beans.Transient;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.gov.fatec.springLab4.entity.User;
import br.gov.fatec.springLab4.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;


    @Transient
    public User novo(User usuario){
        if(usuario == null ||
                usuario.getNome() == null ||
                usuario.getNome().isBlank() ||
                usuario.getSenha() == null ||
                usuario.getSenha().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados de usuário inválidos!");
        }
        return repository.save(usuario);
    }

    public List<User> buscarTodos(){
       return repository.findAll();
    }

    public User buscarPorId(Long id){
        Optional<User> usuarioOp = repository.findById(id);
        if(usuarioOp.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado!");
        }
        return usuarioOp.get();
    }
    
}
