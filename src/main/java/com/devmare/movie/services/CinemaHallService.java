package com.devmare.movie.services;

import java.util.List;

import com.devmare.movie.models.CinemaHall;

public interface CinemaHallService {
    CinemaHall createCinemaHall(CinemaHall cinemaHall, Integer cinemaId);

    List<CinemaHall> getCinemaHallsByCinemaId(Integer cinemaId);
}
