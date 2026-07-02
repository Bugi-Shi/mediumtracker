package com.bucksteg.mediumtracker;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.bucksteg.mediumtracker.entity.Game;
import com.bucksteg.mediumtracker.enums.MediumStatus;
import com.bucksteg.mediumtracker.enums.Platform;
import com.bucksteg.mediumtracker.repository.GameRepository;

@SpringBootApplication
public class MediumtrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediumtrackerApplication.class, args);
	}

	@Bean
  	public CommandLineRunner demo(GameRepository gameRepository) {
    	return args -> {

      	gameRepository.save(new Game(
			"Elden Ring", 
			2022,
			5, 
			MediumStatus.COMPLETED, 
			Platform.PS5, 
			120.0)
		);
		gameRepository.save(new Game(
			"Silksong", 
			2025, 
			5, 
			MediumStatus.COMPLETED, 
			Platform.PC, 
			69.0)
		);
		gameRepository.save(new Game(
			"Silksong", 
			2025, 
			5, 
			MediumStatus.COMPLETED, 
			Platform.PC, 
			69.0)
		);
	};
  }
}