package com.senior.exemplo.controllers;

import com.senior.exemplo.entities.ItemPedido;
import com.senior.exemplo.entities.Pedido;
import com.senior.exemplo.service.ItemPedidoService;
import com.senior.exemplo.service.PedidoService;
import com.senior.exemplo.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.Objects;

@Controller
public class PedidoCadastroController {

    @Autowired
    private PedidoService pedidoService;
    @Autowired
    private ItemPedidoService itemPedidoService;

    private Pedido pedido = new Pedido();
    private ItemPedido itemPedido = new ItemPedido();

    private Long precoTotal = 0L;

    @GetMapping("/telacadastro")
    public String telaCadastro(Model model, @RequestParam(name = "isReset", required = false) boolean isReset){
        if(isReset){
            this.itemPedido = new ItemPedido();
            this.pedido = new Pedido();
            this.precoTotal = 0L;
        }

        model.addAttribute("itemPedido", itemPedido);
        model.addAttribute("pedido", pedido);
        model.addAttribute("precoTotal", this.precoTotal);

        return "telaCadastroPedido";
    }

    @PostMapping("/adicionarItem")
    public String adicionarItem(@ModelAttribute("Pedido") Pedido pedido, @ModelAttribute("itemPedido") ItemPedido itemPedido, Model model){

        itemPedido.setPedido(this.pedido);
        itemPedido.setDataRegistro(OffsetDateTime.now());
        itemPedido.setPrecoFormatadoUnitario(StringUtils.formatarPreco(itemPedido.getPreco()));
        itemPedido.setPrecoFormatadoTotal(StringUtils.formatarPreco(itemPedido.getPreco() * itemPedido.getQuantidade()));
        this.pedido.getItemsPedido().add(itemPedido);

        if(Objects.nonNull(pedido.getCliente()))
        {
            this.pedido.setCliente(pedido.getCliente());
        }

        if(Objects.nonNull(pedido.getNome()))
        {
            this.pedido.setNome(pedido.getNome());
        }

        if(Objects.nonNull(pedido.getNome()))
        {
            this.pedido.setCondicaoPagamento(pedido.getCondicaoPagamento());
        }
        this.precoTotal = precoTotal + (itemPedido.getPreco() * itemPedido.getQuantidade());


        model.addAttribute("precoTotal", this.precoTotal);
        model.addAttribute("pedido", this.pedido);
        return "redirect:telacadastro";
    }

    @PostMapping("/salvarPedido")
    public String salvarPedido() throws Exception {
        if (Objects.nonNull(this.pedido)){
            if(this.pedido.getItemsPedido().isEmpty()){
                throw new Exception("Erro, necessário ter items no pedido");
            }
            this.pedido.setDataRegistro(OffsetDateTime.now());
            this.pedido.setPrecoTotal(StringUtils.formatarPreco(this.precoTotal));
            pedidoService.salvar(this.pedido);
        }
        return "redirect:/telacadastro?isReset=true";
    }


    @PostMapping("/limparItemsPedido")
    public String limparItems() {
        if (Objects.nonNull(this.pedido)){
            this.pedido.getItemsPedido().clear();
            this.precoTotal = 0L;
        }
        return "redirect:/telacadastro";
    }
}
