package com.filtrojava.pelicula.infrastructure;

import java.util.List;
import java.util.Optional;

import com.filtrojava.pelicula.domain.Pelicula;



public interface PeliculaRepository {
    public void agregar(Pelicula pelicula);
    public void editar(Pelicula pelicula);
    public void eliminar(int id);
    public List<Pelicula> listar();
    public Optional<Pelicula> encontrarPorId(int id);
}
