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

import com.devmare.movie.models.SearchRequest;
import com.devmare.movie.models.Show;
import com.devmare.movie.services.ShowService;

import lombok.Data;

@Data
@RestController
@RequestMapping("api/v1/shows")
public class ShowController {

    private final ShowService showService;

    // ! http://localhost:8081/api/v1/shows/search-movies
    @PostMapping("search-movies")
    public ResponseEntity<List<Show>> searchShowsByMovieAndCityAndDate(@RequestBody SearchRequest searchRequest) {
        List<Show> shows = showService.searchShowsByMovieAndCityAndDate(
                searchRequest.getMovieName(),
                searchRequest.getDateTime(),
                searchRequest.getLocation());
        return new ResponseEntity<>(shows, HttpStatus.OK);
    }

    // ! http://localhost:8081/api/v1/shows/create-show/cinema/1/movie/1
    @PostMapping("create-show/cinema/{cinemaId}/movie/{movieId}")
    public ResponseEntity<Show> createShow(
            @PathVariable Integer movieId,
            @PathVariable Integer cinemaId,
            @RequestBody Show show) {
        Show createdShow = showService.createShow(movieId, cinemaId, show);
        return new ResponseEntity<>(createdShow, HttpStatus.CREATED);
    }

    // ! http://localhost:8081/api/v1/shows/{showId}
    @GetMapping("{showId}")
    public ResponseEntity<Show> getShowDetails(@PathVariable Integer showId) {
        Show currentShow = showService.getShowDetails(showId);
        return new ResponseEntity<>(currentShow, HttpStatus.FOUND);
    }

}