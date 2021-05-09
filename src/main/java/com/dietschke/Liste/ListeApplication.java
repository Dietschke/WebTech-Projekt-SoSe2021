package com.dietschke.Liste;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ListeApplication {

	private static final Logger log = LoggerFactory.getLogger(ListeApplication.class);


	public static void main(String[] args) {

		SpringApplication.run(ListeApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ListeRepository repository) {
		return (args) -> {

			repository.save(new Liste(1L,"Kuchen", "Schokokuchen von Oma"));
			repository.save(new Liste(2L,"Burger", "Lieblingsburger"));


			log.info("Liste found with findAll():");
			log.info("-------------------------------");
			for (Liste liste : repository.findAll()) {
				log.info(liste.toString());
			}
			log.info("");

			Liste liste = repository.findById(1L);
			log.info("Liste found with findById(1L):");
			log.info("--------------------------------");
			log.info(liste.toString());
			log.info("");

			log.info("Liste found with findByTitle('Kuchen'):");
			log.info("--------------------------------------------");
			repository.findByTitle("Kuchen").forEach(kuchen -> {
				log.info(kuchen.toString());
			});
			log.info("");
		};
	}
}
