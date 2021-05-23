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
            Thread.sleep(7000);
            System.out.println("***** Decorator Thread.sleep ended. *****");
        } catch (InterruptedException e) {

        }
        return true;
    }
}
