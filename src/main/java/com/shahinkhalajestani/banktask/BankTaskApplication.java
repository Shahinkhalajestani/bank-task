package com.shahinkhalajestani.banktask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BankTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankTaskApplication.class, args);
	}

}
