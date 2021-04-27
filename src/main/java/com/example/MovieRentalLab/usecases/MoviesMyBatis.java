package com.example.MovieRentalLab.usecases;

import com.example.MovieRentalLab.entities.Movie;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class MoviesMyBatis {
/*    @Inject
    private MovieMapper moviesDAO;

    @Getter
    private List<Movie> allMovies;

    @Getter @Setter
    private Movie movieToCreate = new Movie();

    @PostConstruct
    public void init(){
        this.loadAllMovies();
    }

    @Transactional
    public String createMovie() {
        moviesDAO.insert(movieToCreate);
        return "index?faces-redirect=true";
    }

    private void loadAllProjects() {
        this.allMovies = moviesDAO.selectAll();
    }*/
}
