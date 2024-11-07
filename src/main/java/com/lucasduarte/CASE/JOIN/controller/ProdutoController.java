package com.lucasduarte.CASE.JOIN.controller;

import com.lucasduarte.CASE.JOIN.dto.ProdutoDTO;
import com.lucasduarte.CASE.JOIN.model.Categoria;
import com.lucasduarte.CASE.JOIN.model.Produto;
import com.lucasduarte.CASE.JOIN.repository.CategoriaRepository;
import com.lucasduarte.CASE.JOIN.repository.ProdutoRepository;
import com.lucasduarte.CASE.JOIN.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<ProdutoDTO> listarProdutos(){
        return produtoService.listarProdutos();
    }

    @PostMapping
    public ResponseEntity<Produto> criarCategoria(@Valid @RequestBody Produto produto){
        Produto produtoSalvar = produtoRepository.save(produto);

        return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvar);
    }

    @DeleteMapping("/{produtoId}")
    public ResponseEntity<Void> removerCategoria(@PathVariable Long produtoId) {
        produtoRepository.delete(produtoId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{produtoId}")
    public ResponseEntity<Produto> atualizarProduto(
            @PathVariable Long produtoId,
            @Valid @RequestBody Produto produto) {
        Produto produtoSalvo = produtoService.atualizar(produtoId, produto);
        return ResponseEntity.status(HttpStatus.OK).body(produtoSalvo);
    }
}
