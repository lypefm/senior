package com.senior.exemplo.repository;

import com.senior.exemplo.entities.Pedido;
import org.springframework.data.repository.CrudRepository;

public interface PedidoRepository extends CrudRepository<Pedido, Long> {
}
