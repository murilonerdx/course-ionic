package com.murilo.cursomc.model.produto.repository;

import com.murilo.cursomc.model.produto.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
