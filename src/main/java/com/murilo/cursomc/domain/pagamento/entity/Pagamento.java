package com.murilo.cursomc.domain.pagamento.entity;

import com.murilo.cursomc.domain.pagamento.enums.EstadoPagamento;
import com.murilo.cursomc.domain.pedido.entity.Pedido;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pagamento implements Serializable {
    @Id
    private Integer id;
    private EstadoPagamento estado;

    @OneToOne()
    @JoinColumn(name="pedido_id")
    @MapsId
    private Pedido pedido;

    public Pagamento(Integer id, EstadoPagamento estado, Pedido pedido) {
        this.id = id;
        this.estado = estado;
        this.pedido = pedido;
    }

    public Pagamento(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EstadoPagamento getEstado() {
        return estado;
    }

    public void setEstado(EstadoPagamento estado) {
        this.estado = estado;
    }
}
