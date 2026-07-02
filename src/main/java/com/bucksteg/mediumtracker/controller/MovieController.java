package com.bucksteg.mediumtracker.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bucksteg.mediumtracker.dto.movie_dtos.MovieCreateDto;
import com.bucksteg.mediumtracker.dto.movie_dtos.MovieResponseDto;
import com.bucksteg.mediumtracker.dto.movie_dtos.MovieUpdateDto;
import com.bucksteg.mediumtracker.entity.Movie;
import com.bucksteg.mediumtracker.service.MovieService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping()
    public Iterable<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }
    

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable Long id) {
        return movieService.getMovie(id);
    }

    @PostMapping
    public MovieResponseDto createMovie(@RequestBody MovieCreateDto movieDto) {
        return movieService.createMovie(movieDto);
    }

    @PutMapping("/{id}")
    public MovieResponseDto updateMovie(@PathVariable Long id, @RequestBody MovieUpdateDto movieUpdateDto) {        
        return movieService.updateMovie(id, movieUpdateDto);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
    }   
}
