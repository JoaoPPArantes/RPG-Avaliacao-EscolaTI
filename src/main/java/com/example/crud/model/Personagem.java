package com.example.crud.model;


import com.example.crud.enums.Classe;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String nomeAventureiro;

    @Enumerated(EnumType.STRING)
    private Classe classe;

    private int level;
    private int forcaBase;
    private int defesaBase;


    @OneToMany(mappedBy = "personagem", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemMagico> itens = new ArrayList<>();

}
