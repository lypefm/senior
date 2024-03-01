package com.senior.exemplo.service;

import com.senior.exemplo.entities.ItemPedido;
import com.senior.exemplo.repository.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPedidoService {
    @Autowired
    private ItemPedidoRepository repository;

    public List<ItemPedido> itemPedidoPorPedidoId(Long id){
        return repository.findByPedidoId(id);
    }

    public Iterable<ItemPedido> pegarTodos() {
       return repository.findAll();
    }
}
