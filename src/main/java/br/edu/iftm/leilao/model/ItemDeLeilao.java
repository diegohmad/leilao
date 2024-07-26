package br.edu.iftm.leilao.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class ItemDeLeilao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private double valorMinimo;
    private boolean leilaoAberto;

    @OneToMany
    @Getter(lombok.AccessLevel.NONE)
    @Setter(lombok.AccessLevel.NONE)
    private List<Lance> lancesRecebidos = new ArrayList<Lance>();

    @OneToOne
    private Lance lanceVencedor;

    public ItemDeLeilao() {
        super();
    }

    public ItemDeLeilao(String nome, double valorMinimo, boolean leilaoAberto) {
        super();
        this.nome = nome;
        this.valorMinimo = valorMinimo;
        this.leilaoAberto = leilaoAberto;
    }

    public void recebeLance(Lance lance) {
        if (lance.getValor() >= this.valorMinimo) {
            this.lancesRecebidos.add(lance);
        }
    }
}
