package com.lucasduarte.CASE.JOIN.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProdutoDTO {
    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private String categoriaNome;
    
    
    public ProdutoDTO(Long id, String nome, String descricao, BigDecimal preco, String categoriaNome) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoriaNome = categoriaNome;
    }
}
