package com.senior.exemplo;

import com.senior.exemplo.entities.Pedido;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class ExemploApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExemploApplication.class, args);
	}

}
