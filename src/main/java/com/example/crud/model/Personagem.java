package com.example.crud.model;


import com.example.crud.enums.Classe;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Nome Aventureiro é obrigatório")
    private String nomeAventureiro;

    @Enumerated(EnumType.STRING)
    private Classe classe;

    @PositiveOrZero(message = "Level deve ser 0 ou maior")
    private int level;

    @PositiveOrZero
    private int forcaBase;

    @PositiveOrZero
    private int defesaBase;

    @OneToMany(mappedBy = "personagem", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemMagico> itens = new ArrayList<>();


    public Long getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeAventureiro() {
        return nomeAventureiro;
    }

    public void setNomeAventureiro(String nomeAventureiro) {
        this.nomeAventureiro = nomeAventureiro;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getForcaBase() {
        return forcaBase;
    }

    public void setForcaBase(int forcaBase) {
        this.forcaBase = forcaBase;
    }

    public int getDefesaBase() {
        return defesaBase;
    }

    public void setDefesaBase(int defesaBase) {
        this.defesaBase = defesaBase;
    }

    public List<ItemMagico> getItens() {
        return itens;
    }

    public void setItens(List<ItemMagico> itens) {
        this.itens = itens;
    }

    // Cálculo total somando os itens mágicos
    public int getForcaTotal() {
        return forcaBase + itens.stream().mapToInt(ItemMagico::getForca).sum();
    }

    public int getDefesaTotal() {
        return defesaBase + itens.stream().mapToInt(ItemMagico::getDefesa).sum();
    }
}
