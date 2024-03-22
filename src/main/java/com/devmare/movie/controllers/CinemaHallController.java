package com.devmare.movie.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devmare.movie.models.CinemaHall;
import com.devmare.movie.services.CinemaHallService;

import lombok.Data;

@Data
@RestController
@RequestMapping("api/v1/cinema/{cinemaId}/cinema-hall")
public class CinemaHallController {

    private final CinemaHallService cinemaHallService;

    // ! http://localhost:8081/api/v1/cinema/{cinemaId}/cinema-hall
    @PostMapping
    public ResponseEntity<CinemaHall> createCinemaHall(
            @RequestBody CinemaHall cinemaHall,
            @PathVariable Integer cinemaId) {
        CinemaHall newCinemaHall = cinemaHallService.createCinemaHall(cinemaHall, cinemaId);
        if (newCinemaHall != null) {
            return new ResponseEntity<>(newCinemaHall, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    // ! http://localhost:8081/api/v1/cinema/{cinemaId}/cinema-hall
    @GetMapping
    public ResponseEntity<List<CinemaHall>> getAllCinemas(@PathVariable Integer cinemaId) {
        List<CinemaHall> cinemaHalls = cinemaHallService.getCinemaHallsByCinemaId(cinemaId);
        return new ResponseEntity<>(cinemaHalls, HttpStatus.FOUND);
    }
}
