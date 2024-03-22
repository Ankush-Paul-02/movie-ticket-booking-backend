package com.devmare.movie.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devmare.movie.models.Cinema;
import com.devmare.movie.repositories.CinemaRepository;
import com.devmare.movie.services.CinemaService;

import lombok.Data;

@Data
@Service
public class CinemaServiceImpl implements CinemaService {

    private final CinemaRepository cinemaRepository;

    @Override
    public Cinema createCinema(Cinema cinema) {
        return cinemaRepository.save(cinema);
    }

    @Override
    public List<Cinema> getAllCinemas() {
        return cinemaRepository.findAll();
    }

}
