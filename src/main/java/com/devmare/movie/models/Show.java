package com.devmare.movie.models;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "shows")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    @JsonIgnore
    private LocalDateTime createdAt;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cinema_id", nullable = false)
    private Cinema cinema;
}
