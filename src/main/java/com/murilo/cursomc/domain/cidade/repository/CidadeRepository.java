package com.murilo.cursomc.domain.cidade.repository;

import com.murilo.cursomc.domain.cidade.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
}
