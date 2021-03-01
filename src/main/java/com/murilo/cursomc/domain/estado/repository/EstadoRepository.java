package com.murilo.cursomc.domain.estado.repository;

import com.murilo.cursomc.domain.estado.entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado, Integer> {
}
