package com.filtrojava.actor.application;

import java.util.List;
import java.util.Optional;

import com.filtrojava.actor.domain.Actor;
import com.filtrojava.actor.infrastructure.ActorRepository;

public class ActorService {
    private final ActorRepository actorRepository;

    
    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public void agregarActor(Actor Actor){
        this.actorRepository.agregar(Actor);
    }

    public void editarActor(Actor Actor){
        this.actorRepository.editar(Actor);

    }

    public void eliminarActor(int id){
        this.actorRepository.encontrarPorId(id);
    }

    public List<Actor> listarActores(){
        return this.actorRepository.listar();
    }


    public Optional<Actor> encontrarPorId(int id){
        return this.actorRepository.encontrarPorId(id);
    }
}
