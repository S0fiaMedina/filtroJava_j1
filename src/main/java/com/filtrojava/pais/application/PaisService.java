package com.filtrojava.pais.application;

import java.util.List;
import java.util.Optional;

import com.filtrojava.pais.domain.Pais;
import com.filtrojava.pais.infrastructure.PaisRepository;

public class PaisService {
    private final PaisRepository paisRepository;

    
    public PaisService(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    public void agregarPais(Pais pais){
        this.paisRepository.agregar(pais);
    }

    public void editarPais(Pais pais){
        this.paisRepository.editar( pais);

    }

    public void eliminarPais(int id){
        this.paisRepository.eliminar( id);

    }

    public List<Pais> listarPaiss(){
        return this.paisRepository.listar();
    }

    public Optional<Pais> encontrarPorId(int id){
        return this.paisRepository.encontrarPorId(id);
    }
}
