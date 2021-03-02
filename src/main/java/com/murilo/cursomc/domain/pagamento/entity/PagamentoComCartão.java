package com.murilo.cursomc.domain.pagamento.entity;

import com.murilo.cursomc.domain.pagamento.enums.EstadoPagamento;
import com.murilo.cursomc.domain.pedido.entity.Pedido;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class PagamentoComCartão extends Pagamento implements Serializable {
    private Integer numeroDeParcelas;

    public PagamentoComCartão(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroDeParcelas) {
        super(id, estado, pedido);
        this.numeroDeParcelas = numeroDeParcelas;
    }

    public PagamentoComCartão(Integer numeroDeParcelas) {
        this.numeroDeParcelas = numeroDeParcelas;
    }

    public PagamentoComCartão() {

    }

    public Integer getNumeroDeParcelas() {
        return numeroDeParcelas;
    }

    public void setNumeroDeParcelas(Integer numeroDeParcelas) {
        this.numeroDeParcelas = numeroDeParcelas;
    }
}
