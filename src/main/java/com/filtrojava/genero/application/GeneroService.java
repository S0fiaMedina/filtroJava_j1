package com.filtrojava.genero.application;

import java.util.List;
import java.util.Optional;

import com.filtrojava.genero.domain.Genero;
import com.filtrojava.genero.infrastructure.GeneroRepository;

public class GeneroService {
    private final GeneroRepository generoRepository;

    
    public GeneroService(GeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }

    public void agregarGenero(Genero genero){
        this.generoRepository.agregar(genero);
    }

    public void editarGenero(Genero genero){
        this.generoRepository.editar( genero);

    }

    public void eliminarGenero(int id){
        this.generoRepository.eliminar( id);

    }

    public List<Genero> listarGeneros(){
        return this.generoRepository.listar();
    }

    public Optional<Genero> encontrarPorId(int id){
        return this.generoRepository.encontrarPorId(id);
    }
}
