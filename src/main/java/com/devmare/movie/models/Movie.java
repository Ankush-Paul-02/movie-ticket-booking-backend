package com.devmare.movie.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "movies")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_id_generator")
    @SequenceGenerator(name = "movie_id_generator", sequenceName = "MOVIE_ID_SEQ", allocationSize = 1)
    private Integer id;
    private String title;
    private String description;
    private Integer duration;
    private String language;
    private Date releaseDate;
    private String country;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Show> shows;
}
