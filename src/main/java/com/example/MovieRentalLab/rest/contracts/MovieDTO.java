package com.example.MovieRentalLab.rest.contracts;

import com.example.MovieRentalLab.entities.Movie;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class MovieDTO {
    private String name;

    private String releaseDate;

    private String availabilityEndDate;

    public static MovieDTO fromEntity(Movie movie) {
        if(movie != null) {
            MovieDTO movieDTO = new MovieDTO();
            movieDTO.setName(movie.getName());
            return movieDTO;
        }
        return null;
    }
}
