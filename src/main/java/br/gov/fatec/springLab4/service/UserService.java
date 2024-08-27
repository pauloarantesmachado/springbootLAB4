package br.gov.fatec.springLab4.service;

import java.util.List;
import br.gov.fatec.springLab4.entity.User;

public interface UserService {

    public User novo(User usuario);

    public List<User> buscarTodos();

    public User buscarPorId(Long id);
    
}
