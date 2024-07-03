package com.filtrojava.console;

import com.filtrojava.genero.adapter.in.GeneroConsoleAdapter;
import com.filtrojava.genero.adapter.out.generoRepositoryMySQL;
import com.filtrojava.genero.application.GeneroService;
import com.filtrojava.genero.infrastructure.GeneroRepository;

public class Initializer {
    String url =  "jdbc:mysql://localhost:3306/cineCampus";
    String user = "campus2023";
    String password = "campus2023";

    private GeneroRepository generoRepository;

    public Initializer( ) {
        this.generoRepository = new generoRepositoryMySQL(url, user, password);
    }


    public GeneroConsoleAdapter startGeneroModule(){
        GeneroService generoService = new GeneroService(generoRepository);
        return new GeneroConsoleAdapter(generoService);
    }

    

}
