package com.murilo.cursomc.model.cidade.dto;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class CidadeUpdate implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotEmpty(message="Preenchimento obrigatório")
    @Size(min=2, max=80, message="O tamanho deve ser entre 2 e 80 caracteres")
    private String name;

    public CidadeUpdate() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}