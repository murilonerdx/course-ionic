package com.murilo.cursomc.model.itemPedido.entity;


import com.murilo.cursomc.model.pedido.entity.Pedido;
import com.murilo.cursomc.model.produto.entity.Produto;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ItemPedido{
    @EmbeddedId
    private ItemPedidoPK id = new ItemPedidoPK();
    private Double desconto;
    private Integer quantidade;
    private Double preco;

    public ItemPedido(Pedido pedido, Produto produto, ItemPedidoPK id, Double desconto, Integer quantidade, Double preco) {
        super();
        id.setPedido(pedido);
        id.setProduto(produto);
        this.desconto = desconto;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public ItemPedido(ItemPedidoPK id, Double desconto, Integer quantidade, Double preco) {
        this.id = id;
        this.desconto = desconto;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public ItemPedido(){

    }

    public ItemPedidoPK getId() {
        return id;
    }

    public void setId(ItemPedidoPK id) {
        this.id = id;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Pedido getPedido(){
        return id.getPedido();
    }

    public Produto getProduto(){
        return id.getProduto();
    }

}
