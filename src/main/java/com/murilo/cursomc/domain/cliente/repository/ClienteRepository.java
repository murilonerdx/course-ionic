package com.murilo.cursomc.domain.cliente.repository;

import com.murilo.cursomc.domain.cliente.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
