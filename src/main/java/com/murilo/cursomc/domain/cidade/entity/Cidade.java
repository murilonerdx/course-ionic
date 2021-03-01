package com.murilo.cursomc.domain.cidade.entity;

import com.murilo.cursomc.domain.estado.entity.Estado;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Cidade implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;

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
