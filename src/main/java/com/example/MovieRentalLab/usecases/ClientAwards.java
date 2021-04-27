package com.example.MovieRentalLab.usecases;

import com.example.MovieRentalLab.entities.Award;
import com.example.MovieRentalLab.entities.Client;
import com.example.MovieRentalLab.entities.Movie;
import com.example.MovieRentalLab.persistence.AwardsDAO;
import com.example.MovieRentalLab.persistence.ClientsDAO;
import com.example.MovieRentalLab.persistence.MoviesDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Model
public class ClientAwards {

    @Inject
    private ClientsDAO clientsDAO;

    @Inject
    private AwardsDAO awardsDAO;

    @Inject
    private MoviesDAO moviesDAO;

    @Getter
    private Client client;

    @Getter @Setter // FR[3.1.2]
    private Award awardToCreate = new Award();

    @Getter @Setter
    private Integer movieIdToRent = 0;

    @PostConstruct
    public void init(){
        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        int clientId = Integer.parseInt(requestParameters.get("clientId"));
        client = clientsDAO.findOne(clientId);
    }

    @Transactional
    public String createAward() {
        awardToCreate.setClient(client);
        awardsDAO.persist(awardToCreate);
        return "clientAwards?faces-redirect=true&clientId=" + client.getId();
    }

    @Transactional
    public String rentMovie() {
        List<Movie> movies = client.getMovies();
        Movie movieToRent = moviesDAO.findOne(movieIdToRent);
        movies.add(movieToRent);
        client.setMovies(movies);
        return "clientAwards?faces-redirect=true&clientId=" + client.getId();
    }
}
