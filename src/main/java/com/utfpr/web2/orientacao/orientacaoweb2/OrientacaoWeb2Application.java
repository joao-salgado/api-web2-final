package com.utfpr.web2.orientacao.orientacaoweb2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class OrientacaoWeb2Application {

	public static void main(String[] args) {
		SpringApplication.run(OrientacaoWeb2Application.class, args);
	}
}
