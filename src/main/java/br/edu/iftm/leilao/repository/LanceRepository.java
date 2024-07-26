package br.edu.iftm.leilao.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.iftm.leilao.model.Lance;

@Repository
public interface LanceRepository extends CrudRepository<Lance, Long> {
    List<Lance> findByParticipanteId(Long id); 
    List<Lance> findByParticipanteIdAndValorGreaterThan(Long id, double valor);
}
