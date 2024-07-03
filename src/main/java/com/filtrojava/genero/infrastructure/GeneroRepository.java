package com.filtrojava.genero.infrastructure;

import java.util.List;
import java.util.Optional;

import com.filtrojava.genero.domain.Genero;



public interface GeneroRepository {
    
    public void agregar(Genero genero);

    public void editar(Genero genero);

    public void eliminar(int id);

    public List<Genero> listar();

    public Optional<Genero> encontrarPorId(int id);

}
