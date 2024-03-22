package com.devmare.movie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devmare.movie.models.CinemaHall;

@Repository
public interface CinemaHallRepository extends JpaRepository<CinemaHall, Integer> {

}
