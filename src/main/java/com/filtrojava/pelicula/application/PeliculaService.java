package com.filtrojava.pelicula.application;

import java.util.List;
import java.util.Optional;

import com.filtrojava.pelicula.domain.Pelicula;
import com.filtrojava.pelicula.infrastructure.PeliculaRepository;



public class PeliculaService {
    private final PeliculaRepository peliculaRepository;


    public PeliculaService(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    public void agregarPelicula(Pelicula pelicula){
        this.peliculaRepository.agregar(pelicula);
    }

    public void editarPelicula(Pelicula pelicula){
        this.peliculaRepository.editar(pelicula);

    }

    public void eliminarPelicula(int id){
        this.peliculaRepository.eliminar(id);

    }

    public List<Pelicula> listarPeliculas(){
        return this.peliculaRepository.listar();
    }

    public Optional<Pelicula> encontrarPorId(int id){
        return this.peliculaRepository.encontrarPorId(id);
    }
}
