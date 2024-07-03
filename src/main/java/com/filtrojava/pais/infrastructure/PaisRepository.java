package com.filtrojava.pais.infrastructure;

import java.util.List;
import java.util.Optional;

import com.filtrojava.pais.domain.Pais;



public interface PaisRepository {
    
    public void agregar(Pais pais);
    public void editar(Pais pais);
    public void eliminar(int id);
    public List<Pais> listar();
    public Optional<Pais> encontrarPorId(int id);

}
