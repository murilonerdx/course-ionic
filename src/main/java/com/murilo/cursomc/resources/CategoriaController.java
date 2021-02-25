package com.murilo.cursomc.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/v1/categoria")
public class CategoriaController {

    @RequestMapping(method = RequestMethod.GET)
    public String Categoria(){
        return "Criando Projeto";
    }


}
