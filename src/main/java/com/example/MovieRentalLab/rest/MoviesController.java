package com.example.MovieRentalLab.rest;

import com.example.MovieRentalLab.entities.Movie;
import com.example.MovieRentalLab.persistence.MoviesDAO;
import com.example.MovieRentalLab.rest.contracts.MovieDTO;
import lombok.Getter;
import lombok.Setter;

import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MoviesController {

    @Inject
    @Getter @Setter
    private MoviesDAO moviesDAO;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Integer id) {
        Movie movie = moviesDAO.findOne(id);
        if (movie == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setName(movie.getName());
        if (movie.getReleaseDate() != null) movieDTO.setReleaseDate(movie.getReleaseDate().toString());
        if (movie.getAvailabilityEndDate() != null) movieDTO.setAvailabilityEndDate(movie.getAvailabilityEndDate().toString());

        return Response.ok(movieDTO).build();
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(
            @PathParam("id") final Integer movieId,
            MovieDTO movieData,
            @QueryParam("ole") final Boolean invokeOLE) {
        try {
            Movie existingMovie = moviesDAO.findOne(movieId);
            if (existingMovie == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            existingMovie.setName(movieData.getName());
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            existingMovie.setReleaseDate(format.parse(movieData.getReleaseDate())); // TODO: FIX
            existingMovie.setAvailabilityEndDate(format.parse(movieData.getAvailabilityEndDate())); // TODO: FIX

            moviesDAO.update(existingMovie);
            if (invokeOLE != null && invokeOLE) {
                Thread.sleep(7000);
                moviesDAO.flush();
                moviesDAO.persist(existingMovie);
            }

            return Response.ok().build();

        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }catch (ParseException | InterruptedException pe) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(MovieDTO movieData) {
        try {
            Movie movieToCreate = new Movie();
            movieToCreate.setName(movieData.getName());
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            movieToCreate.setReleaseDate(format.parse(movieData.getReleaseDate()));
            movieToCreate.setAvailabilityEndDate(format.parse(movieData.getAvailabilityEndDate()));

            moviesDAO.persist(movieToCreate);
            return Response.ok().build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }catch (ParseException pe) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

}
