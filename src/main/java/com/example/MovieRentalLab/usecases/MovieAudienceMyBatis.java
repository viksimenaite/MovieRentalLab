package com.example.MovieRentalLab.usecases;

import com.example.MovieRentalLab.mybatis.dao.ClientMapper;
import com.example.MovieRentalLab.mybatis.dao.ClientMovieMapper;
import com.example.MovieRentalLab.mybatis.dao.MovieMapper;
import com.example.MovieRentalLab.mybatis.model.Client;
import com.example.MovieRentalLab.mybatis.model.Movie;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Model
public class MovieAudienceMyBatis {

    @Inject
    private MovieMapper movieMapper;

    @Inject
    private ClientMapper clientMapper;

    @Inject
    private ClientMovieMapper clientMovieMapper;

    @Getter
    @Setter
    private Movie movie;

    @Getter @Setter
    private Client clientToCreate = new Client();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        int movieId = Integer.parseInt(requestParameters.get("movieId"));
        this.movie = movieMapper.selectByPrimaryKey(movieId);
    }

    @Transactional
    public String createClient() {
        List<Movie> movies = new ArrayList<>();
        movies.add(this.movie);
        //this.clientToCreate.setMovies(movies);
        clientMapper.insert(this.clientToCreate);
        return "clients?faces-redirect=true&movieId=" + this.movie.getId();
    }

}
