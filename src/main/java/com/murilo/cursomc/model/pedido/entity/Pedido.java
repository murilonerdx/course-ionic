package com.murilo.cursomc.model.pedido.entity;

import com.murilo.cursomc.model.cliente.entity.Cliente;
import com.murilo.cursomc.model.endereco.entity.Endereco;
import com.murilo.cursomc.model.pagamento.entity.Pagamento;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Pedido implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date instante;

    @OneToOne(cascade= CascadeType.ALL, mappedBy = "pedido")
    private Pagamento pagamento;

    @ManyToOne()
    @JoinColumn(name="cliente_id")
    private Cliente cliente;

    @ManyToOne()
    @JoinColumn(name="endereco_de_entrega_id")
    private Endereco enderecoDeEntrega;

    public Pedido(Integer id, Date instante) {
        this.id = id;
        this.instante = instante;
    }

    public Pedido(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getInstante() {
        return instante;
    }

    public void setInstante(Date instante) {
        this.instante = instante;
    }
}
