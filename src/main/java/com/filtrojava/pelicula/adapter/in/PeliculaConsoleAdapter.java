package com.filtrojava.pelicula.adapter.in;

import java.util.List;
import java.util.Optional;

import com.filtrojava.console.Util;

import com.filtrojava.pelicula.application.PeliculaService;
import com.filtrojava.pelicula.domain.Pelicula;

public class PeliculaConsoleAdapter {
   private final PeliculaService peliculaService;

   

    public PeliculaConsoleAdapter(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    String[] opciones = {
        "1. Agregar pelicula",
        "2. editar pelicula",
        "3. Eliminar pelicula",
        "4. Listar pelicula"

    };

    public void start(){
        System.out.println("----------------> MENU DE PELICULAS <---------------");
        for (String opcion : opciones){
            System.out.println(opcion);
        }
        int op = Util.validateOption(1, opciones.length);

        switch (op) {
            case 1 -> {
                System.out.println("... AGREGANDO PELICULAS ");

                String codigoNuevo = Util.getStringInput(">> Digite el codigo interno  de la Pelicula: ");
                String nombreNuevo = Util.getStringInput(">> Digite la descripcion de la  Pelicula: ");
                String duracionNueva = Util.getStringInput(">> Digite la duracion de la  Pelicula: ");
                String sinopsisNueva = Util.getStringInput(">> Digite la sinopsis de la  Pelicula: ");

                
                Pelicula nuevaPelicula = new Pelicula();
                nuevaPelicula.setNombre(nombreNuevo);
                nuevaPelicula.setCodigoInterno(codigoNuevo);
                nuevaPelicula.setDuracion(duracionNueva);
                nuevaPelicula.setSinopsis(sinopsisNueva);

                this.peliculaService.agregarPelicula(nuevaPelicula);
            }
        
            case 2 -> {
                System.out.println("... EDITANDO PELICULAS ");
                int idEditar = Util.getIntInput(">> Ingresa el id de LA PELICULA  a editar: ");

                Optional<Pelicula> PeliculaOpcional = this.peliculaService.encontrarPorId(idEditar);
                
                PeliculaOpcional.ifPresentOrElse(
                        PeliculaEncontrado -> {
                            String codigoNuevo = Util.getStringInput(">> Digite el codigo interno  de la Pelicula: ");
                            String nombreNuevo = Util.getStringInput(">> Digite la descripcion de la  Pelicula: ");
                            String duracionNueva = Util.getStringInput(">> Digite la duracion de la  Pelicula: ");
                            String sinopsisNueva = Util.getStringInput(">> Digite la sinopsis de la  Pelicula: ");       
                            
                            
                            
                            PeliculaEncontrado.setNombre(nombreNuevo);
                            PeliculaEncontrado.setCodigoInterno(codigoNuevo);
                            PeliculaEncontrado.setDuracion(duracionNueva);
                            PeliculaEncontrado.setSinopsis(sinopsisNueva);

                            this.peliculaService.editarPelicula(PeliculaEncontrado);
                        }, 
                        () -> {
                            System.out.println("la Pelicula no ha sido encontrada");
                        }
                );
            }

                case 3 -> {
                    System.out.println("... ELIMINANDO PELICULAS ");
                    int idEliminar = Util.getIntInput(">> Ingresa el id del Pelicula a eliminar: ");

                    Optional<Pelicula> PeliculaAEliminar = this.peliculaService.encontrarPorId(idEliminar);
                    
                    PeliculaAEliminar.ifPresentOrElse(
                            PeliculaEncontrado -> {
                                this.peliculaService.eliminarPelicula(idEliminar);
                            }, 
                            () -> {
                                System.out.println("El Pelicula no ha sido encontrado");
                            }
                    );
            }
                
                case 4 -> {
                    System.out.println("... LISTANDO PELICULAS ");
                    System.out.println("----------> PELICULAS DISPONIBLES <-------");
                   
                    List<Pelicula> PeliculasEncontrados =  this.peliculaService.listarPeliculas();

                    if (PeliculasEncontrados.isEmpty()){
                        System.out.println(">> No hay Peliculas registrados ");
                    } else {
                        PeliculasEncontrados.forEach(
                                Pelicula -> {System.out.println(Pelicula);}
                        );
                    }
            }
        }
    }
}
