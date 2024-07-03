package com.filtrojava.formato.application;

import java.util.List;
import java.util.Optional;

import com.filtrojava.formato.domain.Formato;
import com.filtrojava.formato.infrastructure.FormatoRepository;

public class FormatoService {
    private final FormatoRepository FormatoRepository;

    
    public FormatoService(FormatoRepository FormatoRepository) {
        this.FormatoRepository = FormatoRepository;
    }

    public void agregarFormato(Formato formato){
        this.FormatoRepository.agregar(formato);
    }

    public void editarFormato(Formato formato){
        this.FormatoRepository.editar(formato);

    }

    public void eliminarFormato(int id){
        this.FormatoRepository.eliminar(id);

    }

    public List<Formato> listarFormatos(){
        return this.FormatoRepository.listar();
    }

    public Optional<Formato> encontrarPorId(int id){
        return this.FormatoRepository.encontrarPorId(id);
    }
}
