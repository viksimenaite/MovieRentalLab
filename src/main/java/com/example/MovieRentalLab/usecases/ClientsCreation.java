package com.example.MovieRentalLab.usecases;

import com.example.MovieRentalLab.usecases.decorator.ClientCreator;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SessionScoped
@Named
public class ClientsCreation implements Serializable {
    @Inject
    private ClientCreator clientCreator;

    public void startWork() {
        clientCreationTask = CompletableFuture.supplyAsync(() -> clientCreator.createClient());
    }

    @PostConstruct
    private void printOnCreation() {
        System.out.println("***** created new bean *****");
    }

    private CompletableFuture<Boolean> clientCreationTask = null;

    public boolean isClientCreatorRunning() {
        return clientCreationTask != null && !clientCreationTask.isDone();
    }

    public String getClientCreationStatus() throws ExecutionException, InterruptedException {
        if (clientCreationTask == null) {
            return "Add a new client to watch this movie";
        } else if (isClientCreatorRunning()) {
            return "Client creation in progress";
        }
        return "Add a new client to watch this movie" + clientCreationTask.get();
    }
}
