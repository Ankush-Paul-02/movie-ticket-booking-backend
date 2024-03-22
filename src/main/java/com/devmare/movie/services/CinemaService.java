package com.devmare.movie.services;

import java.util.List;

import com.devmare.movie.models.Cinema;

public interface CinemaService {
    Cinema createCinema(Cinema cinema);

    List<Cinema> getAllCinemas();
}
