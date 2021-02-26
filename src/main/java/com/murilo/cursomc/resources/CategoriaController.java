package com.murilo.cursomc.resources;

import com.murilo.cursomc.domain.categoria.service.CategoriaService;
import javassist.NotFoundException;
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
