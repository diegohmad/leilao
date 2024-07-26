package br.edu.iftm.leilao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.leilao.model.Participante;
import br.edu.iftm.leilao.service.ParticipanteService;

@RestController
public class ParticipanteController {
    
    // {DELETE [/participante/{id}]}: delete(Long)
    // {GET [/participante/{id}]}: participante(Long)
    // {PUT [/participante/{id}]}: atualiza(Long,Participante)
    // {POST [/participante]}: novo(Participante)
    // {GET [/participante]}: participantes()


    @Autowired
    private ParticipanteService service;

    @DeleteMapping("/{id}")
    public void delete (@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    public Participante busca(@PathVariable Long id) {
        return service.busca(id);
    }

    @PutMapping("/{id}")
    public Participante atualiza (@PathVariable Long id, @RequestBody Participante participante) {
        return service.atualiza(id, participante);
    }

    @PostMapping
    public Participante novo ( Participante participante) {
       return service.salva(participante);
    }

    @GetMapping
    public List<Participante> participantes () {
        return service.busca();
    }
}
