package com.devmare.movie.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "cinemas")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cinema_id_generator")
    @SequenceGenerator(name = "cinema_id_generator", sequenceName = "CINEMA_ID_SEQ", allocationSize = 1)
    private Integer id;

    private String name;

    private Integer totalCinemaHalls;

    private String location;

    @JsonIgnore
    @OneToMany(mappedBy = "cinema", cascade = CascadeType.ALL)
    private List<CinemaHall> CinemaHalls;

    @JsonIgnore
    @OneToMany(mappedBy = "cinema", cascade = CascadeType.ALL)
    private List<Show> shows;
}
