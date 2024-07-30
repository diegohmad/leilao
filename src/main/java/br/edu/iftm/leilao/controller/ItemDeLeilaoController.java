package br.edu.iftm.leilao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.edu.iftm.leilao.model.ItemDeLeilao;
import br.edu.iftm.leilao.model.Lance;
import br.edu.iftm.leilao.service.ItemDeLeilaoService;

@RestController
@RequestMapping("/itemdeleilao")
public class ItemDeLeilaoController {

    @Autowired
    private ItemDeLeilaoService service;

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    public ItemDeLeilao get(@PathVariable Long id) {
        return service.get(id);
    }

    @PutMapping("/{id}")
    public ItemDeLeilao update(@PathVariable Long id, @RequestBody ItemDeLeilao item) {
        return service.update(id, item);
    }

    @PostMapping
    public ItemDeLeilao novo(@RequestBody ItemDeLeilao item) {
        return service.salva(item);
    }

    @GetMapping
    public List<ItemDeLeilao> itens() {
        return service.itens();
    }

    @PostMapping("/{id}/lance")
    public Lance registrarLance(@PathVariable Long id, @RequestBody Lance lance) {
        return service.registrarLance(id, lance);
    }

    @PatchMapping("/{id}/finalizar")
    public Lance finalizarLeilao(@PathVariable Long id) {
        return service.finalizarLeilao(id);
    }
}
