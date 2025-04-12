package com.example.crud.controller;


import com.example.crud.model.ItemMagico;
import com.example.crud.service.ItemMagicoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens")
public class ItemMagicoController {


    @Autowired
    private ItemMagicoService itemService;

    @Operation(summary = "Cadastrar item mágico")
    @PostMapping
    public ResponseEntity<ItemMagico> cadastrarItem(@org.springframework.web.bind.annotation.RequestBody ItemMagico item) {
        ItemMagico cadastrado = itemService.cadastrarItem(item);
        return new ResponseEntity<>(cadastrado, HttpStatus.CREATED);
    }

    @Operation(summary = "Listar todos os itens mágicos")
    @GetMapping
    public ResponseEntity<List<ItemMagico>> listarItens() {
        return ResponseEntity.ok(itemService.listarTodos());
    }

    @Operation(summary = "Buscar item mágico por ID")
    @GetMapping("/{id}")
    public ResponseEntity<ItemMagico> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(itemService.buscarPorId(id));
    }

    @Operation(summary = "Vincular um item a um personagem")
    @PutMapping("/{itemId}/personagem/{personagemId}")
    public ResponseEntity<ItemMagico> vincularItemAoPersonagem(@PathVariable Long itemId, @PathVariable Long personagemId) {
        ItemMagico itemVinculado = itemService.vincularItemAoPersonagem(itemId, personagemId);
        return ResponseEntity.ok(itemVinculado);
    }
    @Operation(summary = "Listar itens mágicos de um personagem")
    @GetMapping("/personagem/{personagemId}")
    public ResponseEntity<List<ItemMagico>> listarPorPersonagem(@PathVariable Long personagemId) {
        return ResponseEntity.ok(itemService.listarPorPersonagem(personagemId));
    }

    @Operation(summary = "Remover item mágico de um personagem")
    @DeleteMapping("/personagem/{personagemId}/{itemId}")
    public ResponseEntity<Void> removerItemDoPersonagem(@PathVariable Long personagemId,
                                                        @PathVariable Long itemId) {
        itemService.removerItemDoPersonagem(personagemId, itemId);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Buscar amuleto de um personagem")
    @GetMapping("/personagem/{personagemId}/amuleto")
    public ResponseEntity<ItemMagico> buscarAmuleto(@PathVariable Long personagemId) {
        ItemMagico amuleto = itemService.buscarAmuletoPorPersonagem(personagemId);
        if (amuleto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(amuleto);
    }
}
