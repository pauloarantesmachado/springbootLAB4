package br.gov.fatec.springLab4.controller;

import java.util.List;

import br.gov.fatec.springLab4.entity.Views;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.fatec.springLab4.entity.User;
import br.gov.fatec.springLab4.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    
    @Autowired
    private UserService userService; 

    @GetMapping
    @JsonView(Views.UserInfo.class)
    public List<User> buscarTodos() {
        return userService.buscarTodos();
    }

    @PostMapping
    @JsonView(Views.UserInfo.class)
    public User novo(@RequestBody User usuario) {
        return userService.novo(usuario);
    }

    @GetMapping(value = "/{id}")
    @JsonView(Views.UserInfo.class)
    public User buscarPorId(@PathVariable("id") Long id) {
        return userService.buscarPorId(id);
    }
}
