package com.filtrojava.peliculaProtagonista.infrastructure;

import java.util.List;
import java.util.Optional;





public interface PeliculaProtagonistaRepository {
    public void agregar(Pelicula pelicula);
    public void editar(Pelicula pelicula);
    public void eliminar(int id);
    public List<Pelicula> listar();
    public Optional<Pelicula> encontrarPorId(int id);
}