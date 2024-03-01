package com.senior.exemplo.entities;

import com.senior.exemplo.commons.AEntity;
import jakarta.persistence.*;

@Entity
public class ItemPedido extends AEntity {

    @Column(name = "nome")
    private String nome;

    @Column(name = "preco_item_unitario")
    private Long preco;

    @Column(name = "preco_item_total")
    private Long precoItemTotal;
    @Column(name = "quantidade")
    private Long quantidade;

    @ManyToOne
    @JoinColumn(name = "pedido_id",
            referencedColumnName = "ID",
            foreignKey = @ForeignKey(name = "FK_PEDIDO_ID")
    )
    private Pedido pedido;

    @Column(name = "preco_formatado_unitario")
    private String precoFormatadoUnitario;

    @Column(name = "preco_formatado_total")
    private String precoFormatadoTotal;


    public Long getPreco() {
        return preco;
    }

    public void setPreco(Long preco) {
        this.preco = preco;

    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public String getPrecoFormatadoUnitario() {
        return precoFormatadoUnitario;
    }

    public void setPrecoFormatadoUnitario(String precoFormatadoUnitario) {
        this.precoFormatadoUnitario = precoFormatadoUnitario;
    }

    public float getPrecoItemTotal() {
        return precoItemTotal;
    }

    public void setPrecoItemTotal(Long precoItemTotal) {
        this.precoItemTotal = precoItemTotal;
    }

    public String getPrecoFormatadoTotal() {
        return precoFormatadoTotal;
    }

    public void setPrecoFormatadoTotal(String precoFormatadoTotal) {
        this.precoFormatadoTotal = precoFormatadoTotal;
    }


}
