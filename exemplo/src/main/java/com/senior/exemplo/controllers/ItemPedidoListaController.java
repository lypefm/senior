package com.senior.exemplo.controllers;

import com.senior.exemplo.service.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ItemPedidoListaController {
    @Autowired
    private ItemPedidoService itemPedidoService;
    @GetMapping("/listaItems/{id}")
    public String visualizarPedidos(@PathVariable Long id, Model model){
        model.addAttribute("itemsPedido", itemPedidoService.itemPedidoPorPedidoId(id));
        return "visualizarItems";
    }
}
