package com.lucasduarte.CASE.JOIN.service;

import com.lucasduarte.CASE.JOIN.dto.ProdutoDTO;
import com.lucasduarte.CASE.JOIN.model.Categoria;
import com.lucasduarte.CASE.JOIN.model.Produto;
import com.lucasduarte.CASE.JOIN.repository.CategoriaRepository;
import com.lucasduarte.CASE.JOIN.repository.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto atualizar(Long produtoId, Produto produto) {
        Produto produtoSalvo = produtoRepository.findOne(produtoId);
        if (produtoSalvo == null) {
            throw new EmptyResultDataAccessException(1);
        }
        BeanUtils.copyProperties(produto, produtoSalvo, "id");
        return produtoRepository.save(produtoSalvo);
    }

    public List<ProdutoDTO> listarProdutos() {
        List<Produto> produtos = produtoRepository.findAll();
        return produtos.stream()
                .map(produto -> new ProdutoDTO(
                        produto.getId(),
                        produto.getNome(),
                        produto.getDescricao(),
                        produto.getPreco(),
                        produto.getCategoria().getNome()
                ))
                .collect(Collectors.toList());
    }
}
