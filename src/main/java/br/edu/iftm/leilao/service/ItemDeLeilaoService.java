package br.edu.iftm.leilao.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iftm.leilao.model.ItemDeLeilao;
import br.edu.iftm.leilao.model.Lance;
import br.edu.iftm.leilao.repository.ItemDeLeilaoRepository;
import br.edu.iftm.leilao.repository.LanceRepository;
import br.edu.iftm.leilao.repository.ParticipanteRepository;

@Service
public class ItemDeLeilaoService {

    @Autowired
    private ItemDeLeilaoRepository repo;
    
    @Autowired
    private LanceRepository lanceRepo;
    
    @Autowired
    private ParticipanteRepository participanteRepo;

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public ItemDeLeilao get(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Item não encontrado"));
    }

    public ItemDeLeilao update(Long id, ItemDeLeilao item) {
        item.setId(id);
        return repo.save(item);
    }

    public ItemDeLeilao salva(ItemDeLeilao item) {
        return repo.save(item);
    }

    public List<ItemDeLeilao> itens() {
        List<ItemDeLeilao> lista = new ArrayList<>();
        repo.findAll().forEach(lista::add);
        return lista;
    }
    
    public Lance registrarLance(Long itemId, Lance lance) {
        ItemDeLeilao item = get(itemId);

        if (item.isLeilaoAberto()) {
            lance.setParticipante(participanteRepo.findById(lance.getParticipante().getId())
                .orElseThrow(() -> new RuntimeException("Participante não encontrado")));
            
            lanceRepo.save(lance);
            item.recebeLance(lance);
            
            if (item.getLanceVencedor() == null || lance.getValor() > item.getLanceVencedor().getValor()) {
                item.setLanceVencedor(lance);
            }

            return lanceRepo.save(lance);
        } else {
            throw new RuntimeException("Leilão fechado, não é possível registrar o lance.");
        }
    }

    public Lance finalizarLeilao(Long itemId) {
        ItemDeLeilao item = get(itemId);
        
        if (item.isLeilaoAberto()) {
            item.setLeilaoAberto(false);
            repo.save(item);
            return item.getLanceVencedor();
        } else {
            throw new RuntimeException("Leilão já está fechado.");
        }
    }
    
}
