package com.bucksteg.mediumtracker.service;

import org.springframework.stereotype.Service;

import com.bucksteg.mediumtracker.dto.movie_dtos.MovieCreateDto;
import com.bucksteg.mediumtracker.dto.movie_dtos.MovieResponseDto;
import com.bucksteg.mediumtracker.dto.movie_dtos.MovieUpdateDto;
import com.bucksteg.mediumtracker.entity.Movie;
import com.bucksteg.mediumtracker.exception.MovieNotFoundException;
import com.bucksteg.mediumtracker.repository.MovieRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j      //Logger for info
@Service
public class MovieService {

    private final MovieRepository movieRepository;

    private MovieResponseDto toResponseDto(Movie movie) {
        return new MovieResponseDto(
            movie.getId(),
            movie.getTitle(),
            movie.getReleaseYear(),
            movie.getRating(),
            movie.getStatus(),
            movie.getFinishedYear(),
            movie.getDurationMinutes()
        );
    }

    public MovieService(MovieRepository movieRepository) { //Dependency Injection
        this.movieRepository = movieRepository;
    }

    public Movie getMovie(Long id) {
        return movieRepository
        .findById(id)
        .orElseThrow(() -> new MovieNotFoundException(id));
    }

    public Iterable<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public void printMovie(Long id) {
        Movie movie = getMovie(id);

        log.info("Found movie: {}", movie.getTitle());            //Logger setzt den Wert in {} ein, wenn dieser existiert
    }

    public MovieResponseDto createMovie(MovieCreateDto movieDto) {
        Movie movie = new Movie(
            movieDto.getTitle(),
            movieDto.getReleaseYear(),
            movieDto.getRating(),
            movieDto.getStatus(),
            movieDto.getFinishedYear(),
            movieDto.getDurationMinutes()
        );

        Movie savedMovie = movieRepository.save(movie);
        return toResponseDto(savedMovie);
    }

    public MovieResponseDto updateMovie(Long id, MovieUpdateDto movieDto) {
        Movie movie = movieRepository.findById(id)
        .orElseThrow(() -> new MovieNotFoundException(id));

        movie.setTitle(movieDto.getTitle());
        movie.setReleaseYear(movieDto.getReleaseYear());
        movie.setRating(movieDto.getRating());
        movie.setStatus(movieDto.getStatus());
        movie.setFinishedYear(movieDto.getFinishedYear());
        movie.setDurationMinutes(movieDto.getDurationMinutes());

        Movie savedMovie = movieRepository.save(movie);

        return toResponseDto(savedMovie);
    }
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}
