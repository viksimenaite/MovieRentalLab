package com.example.MovieRentalLab.rest.contracts;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class MovieDTO {
    private String name;

    private String releaseDate;

    private String availabilityEndDate;
}
