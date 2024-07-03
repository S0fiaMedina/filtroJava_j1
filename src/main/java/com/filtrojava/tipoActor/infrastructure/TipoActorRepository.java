package com.filtrojava.tipoActor.infrastructure;

import java.util.List;
import java.util.Optional;

import com.filtrojava.tipoActor.domain.TipoActor;


public interface TipoActorRepository {
    
    public void agregar(TipoActor tipoActor);

    public void editar(TipoActor tipoActor);

    public void eliminar(int id);

    public List<TipoActor> listar();

    public Optional<TipoActor> encontrarPorId(int id);

}
