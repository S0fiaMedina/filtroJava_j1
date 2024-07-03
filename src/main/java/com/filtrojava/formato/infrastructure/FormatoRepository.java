package com.filtrojava.formato.infrastructure;

import java.util.List;
import java.util.Optional;

import com.filtrojava.formato.domain.Formato;

public interface FormatoRepository {
    public void agregar(Formato formato);
    public void editar(Formato formato);
    public void eliminar(int id);
    public List<Formato> listar();
    public Optional<Formato> encontrarPorId(int id);
}
