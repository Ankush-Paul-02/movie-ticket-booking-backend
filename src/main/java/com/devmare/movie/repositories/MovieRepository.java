package com.devmare.movie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devmare.movie.models.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    Movie findByTitle(String movieName);
}
