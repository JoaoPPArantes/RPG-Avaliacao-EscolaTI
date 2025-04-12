package com.example.crud.controller;


import com.example.crud.model.Personagem;
import com.example.crud.service.PersonagemService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personagens")
public class PersonagemController {
    @Autowired
    private PersonagemService personagemService;

    @Operation(summary = "Cadastrar Personagem")
    @PostMapping
    public ResponseEntity<Personagem> criarPersonagem(@RequestBody Personagem personagem) {
        Personagem criado = personagemService.criarPersonagem(personagem);
        return new ResponseEntity<>(criado, HttpStatus.CREATED);
    }

    @Operation(summary = "Listar todos os Personagens")
    @GetMapping
    public ResponseEntity<List<Personagem>> listarPersonagens() {
        return ResponseEntity.ok(personagemService.listarPersonagens());
    }

    @Operation(summary = "Buscar Personagem por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Personagem> buscarPersonagem(@PathVariable Long id) {
        Personagem personagem = personagemService.buscarPorId(id);
        return ResponseEntity.ok(personagem);
    }

    @Operation(summary = "Atualizar Nome Aventureiro de um Guerreiro")
    @PutMapping("/{id}/nomeAventureiro")
    public ResponseEntity<Personagem> atualizarNome(
            @PathVariable Long id,
            @RequestParam String novoNome) {
        Personagem atualizado = personagemService.atualizarNomeAventureiro(id, novoNome);
        return ResponseEntity.ok(atualizado);
    }

    @Operation(summary = "Remover Personagem por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerPersonagem(@PathVariable Long id) {
        personagemService.removerPersonagem(id);
        return ResponseEntity.noContent().build();
    }
}
