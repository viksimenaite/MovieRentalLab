package com.example.MovieRentalLab.persistence;

import com.example.MovieRentalLab.entities.Award;
import com.example.MovieRentalLab.interceptors.LoggingInterceptor;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Specializes;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
@Specializes
@LoggingInterceptor
public class SecureAwardsDAO extends AwardsDAO{
    @Inject
    private EntityManager em;

    public void persist(Award award){
        System.out.println("Persisting award securely");
        this.em.persist(award);
    }
}
