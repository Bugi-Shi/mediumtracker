package com.bucksteg.mediumtracker;

import java.util.List;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bucksteg.mediumtracker.entity.Game;
import com.bucksteg.mediumtracker.entity.Movie;
import com.bucksteg.mediumtracker.enums.MediumStatus;
import com.bucksteg.mediumtracker.enums.Platform;
import com.bucksteg.mediumtracker.repository.GameRepository;
import com.bucksteg.mediumtracker.repository.MovieRepository;



@Slf4j      //Logger for info
@SpringBootApplication
public class MediumtrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediumtrackerApplication.class, args);
	}

	@Bean
  	public CommandLineRunner demo(GameRepository gameRepository, MovieRepository movieRepository) {
    	return args -> {

		List<Game> games = List.of(
			new Game(
				"Elden Ring", 
				2022,
				5, 
				MediumStatus.COMPLETED,
				2022, 
				Platform.PS5, 
				120.0),
			new Game(
				"Silksong", 
				2025, 
				5, 
				MediumStatus.COMPLETED, 
				2025,
				Platform.PC, 
				69.0)
		);

		List<Movie> movies = List.of(
			new Movie(
				"Detektiv Conan: The Scarlet Bullet",
				2021,
				5,
				MediumStatus.COMPLETED,
				2021,
				110),
			new Movie(
				"Herr der Ringe: Die Rückkehr des Königs",
				2003,
				5,
				MediumStatus.COMPLETED,
				2008,
				201
			)
		);

      	gameRepository.saveAll(games);
		movieRepository.saveAll(movies);

		//fetch all games
		log.info("Games found with findAll():");
		gameRepository.findAll().forEach(game -> 
			log.info(game.toString())
		);
		log.info("");

		//fetch game by ID
		Optional<Game> game = gameRepository.findById(2L);
		game.ifPresent(g -> log.info("Game found: " + g.toString()));

		//fetch all movies
		log.info("Movies found with findAll():");
		movieRepository.findAll().forEach(movie ->
			log.info(movie.toString())
		);
		log.info("");

		//fetch movie by ID
		Optional<Movie> movie = movieRepository.findById(2L);
		movie.ifPresent(m -> log.info("Movie found: " + m.toString()));
		log.info("");
	};
  }
}