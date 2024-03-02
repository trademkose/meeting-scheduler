package com.ademkose.casesolving;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class AdemkoseCaseSolvingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdemkoseCaseSolvingApplication.class, args);
		
		
	}

}
