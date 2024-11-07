package com.lucasduarte.CASE.JOIN.service;

import com.lucasduarte.CASE.JOIN.model.Categoria;
import com.lucasduarte.CASE.JOIN.repository.CategoriaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria atualizar(Long categoriaId, Categoria categoria) {
        Categoria categoriaSalva = categoriaRepository.findOne(categoriaId);
        if (categoriaSalva == null) {
            throw new EmptyResultDataAccessException(1);
        }
        BeanUtils.copyProperties(categoria, categoriaSalva, "id");
        return categoriaRepository.save(categoriaSalva);
    }

}
