package com.delmylira48.LiterAlura_Challenge;

import com.delmylira48.LiterAlura_Challenge.domain.Principal;
import com.delmylira48.LiterAlura_Challenge.services.ServicioLibros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiterAluraChallengeApplication implements CommandLineRunner {

	@Autowired
	Principal principal;

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraChallengeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		principal.presentarMenu();
	}
}
