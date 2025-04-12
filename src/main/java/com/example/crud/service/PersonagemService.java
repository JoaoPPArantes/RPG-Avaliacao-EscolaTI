package com.example.crud.service;

import com.example.crud.model.Personagem;
import com.example.crud.repository.PersonagemRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonagemService {

    @Autowired
    private PersonagemRepository personagemRepository;

    public Personagem criarPersonagem(Personagem personagem) {
        if (personagem.getForcaBase() + personagem.getDefesaBase() != 10) {
            throw new IllegalArgumentException("A soma de força base e defesa base deve ser igual a 10");
        }
        return personagemRepository.save(personagem);
    }

    public Personagem buscarPorId(Long id) {
        return personagemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Personagem não encontrado"));
    }

    public List<Personagem> listarPersonagens() {
        return personagemRepository.findAll();
    }

    @Transactional
    public Personagem atualizarNomeAventureiro(Long id, String novoNome) {
        personagemRepository.atualizarNome(id, novoNome);
        return personagemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Personagem não encontrado"));
    }

    public void removerPersonagem(Long id) {
        personagemRepository.deleteById(id);
    }
}
