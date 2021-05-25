package com.example.MovieRentalLab.usecases.decorator;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public class ClientCreatorDecorator implements IClientCreator {

    @Inject
    @Delegate
    @Any
    IClientCreator clientCreator;

    @Override
    public Boolean createClient() {
        try {
            clientCreator.createClient();
            for(int i=0; i<5; i++){
                Thread.sleep(1000);
                System.out.println("************* Decorator: SLEEP *************");
            }
            System.out.println("******* Decorator: Thread.sleep ENDED. *******");
        } catch (InterruptedException e) {

        }
        return true;
    }
}
