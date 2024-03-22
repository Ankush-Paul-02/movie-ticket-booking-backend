package com.devmare.movie.services;

import java.time.LocalDate;
import java.util.List;

import com.devmare.movie.models.Show;

public interface ShowService {
    List<Show> searchShowsByMovieAndCityAndDate(String movieName, LocalDate date, String location);

    Show createShow(Integer movieId, Integer cinemaId, Show show);

    Show getShowDetails(Integer showId);

}
