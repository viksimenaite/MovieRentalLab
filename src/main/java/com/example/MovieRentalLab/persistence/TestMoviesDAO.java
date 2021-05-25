package com.example.MovieRentalLab.persistence;

import com.example.MovieRentalLab.entities.Movie;
import com.example.MovieRentalLab.enums.MovieGenre;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Alternative
public class TestMoviesDAO implements IMovieDAO{
    @Override
    public List<Movie> getAllMovies() {
        List<Movie> result = new ArrayList<>();
        Movie movie;

        for(int i=0; i<3; i++){
            movie = new Movie();
            movie.setId(120 + i);
            movie.setName("Alternative movie " + i);
            movie.setGenre(MovieGenre.Action);
            result.add(movie);
        }

        return result;
    }

    @Override
    public void persist(Movie movie) {
    }

    @Override
    public Movie findOne(Integer id) {
        if (id == 15) return null;
        Movie movie = new Movie();
        movie.setId(id);
        movie.setName("Alternative movie!");
        movie.setGenre(MovieGenre.Action);
        return movie;
    }

    @Override
    public Movie update(Movie movie) {
        return movie;
    }
}
