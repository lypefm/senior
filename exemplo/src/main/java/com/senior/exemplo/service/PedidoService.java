package com.senior.exemplo.service;

import com.senior.exemplo.entities.Pedido;
import com.senior.exemplo.repository.PedidoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;
    @Transactional
    public Pedido salvar(Pedido pedido){
        return repository.save(pedido);
    }

    @Transactional
    public Iterable<Pedido> buscarPedidos(){
        return repository.findAll();
    }
}
