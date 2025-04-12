package com.example.crud.repository;

import com.example.crud.model.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonagemRepository  extends JpaRepository<Personagem, Long> {

    @Modifying
    @Query("UPDATE Personagem p SET p.nomeAventureiro = :novoNome WHERE p.id = :id AND p.classe = 'Guerreiro'")
    void atualizarNome(@Param("id") Long id, @Param("novoNome") String novoNome);

    @Query("SELECT COUNT(i) > 0 FROM ItemMagico i WHERE i.personagem.id = :personagemId AND i.tipoItem = 'AMULETO'")
    boolean possuiAmuleto(@Param("personagemId") Long personagemId);
}
