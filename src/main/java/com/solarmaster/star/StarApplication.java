package com.solarmaster.star;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StarApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StarApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}

}
