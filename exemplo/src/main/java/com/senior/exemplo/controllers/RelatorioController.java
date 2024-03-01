package com.senior.exemplo.controllers;

import com.senior.exemplo.service.HtmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Controller
public class RelatorioController {
    @Autowired
    private HtmlService htmlService;
    @GetMapping(value = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<byte[]> downloadHtml() throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("filename", "relatorio.html");
        return ResponseEntity.ok().headers(headers).body(htmlService.generateHtmlReport().getBytes(StandardCharsets.UTF_8));
    }
}
