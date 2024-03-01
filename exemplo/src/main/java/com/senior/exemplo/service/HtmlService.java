package com.senior.exemplo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.IOException;
import java.io.StringWriter;

@Service
public class HtmlService {
    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ItemPedidoService itemPedidoService;

    public String generateHtmlReport() throws IOException {
        // Contexto Thymeleaf para renderizar o template
        Context context = new Context();
        context.setVariable("itemsPedido", itemPedidoService.pegarTodos());
        context.setVariable("pedidos", pedidoService.buscarPedidos());

        // Renderizar o template Thymeleaf
        StringWriter stringWriter = new StringWriter();
        templateEngine.process("relatorio", context, stringWriter);

        // Converter o conteúdo renderizado para CSV
        String htmlContent = stringWriter.toString();

        return htmlContent;
    }
}
