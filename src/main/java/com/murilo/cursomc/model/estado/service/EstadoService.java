package com.murilo.cursomc.model.estado.service;


import java.util.List;

import com.murilo.cursomc.model.estado.entity.Estado;
import com.murilo.cursomc.model.estado.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EstadoService {

    @Autowired
    private EstadoRepository repo;

    public List<Estado> findAll() {
        return repo.findAllByOrderByNome();
    }
}