package com.senior.exemplo.repository;

import com.senior.exemplo.entities.ItemPedido;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemPedidoRepository extends CrudRepository<ItemPedido, Long> {
    List<ItemPedido> findByPedidoId(Long id);
}
