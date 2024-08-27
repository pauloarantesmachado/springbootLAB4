package br.gov.fatec.springLab4.service;

import java.beans.Transient;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.gov.fatec.springLab4.entity.Anotation;
import br.gov.fatec.springLab4.repository.AnotationRepository;
@Service
public class AnotationServiceImpl implements AnotationService {

    @Autowired
    private AnotationRepository anotationRepository;

    @Autowired
    private UserService userService;

    @Transient
    public List<Anotation> todas() {
        return anotationRepository.findAll();
    }


    @Transient
    public Anotation nova(Anotation anotacao) {
        if(anotacao == null ||
                anotacao.getTexto() == null ||
                anotacao.getTexto().isBlank()||
                anotacao.getUsuario() == null ||
                anotacao.getUsuario().getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos!");
        }
        if(anotacao.getData() == null) {
            anotacao.setData(LocalDateTime.now());
        }
        anotacao.setUsuario(userService
            .buscarPorId(anotacao.getUsuario().getId()));
        return anotationRepository.save(anotacao);
    }
    
}
