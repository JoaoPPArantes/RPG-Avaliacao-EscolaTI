package com.example.crud.model;

import com.example.crud.enums.TipoItem;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class ItemMagico {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idItem;

    @NotBlank(message = "Nome do item é obrigatório")
    private String nomeItem;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Tipo do item é obrigatório")
    private TipoItem tipoItem;

    @Min(0)
    @Max(10)
    private int forca;

    @Min(0)
    @Max(10)
    private int defesa;

    @ManyToOne
    @JoinColumn(name = "personagem_id")
    private Personagem personagem;

    public Long getIdItem() {
        return idItem;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public TipoItem getTipoItem() {
        return tipoItem;
    }

    public void setTipoItem(TipoItem tipoItem) {
        this.tipoItem = tipoItem;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }
}
