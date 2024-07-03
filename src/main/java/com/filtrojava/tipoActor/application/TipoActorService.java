package com.filtrojava.tipoActor.application;

import java.util.List;
import java.util.Optional;

import com.filtrojava.tipoActor.domain.TipoActor;
import com.filtrojava.tipoActor.infrastructure.TipoActorRepository;




public class TipoActorService {
    private final TipoActorRepository tipoActorRepository;

    
    public TipoActorService(TipoActorRepository tipoActorRepository) {
        this.tipoActorRepository = tipoActorRepository;
    }

    public void agregarTipoActor(TipoActor tipoActor){
        this.tipoActorRepository.agregar(tipoActor);
    }

    public void editarTipoActor(TipoActor tipoActor){
        this.tipoActorRepository.editar( tipoActor);

    }

    public void eliminarTipoActor(int id){
        this.tipoActorRepository.eliminar( id);

    }

    public List<TipoActor> listarTipoActores(){
        return this.tipoActorRepository.listar();
    }

    public Optional<TipoActor> encontrarPorId(int id){
        return this.tipoActorRepository.encontrarPorId(id);
    }
}
