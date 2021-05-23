package com.example.MovieRentalLab.persistence;

import com.example.MovieRentalLab.entities.Movie;
import java.util.List;

public interface IMovieDAO {
    List<Movie> getAllMovies();

    void persist(Movie movie);

    Movie findOne(Integer id);

    Movie update(Movie movie);
}
