package com.devmare.movie.services.impl;

import org.springframework.stereotype.Service;

import com.devmare.movie.models.Movie;
import com.devmare.movie.repositories.MovieRepository;
import com.devmare.movie.services.MovieService;

import lombok.Data;

@Data
@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

}
