package com.murilo.cursomc.model.estado.repository;

import com.murilo.cursomc.model.estado.entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EstadoRepository extends JpaRepository<Estado, Integer> {
    @Transactional(readOnly=true)
    public List<Estado> findAllByOrderByNome();

}
