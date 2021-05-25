package com.example.MovieRentalLab.usecases.decorator;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;

@ApplicationScoped
public class ClientCreator implements Serializable, IClientCreator {
    public Boolean createClient() {
        try {
            for(int i=0; i<5; i++){
                Thread.sleep(1000);
                System.out.println("************* SLEEP *************");
            }
            System.out.println("******** Thread.sleep ENDED. ********");
        } catch (InterruptedException e) {
            //handle exception
        }
        return true;
    }
}
