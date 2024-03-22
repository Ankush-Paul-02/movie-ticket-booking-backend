package com.devmare.movie.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchRequest {
    private String movieName;
    private LocalDate dateTime;
    private String location;
}
