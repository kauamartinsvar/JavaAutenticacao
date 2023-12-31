package com.br.var.solutions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.Entity;


@EntityScan(basePackages = {"com.br.var.solutions.domain.entities"})
@EnableJpaRepositories(basePackages = {"com.br.var.solutions.domain.repositories"})
@ComponentScan(basePackages = {"com.br.var.solutions"})
@SpringBootApplication
public class ApiVarSolutionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiVarSolutionsApplication.class, args);
	}

}
