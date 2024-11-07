package com.lucasduarte.CASE.JOIN.repository;

import com.lucasduarte.CASE.JOIN.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
