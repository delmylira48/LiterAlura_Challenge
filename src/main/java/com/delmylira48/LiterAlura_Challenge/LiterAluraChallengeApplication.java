package com.delmylira48.LiterAlura_Challenge;

import com.delmylira48.LiterAlura_Challenge.domain.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiterAluraChallengeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraChallengeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.llamarAPI();
	}
}
