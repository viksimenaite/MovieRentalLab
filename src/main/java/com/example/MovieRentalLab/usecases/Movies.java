package com.example.MovieRentalLab.usecases;

import com.example.MovieRentalLab.entities.Movie;
import com.example.MovieRentalLab.persistence.IMovieDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Movies {
    @Inject
    private IMovieDAO moviesDAO;

    @Getter
    private List<Movie> allMovies;

    @Getter @Setter
    private Movie movieToCreate = new Movie();

    @PostConstruct
    public void init(){
        loadAllMovies();
    }

    @Transactional
    public String createMovie() {
        moviesDAO.persist(movieToCreate);
        return "index?faces-redirect=true";
    }

    private void loadAllMovies() {
        this.allMovies = moviesDAO.getAllMovies();
    }
}
