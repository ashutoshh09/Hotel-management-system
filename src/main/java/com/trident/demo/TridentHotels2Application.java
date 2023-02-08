package com.trident.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("controller")
@EnableJpaRepositories("dao")
@EntityScan("model")
public class TridentHotels2Application {

	public static void main(String[] args) {
		SpringApplication.run(TridentHotels2Application.class, args);
	}

}
