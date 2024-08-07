package com.filtrojava.actor.infrastructure;

import java.util.List;
import java.util.Optional;

import com.filtrojava.actor.domain.Actor;

public interface ActorRepository {

    public void agregar(Actor actor);
    public void editar(Actor actor);
    public void eliminar(int id);
    public List<Actor> listar();
    public Optional<Actor> encontrarPorId(int id);
    
}
