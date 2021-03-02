package com.murilo.cursomc.domain.cliente.controller;

import com.murilo.cursomc.domain.categoria.service.CategoriaService;
import com.murilo.cursomc.domain.cliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {
    @Autowired
    private ClienteService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok().body(service.buscar(id));
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return null;
    }

}

