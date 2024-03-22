package com.devmare.movie.services.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.devmare.movie.models.Cinema;
import com.devmare.movie.models.Movie;
import com.devmare.movie.models.Show;
import com.devmare.movie.repositories.CinemaRepository;
import com.devmare.movie.repositories.MovieRepository;
import com.devmare.movie.repositories.ShowRepository;
import com.devmare.movie.services.ShowService;

import lombok.Data;

@Data
@Service
public class ShowServiceImpl implements ShowService {

    private final ShowRepository showRepository;
    private final MovieRepository movieRepository;
    private final CinemaRepository cinemaRepository;

    @Override
    public List<Show> searchShowsByMovieAndCityAndDate(String movieName, LocalDate date, String location) {
        return showRepository.findAll()
                .stream()
                .filter(show -> show.getMovie().getTitle().equals(movieName)
                        && show.getCinema().getLocation().equals(location)
                        && show.getStartTime().toLocalDate().equals(date))
                .collect(Collectors.toList());

    }

    @Override
    public Show createShow(Integer movieId, Integer cinemaId, Show show) {
        Optional<Movie> optionalMovie = movieRepository.findById(movieId);
        Optional<Cinema> optionalCinema = cinemaRepository.findById(cinemaId);

        if (optionalMovie.isPresent() && optionalCinema.isPresent()) {
            Movie movie = optionalMovie.get();
            Cinema cinema = optionalCinema.get();

            show.setMovie(movie);
            show.setCinema(cinema);

            show.setCreatedAt(LocalDateTime.now());

            return showRepository.save(show);
        } else {
            throw new IllegalArgumentException("Movie or cinema not found");
        }
    }

    @Override
    public Show getShowDetails(Integer showId) {
        Optional<Show> optionalShow = showRepository.findById(showId);
        if (optionalShow.isPresent()) {
            return optionalShow.get();
        }
        return null;
    }
}
