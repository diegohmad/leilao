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

import br.edu.iftm.leilao.model.ItemDeLeilao;
import br.edu.iftm.leilao.service.ItemDeLeilaoService;

@RestController
public class ItemDeLeilaoController {


//     {DELETE [/itemdeleilao/{id}]}: delete(Long)
//     {GET [/itemdeleilao/{id}]}: item(Long)
//     {PUT [/itemdeleilao/{id}]}: atualiza(Long,ItemDeLeilao)
//     {POST [/itemdeleilao]}: novo(ItemDeLeilao)
//     {GET [/itemdeleilao]}: itens()

    @Autowired
    private ItemDeLeilaoService service;

    @DeleteMapping("/{id}")
    public void delete (@PathVariable Long id) {
        service.delete(id);
    }    

    @GetMapping("/{id}")
    public ItemDeLeilao get (@PathVariable Long id) {
        return service.get(id);
    }
    
    @PutMapping("/{id}")
    public ItemDeLeilao update (@PathVariable Long id, @RequestBody ItemDeLeilao item) {
        return service.update(id, item);
    }

    @PostMapping
    public ItemDeLeilao novo (ItemDeLeilao item) {
        return service.salva(item);
    }

    @GetMapping
    public List<ItemDeLeilao> itens () {
        return service.itens();
    }
}
