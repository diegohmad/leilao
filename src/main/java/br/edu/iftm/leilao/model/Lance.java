package br.edu.iftm.leilao.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
public class Lance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double valor;

    @ManyToOne
    private Participante participante;

    public Lance(Double valor, Participante participante, ItemDeLeilao itemDeLeilao) {
        super();
        this.valor = valor;
        this.participante = participante;
    }
}

