package com.example.crud.repository;

import com.example.crud.model.ItemMagico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemMagicoRepository extends JpaRepository<ItemMagico, Long> {
    List<ItemMagico> findByPersonagemId(Long personagemId);
}
