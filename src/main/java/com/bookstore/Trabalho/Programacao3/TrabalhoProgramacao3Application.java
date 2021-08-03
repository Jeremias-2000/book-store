package com.bookstore.Trabalho.Programacao3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.cache.annotation.EnableCaching;


import org.springframework.data.web.config.EnableSpringDataWebSupport;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@SpringBootApplication
@EnableSwagger2
@EnableCaching
@EnableSpringDataWebSupport
public class TrabalhoProgramacao3Application {

	public static void main(String[] args) {
		SpringApplication.run(TrabalhoProgramacao3Application.class, args);
	}



}
