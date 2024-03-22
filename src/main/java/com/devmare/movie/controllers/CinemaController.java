package com.devmare.movie.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devmare.movie.models.Cinema;
import com.devmare.movie.services.CinemaService;

import lombok.Data;

@Data
@RestController
@RequestMapping("api/v1/cinema")
public class CinemaController {

    private final CinemaService cinemaService;

    // ! http://localhost:8081/api/v1/cinema
    @PostMapping
    public ResponseEntity<Cinema> createCinema(@RequestBody Cinema cinema) {
        Cinema newCinema = cinemaService.createCinema(cinema);
        return new ResponseEntity<>(newCinema, HttpStatus.CREATED);
    }

    // ! http://localhost:8081/api/v1/cinema
    @GetMapping
    public ResponseEntity<List<Cinema>> getAllCinemas() {
        List<Cinema> cinemas = cinemaService.getAllCinemas();
        return new ResponseEntity<>(cinemas, HttpStatus.FOUND);
    }

}
