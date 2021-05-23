package com.example.MovieRentalLab.persistence;

import com.example.MovieRentalLab.entities.Movie;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@Default
public class MoviesDAO implements IMovieDAO{
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

    public void flush() { em.flush();}
}
