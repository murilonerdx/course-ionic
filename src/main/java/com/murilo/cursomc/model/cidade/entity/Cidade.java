package com.murilo.cursomc.model.cidade.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.murilo.cursomc.model.estado.entity.Estado;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Cidade implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;

    @JsonManagedReference
    @ManyToOne()
    @JoinColumn(name="estado_id")
    private Estado estado;


    public Cidade(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Cidade() {

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
