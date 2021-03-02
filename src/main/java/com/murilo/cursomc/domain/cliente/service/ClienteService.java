package com.murilo.cursomc.domain.cliente.service;

import com.murilo.cursomc.domain.categoria.entity.Categoria;
import com.murilo.cursomc.domain.categoria.exceptions.ObjectNotFoundException;
import com.murilo.cursomc.domain.categoria.repository.CategoriaRepository;
import com.murilo.cursomc.domain.cliente.entity.Cliente;
import com.murilo.cursomc.domain.cliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente buscar(Integer id){
        Cliente obj = repository.getOne(id);
        if(obj == null){
            throw new ObjectNotFoundException("Not found");
        }
        return obj;
    }
}
