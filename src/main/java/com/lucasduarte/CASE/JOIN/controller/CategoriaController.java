package com.lucasduarte.CASE.JOIN.controller;

import com.lucasduarte.CASE.JOIN.model.Categoria;
import com.lucasduarte.CASE.JOIN.repository.CategoriaRepository;
import com.lucasduarte.CASE.JOIN.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Categoria> criarCategoria(@Valid @RequestBody Categoria categoria) {
        Categoria categoriaSalvar = categoriaRepository.save(categoria);

        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalvar);
    }

    @DeleteMapping("/{categoriaId}")
    public ResponseEntity<Void> removerCategoria(@PathVariable Long categoriaId) {
        categoriaRepository.delete(categoriaId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{categoriaId}")
    public ResponseEntity<Categoria> atualizarCategoria(
            @PathVariable Long categoriaId,
            @Valid @RequestBody Categoria categoria) {
        Categoria categoriaSalva = categoriaService.atualizar(categoriaId, categoria);
        return ResponseEntity.status(HttpStatus.OK).body(categoriaSalva);
    }
}
