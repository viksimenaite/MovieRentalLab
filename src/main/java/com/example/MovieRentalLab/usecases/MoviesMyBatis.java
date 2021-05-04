package com.example.MovieRentalLab.usecases;

import com.example.MovieRentalLab.mybatis.dao.MovieMapper;
import com.example.MovieRentalLab.mybatis.model.Movie;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class MoviesMyBatis {
    @Inject
    private MovieMapper movieMapper;

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
        movieMapper.insert(movieToCreate);
        return "movies?faces-redirect=true";
    }

    private void loadAllMovies() {
        this.allMovies = movieMapper.selectAll();
    }
}
