package com.shahinkhalajestani.banktask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableJpaAuditing
@EnableScheduling
@PropertySource(value = {"classpath:resultstatus.properties"})
public class BankTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankTaskApplication.class, args);
	}

}
