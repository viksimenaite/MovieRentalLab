package com.example.MovieRentalLab.usecases;

import com.example.MovieRentalLab.entities.Client;
import com.example.MovieRentalLab.mybatis.dao.MovieMapper;
import com.example.MovieRentalLab.mybatis.model.Movie;
import com.example.MovieRentalLab.persistence.ClientsDAO;
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
    private ClientsDAO clientsDAO;

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

    // FR[3.1.2]
    // FR[3.5]
    @Transactional
    public String createClient() {
        List<Movie> movies = new ArrayList<>();
        movies.add(this.movie);
        this.clientToCreate.setMovies(movies);
        clientsDAO.persist(this.clientToCreate);
        return "clients?faces-redirect=true&movieId=" + this.movie.getId();
    }

}
