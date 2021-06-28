package com.dietschke.Liste;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ListeApplication {

	private static final Logger log = LoggerFactory.getLogger(ListeApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ListeApplication.class, args);
	}
}
