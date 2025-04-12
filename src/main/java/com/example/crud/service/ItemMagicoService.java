package com.example.crud.service;

import com.example.crud.enums.TipoItem;
import com.example.crud.model.ItemMagico;
import com.example.crud.model.Personagem;
import com.example.crud.repository.ItemMagicoRepository;
import com.example.crud.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemMagicoService {


    @Autowired
    private ItemMagicoRepository itemMagicoRepository;

    @Autowired
    private PersonagemRepository personagemRepository;

    public ItemMagico cadastrarItem(ItemMagico item) {
        if (item.getForca() == 0 && item.getDefesa() == 0) {
            throw new IllegalArgumentException("Item não pode ter força e defesa igual a 0");
        }

        switch (item.getTipoItem()) {
            case ARMA:
                if (item.getDefesa() != 0) {
                    throw new IllegalArgumentException("Armas devem ter defesa igual a 0");
                }
                break;
            case ARMADURA:
                if (item.getForca() != 0) {
                    throw new IllegalArgumentException("Armaduras devem ter força igual a 0");
                }
                break;
        }

        return itemMagicoRepository.save(item);
    }

    public List<ItemMagico> listarTodos() {
        return itemMagicoRepository.findAll();
    }

    public ItemMagico buscarPorId(Long id) {
        return itemMagicoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Item Mágico não encontrado"));
    }

    public List<ItemMagico> listarPorPersonagem(Long personagemId) {
        return itemMagicoRepository.findByPersonagemId(personagemId);
    }

    public void removerItem(Long id) {
        itemMagicoRepository.deleteById(id);
    }

    @Transactional
    public ItemMagico vincularItemAoPersonagem(Long itemId, Long personagemId) {
        ItemMagico item = itemMagicoRepository.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("Item não encontrado"));

        Personagem personagem = personagemRepository.findById(personagemId)
                .orElseThrow(() -> new IllegalArgumentException("Personagem não encontrado"));

        if (item.getTipoItem() == TipoItem.AMULETO) {
            boolean jaTemAmuleto = personagem.getItens().stream()
                    .anyMatch(i -> i.getTipoItem() == TipoItem.AMULETO);
            if (jaTemAmuleto) {
                throw new IllegalArgumentException("O personagem já possui um amuleto");
            }
        }

        item.setPersonagem(personagem);
        return itemMagicoRepository.save(item);
    }

    public void removerItemDoPersonagem(Long personagemId, Long itemId) {
        ItemMagico item = buscarPorId(itemId);
        if (item.getPersonagem() == null || !item.getPersonagem().getId().equals(personagemId)) {
            throw new IllegalArgumentException("Este item não pertence ao personagem informado");
        }

        item.setPersonagem(null);
        itemMagicoRepository.save(item);
    }

    public ItemMagico buscarAmuletoPorPersonagem(Long personagemId) {
        return itemMagicoRepository.findByPersonagemId(personagemId).stream()
                .filter(item -> item.getTipoItem() == TipoItem.AMULETO)
                .findFirst()
                .orElse(null);
    }
}
