package com.example.crud.service;

import com.example.crud.model.Personagem;
import com.example.crud.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonagemService {

    @Autowired
    private PersonagemRepository personagemRepository;

    public Personagem criarPersonagem(Personagem personagem) {
        if(personagem.getForcaBase()+ personagem.getDefesaBase() !=10){
            throw new IllegalArgumentException("Forca + Defesa deve dar 10");
        }
        return personagemRepository.save(personagem);
    }

    public Personagem atualizarNome(Long id, String nomeNovo) {
           personagemRepository.atualizarNome(id, nomeNovo);
           return personagemRepository.findById(id).orElseThrow();
    }
}
