package com.example.MovieRentalLab.usecases.decorator;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;

@ApplicationScoped
public class ClientCreator implements Serializable, IClientCreator {
    public Boolean createClient() {
        try {
            Thread.sleep(3000);
            System.out.println("***** Thread.sleep ended. *****");
        } catch (InterruptedException e) {
            //handle exception
        }
        return true;
    }
}
