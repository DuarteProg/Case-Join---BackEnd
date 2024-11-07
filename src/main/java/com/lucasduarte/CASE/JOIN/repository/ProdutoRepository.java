package com.lucasduarte.CASE.JOIN.repository;

import com.lucasduarte.CASE.JOIN.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
