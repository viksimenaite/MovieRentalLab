package com.example.MovieRentalLab.persistence;

import com.example.MovieRentalLab.entities.Movie;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class MoviesDAO {
    @Inject
    private EntityManager em;

    public List<Movie> getAllMovies() {
        return em.createNamedQuery("Movie.findAll", Movie.class).getResultList();
    }

    public void persist(Movie movie){
        this.em.persist(movie);
    }

    public Movie findOne(Integer id){
        return em.find(Movie.class, id);
    }

    public Movie update(Movie movie){
        return em.merge(movie);
    }
}
