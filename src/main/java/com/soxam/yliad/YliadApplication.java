package com.soxam.yliad;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class YliadApplication {

	public static void main(String[] args) {
		SpringApplication.run(YliadApplication.class, args);
	}

	@Bean
	public CommandLineRunner startup() {
		return args -> {
			log.info("I'm a CommandLineRunner");
		};
	}
}
