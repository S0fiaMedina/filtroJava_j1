package com.filtrojava.console;

import com.filtrojava.formato.adapter.in.FormatoConsoleAdapter;
import com.filtrojava.formato.adapter.out.FormatoRepositoryMySQL;
import com.filtrojava.formato.application.FormatoService;
import com.filtrojava.formato.infrastructure.FormatoRepository;
import com.filtrojava.genero.adapter.in.GeneroConsoleAdapter;
import com.filtrojava.genero.adapter.out.generoRepositoryMySQL;
import com.filtrojava.genero.application.GeneroService;
import com.filtrojava.genero.infrastructure.GeneroRepository;
import com.filtrojava.pais.adapter.in.PaisConsoleAdapter;
import com.filtrojava.pais.adapter.out.PaisRepositoryMySQL;
import com.filtrojava.pais.application.PaisService;
import com.filtrojava.pais.infrastructure.PaisRepository;
import com.filtrojava.pelicula.adapter.in.PeliculaConsoleAdapter;
import com.filtrojava.pelicula.adapter.out.PeliculaMySQLRepository;
import com.filtrojava.pelicula.application.PeliculaService;
import com.filtrojava.pelicula.infrastructure.PeliculaRepository;
import com.filtrojava.tipoActor.adapter.in.TipoActorConsoleAdapter;
import com.filtrojava.tipoActor.adapter.out.TipoActorMySQLRepository;
import com.filtrojava.tipoActor.application.TipoActorService;
import com.filtrojava.tipoActor.infrastructure.TipoActorRepository;

public class Initializer {
    String url =  "jdbc:mysql://localhost:3306/cineCampus";
    String user = "campus2023";
    String password = "campus2023";

    private final GeneroRepository generoRepository;
    private final FormatoRepository formatoRepository;
    private final TipoActorRepository tipoActorRepository;
    private final PeliculaRepository peliculaRepository;
    private final PaisRepository paisRepository;

    public Initializer() {
        this.generoRepository = new generoRepositoryMySQL(url, user, password);
        this.formatoRepository = new FormatoRepositoryMySQL(url, user, password);
        this.peliculaRepository = new PeliculaMySQLRepository(url, user, password);
        this.tipoActorRepository = new TipoActorMySQLRepository(url, user, password);
        this.paisRepository = new PaisRepositoryMySQL(url, user, password);
    }


    public GeneroConsoleAdapter startGeneroModule(){
        GeneroService generoService = new GeneroService(generoRepository);
        return new GeneroConsoleAdapter(generoService);
    }

    public FormatoConsoleAdapter startFormatoModule(){
        FormatoService formatoService = new FormatoService(formatoRepository);
        return new FormatoConsoleAdapter(formatoService);
    }

    public PaisConsoleAdapter startPaisModulo(){
        PaisService paisService = new PaisService(paisRepository);
        return new PaisConsoleAdapter(paisService);
    }

    public TipoActorConsoleAdapter startTipoActorModule(){
        TipoActorService tipoActorService = new TipoActorService(tipoActorRepository);
        return new TipoActorConsoleAdapter(tipoActorService);
    }

    public PeliculaConsoleAdapter startPeliculaModule(){
        PeliculaService peliculaService = new PeliculaService(peliculaRepository);
        return new PeliculaConsoleAdapter(peliculaService);
    }

   


    

}
