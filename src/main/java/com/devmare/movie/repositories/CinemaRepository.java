package com.devmare.movie.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devmare.movie.models.Cinema;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Integer> {
    List<Cinema> findByLocation(String location);
}
