package com.murilo.cursomc.model.estado.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.murilo.cursomc.model.cidade.entity.Cidade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Estado implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;

    @JsonManagedReference
    @OneToMany()
    private List<Cidade> cidades = new ArrayList<>();

    public Estado(){
    }

    public Estado(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}