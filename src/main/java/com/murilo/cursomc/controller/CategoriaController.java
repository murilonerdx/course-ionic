package com.murilo.cursomc.controller;

import com.murilo.cursomc.model.categoria.dto.CategoriaDTO;
import com.murilo.cursomc.model.categoria.entity.Categoria;
import com.murilo.cursomc.model.categoria.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value="/categorias")
public class CategoriaController {

    private final CategoriaService service;

    @Autowired
    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Categoria> find(@PathVariable Integer id) {
        Categoria obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody Categoria obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Categoria> update(@PathVariable Integer id, @RequestBody Categoria obj) {
        obj.setId(id);
        service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<CategoriaDTO>> findAll(){
        List<Categoria> listaCategoria = service.findAll();
        List<CategoriaDTO> listaDTO = listaCategoria.stream().map(CategoriaDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listaDTO);
    }


}
