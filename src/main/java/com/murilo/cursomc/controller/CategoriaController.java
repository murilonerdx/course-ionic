package com.murilo.cursomc.controller;

import com.murilo.cursomc.model.categoria.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value="/api/v1/categoria")
public class CategoriaController {

    private final CategoriaService service;

    @Autowired
    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable Integer id){
        try{
            return ResponseEntity.ok().body(service.buscar(id));
        }catch(RuntimeException e){
            e.printStackTrace();
        }
        return null;
    }


}
