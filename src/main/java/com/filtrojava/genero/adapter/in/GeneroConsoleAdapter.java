package com.filtrojava.genero.adapter.in;

import java.util.List;
import java.util.Optional;

import com.filtrojava.console.Util;
import com.filtrojava.genero.application.GeneroService;
import com.filtrojava.genero.domain.Genero;

public class GeneroConsoleAdapter {
    private final GeneroService generoService;
    
    public GeneroConsoleAdapter(GeneroService generoService) {
        this.generoService = generoService;
    }

    String[] opciones = {
        "1. Agregar genero",
        "2. editar genero",
        "3. Eliminar genero",
        "4. Listar genero"
        
    };

    

    public void start(){
        System.out.println("----------------> MENU DE GENEROS <---------------");
        for (String opcion : opciones){
            System.out.println(opcion);
        }
        int op = Util.validateOption(1, opciones.length);

        switch (op) {
            case 1 -> {
                System.out.println("... AGREGANDO GENEROS ");
                String nombreNuevo = Util.getStringInput(">> Digite la descripcion del genero: ");
                
                
                Genero nuevoGenero = new Genero();
                nuevoGenero.setDescripcion(nombreNuevo);
                this.generoService.agregarGenero(nuevoGenero);
            }
        
            case 2 -> {
                System.out.println("... EDITANDO GENEROS ");
                int idEditar = Util.getIntInput(">> Ingresa el id del genero a editar: ");

                Optional<Genero> generoOpcional = this.generoService.encontrarPorId(idEditar);
                
                generoOpcional.ifPresentOrElse(
                        generoEncontrado -> {
                            String nuevaDescripcion = Util.getStringInput(">> Digite la nueva descripcion del genero: ");
                            
                            
                            generoEncontrado.setDescripcion(nuevaDescripcion);
                            this.generoService.editarGenero(generoEncontrado);
                            
                            
                        }, 
                        () -> {
                            System.out.println("El genero no ha sido encontrado");
                        }
                );
            }

                case 3 -> {
                    System.out.println("... ELIMINANDO GENEROS ");
                    int idEliminar = Util.getIntInput(">> Ingresa el id del genero a editar: ");

                    Optional<Genero> generoAEliminar = this.generoService.encontrarPorId(idEliminar);
                    
                    generoAEliminar.ifPresentOrElse(
                            generoEncontrado -> {
                                this.generoService.eliminarGenero(idEliminar);
                            }, 
                            () -> {
                                System.out.println("El genero no ha sido encontrado");
                            }
                    );
            }
                
                case 4 -> {
                    System.out.println("... LISTANDO GENEROS ");
                    System.out.println("----------> GENEROS DISPONIBLES <-------");
                   
                    List<Genero> generosEncontrados =  this.generoService.listarGeneros();

                    if (generosEncontrados.isEmpty()){
                        System.out.println(">> No hay generos registrados ");
                    } else {
                        generosEncontrados.forEach(
                                genero -> {System.out.println(genero);}
                        );
                    }
            }
        }
    }
}
