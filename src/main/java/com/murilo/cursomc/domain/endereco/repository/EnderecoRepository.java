package com.murilo.cursomc.domain.endereco.repository;

import com.murilo.cursomc.domain.endereco.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
}
