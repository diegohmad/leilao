package br.edu.iftm.leilao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.leilao.model.Lance;
import br.edu.iftm.leilao.service.LanceService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/lance")
public class LanceController {
    // {DELETE [/lance/{id}]}: delete(Long)
    // {GET [/lance/{id}]}: lance(Long)
    // {PUT [/lance/{id}]}: atualiza(Long,Lance)
    // {GET [/lance]}: lances()

    @Autowired
    private LanceService service;

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    public Lance lance(@PathVariable Long id) {
       return service.busca(id);
    }

    @PutMapping("/{id}")
    public Lance atualiza(@PathVariable Long id,@RequestBody Lance lance) {
        return service.atualiza(id, lance);
    }

    @GetMapping
    public List<Lance> lances() {
       return service.lances();
    }

    @PostMapping
    public ResponseEntity<Lance> criarLance(@RequestBody Lance lance) {
        Lance novoLance = service.salva(lance);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoLance);
    }

}
