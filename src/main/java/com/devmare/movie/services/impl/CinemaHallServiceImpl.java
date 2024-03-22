package com.devmare.movie.services.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.devmare.movie.models.Cinema;
import com.devmare.movie.models.CinemaHall;
import com.devmare.movie.repositories.CinemaHallRepository;
import com.devmare.movie.repositories.CinemaRepository;
import com.devmare.movie.services.CinemaHallService;

import lombok.Data;

@Data
@Service
public class CinemaHallServiceImpl implements CinemaHallService {

    private final CinemaHallRepository cinemaHallRepository;

    private final CinemaRepository cinemaRepository;

    @Override
    public CinemaHall createCinemaHall(CinemaHall cinemaHall, Integer cinemaId) {
        Optional<Cinema> cinemaOptional = cinemaRepository.findById(cinemaId);
        if (cinemaOptional.isPresent()) {
            Cinema currentCinema = cinemaOptional.get();
            cinemaHall.setCinema(currentCinema);
            return cinemaHallRepository.save(cinemaHall);
        }
        return null;
    }

    public List<CinemaHall> getCinemaHallsByCinemaId(Integer cinemaId) {
        Optional<Cinema> cinemaOptional = cinemaRepository.findById(cinemaId);
        if (cinemaOptional.isPresent()) {
            Cinema cinema = cinemaOptional.get();
            return cinema.getCinemaHalls();
        }
        return Collections.emptyList();
    }

}
