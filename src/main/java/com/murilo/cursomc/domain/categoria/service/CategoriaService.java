package com.murilo.cursomc.domain.categoria.service;

import com.murilo.cursomc.domain.categoria.entity.Categoria;
import com.murilo.cursomc.domain.categoria.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public Categoria buscar(Integer id){
        return repository.getOne(id);
    }
}
