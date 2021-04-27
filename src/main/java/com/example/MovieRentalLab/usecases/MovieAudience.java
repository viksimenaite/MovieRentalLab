package com.example.MovieRentalLab.usecases;

import com.example.MovieRentalLab.entities.Client;
import com.example.MovieRentalLab.entities.Movie;
import com.example.MovieRentalLab.persistence.ClientsDAO;
import com.example.MovieRentalLab.persistence.MoviesDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Model
public class MovieAudience implements Serializable {
    @Inject
    private MoviesDAO moviesDAO;

    @Inject
    private ClientsDAO clientsDAO;

    @Getter @Setter
    private Movie movie;

    @Getter @Setter
    private Client clientToCreate = new Client();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        int movieId = Integer.parseInt(requestParameters.get("movieId"));
        this.movie = moviesDAO.findOne(movieId);
    }

    // FR[3.1.2]
    // FR[3.5]
    @Transactional
    public String createMovie() {
        List<Movie> movies = new ArrayList<>();
        movies.add(this.movie);
        clientToCreate.setMovies(movies);
        clientsDAO.persist(this.clientToCreate);
        return "users?faces-redirect=true&projectId=" + this.movie.getId();
    }
}
