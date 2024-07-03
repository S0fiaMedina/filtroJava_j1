package com.filtrojava.console;

import com.filtrojava.formato.adapter.in.FormatoConsoleAdapter;
import com.filtrojava.formato.adapter.out.FormatoRepositoryMySQL;
import com.filtrojava.formato.application.FormatoService;
import com.filtrojava.formato.infrastructure.FormatoRepository;
import com.filtrojava.genero.adapter.in.GeneroConsoleAdapter;
import com.filtrojava.genero.adapter.out.generoRepositoryMySQL;
import com.filtrojava.genero.application.GeneroService;
import com.filtrojava.genero.infrastructure.GeneroRepository;

public class Initializer {
    String url =  "jdbc:mysql://localhost:3306/cineCampus";
    String user = "campus2023";
    String password = "campus2023";

    private final GeneroRepository generoRepository;
    private final FormatoRepository formatoRepository;

    public Initializer() {
        this.generoRepository = new generoRepositoryMySQL(url, user, password);
        this.formatoRepository = new FormatoRepositoryMySQL(url, user, password);

    }


    public GeneroConsoleAdapter startGeneroModule(){
        GeneroService generoService = new GeneroService(generoRepository);
        return new GeneroConsoleAdapter(generoService);
    }

    public FormatoConsoleAdapter startFormatoModule(){
        FormatoService formatoService = new FormatoService(formatoRepository);
        return new FormatoConsoleAdapter(formatoService);
    }



    

}
