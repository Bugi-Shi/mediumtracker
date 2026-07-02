package com.bucksteg.mediumtracker.service;

import org.springframework.stereotype.Service;

import com.bucksteg.mediumtracker.entity.Movie;
import com.bucksteg.mediumtracker.exception.GameNotFoundException;
import com.bucksteg.mediumtracker.repository.MovieRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j      //Logger for info
@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) { //Dependency Injection
        this.movieRepository = movieRepository;
    }

    public Movie getMovie(Long id) {
        return movieRepository
        .findById(id)
        .orElseThrow(() -> new GameNotFoundException(id));
    }

    public void printGame(Long id) {
        Movie movie = getMovie(id);

        log.info("Found game: {}", movie.getTitle());            //Logger setzt den Wert in {} ein, wenn dieser existiert
    }
}
