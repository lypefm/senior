package com.senior.exemplo.controllers;

import com.senior.exemplo.service.ItemPedidoService;
import com.senior.exemplo.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PedidoListaController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ItemPedidoService itemPedidoService;

    @GetMapping("/")
    public String visualizarPedidos(Model model){

        model.addAttribute("pedidos", pedidoService.buscarPedidos());
        model.addAttribute("itemsPedido", itemPedidoService.pegarTodos());
        return "visualizarPedidos";
    }
}
