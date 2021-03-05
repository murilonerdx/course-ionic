package com.murilo.cursomc.model.categoria.service;

import com.murilo.cursomc.model.categoria.entity.Categoria;
import com.murilo.cursomc.model.categoria.exceptions.ObjectNotFoundException;
import com.murilo.cursomc.model.categoria.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repository;

    public Categoria buscar(Integer id) {
        Optional<Categoria> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }
}
