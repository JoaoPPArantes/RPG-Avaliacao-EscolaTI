package com.example.crud.model;

import com.example.crud.enums.TipoItem;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ItemMagico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    String idItem;
    String nomeItem;
    TipoItem tipoItem;
    String forcaBase;
    String defesaBase;
}
