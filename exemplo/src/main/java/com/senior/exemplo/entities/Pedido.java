package com.senior.exemplo.entities;

import com.senior.exemplo.commons.AEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Pedido extends AEntity {
    @Column(name = "cliente")
    private String cliente;
    @Column(name = "condicao_de_pagamento")
    private String nome;

    @Column(name = "preco_total")
    private String precoTotal;

    @Column(name = "condicao_pagamento")
    private String condicaoPagamento;
    @OneToMany(
            mappedBy = "pedido",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    private List<ItemPedido> itemsPedido = new ArrayList<>();


    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<ItemPedido> getItemsPedido() {
        return itemsPedido;
    }

    public String getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(String precoTotal) {
        this.precoTotal = precoTotal;
    }

    public String getCondicaoPagamento() {
        return condicaoPagamento;
    }

    public void setCondicaoPagamento(String condicaoPagamento) {
        this.condicaoPagamento = condicaoPagamento;
    }
}
