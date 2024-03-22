package com.devmare.movie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devmare.movie.models.Show;

@Repository
public interface ShowRepository extends JpaRepository<Show, Integer> {

}
