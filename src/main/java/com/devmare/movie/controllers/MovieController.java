package com.devmare.movie.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devmare.movie.models.Movie;
import com.devmare.movie.services.MovieService;

import lombok.Data;

@Data
@RestController
@RequestMapping("api/v1/movie")
public class MovieController {

    private final MovieService movieService;

    // ! http://localhost:8081/api/v1/movie
    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        Movie newMovie = movieService.addMovie(movie);
        return new ResponseEntity<>(newMovie, HttpStatus.CREATED);
    }
}
