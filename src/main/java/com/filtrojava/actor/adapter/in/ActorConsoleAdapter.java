package com.filtrojava.actor.adapter.in;

import java.util.List;
import java.util.Optional;

import com.filtrojava.actor.application.ActorService;
import com.filtrojava.actor.domain.Actor;
import com.filtrojava.console.Util;

public class ActorConsoleAdapter {
    private final ActorService actorService;
    
    public ActorConsoleAdapter(ActorService actorService) {
        this.actorService = actorService;
    }

    String[] opciones = {
        "1. Agregar Actor",
        "2. editar Actor",
        "3. Eliminar Actor",
        "4. Listar Actor"

    };

    public void start(){
        System.out.println("----------------> MENU DE ACTORES <---------------");
        for (String opcion : opciones){
            System.out.println(opcion);
        }
        int op = Util.validateOption(1, opciones.length);

        switch (op) {
            case 1 -> {
                System.out.println("... AGREGANDO ACTORES ");
                String nombreNuevo = Util.getStringInput(">> Digite el nombre del Actor: ");
                int edadNueva = Util.getIntInput(">> Digite la nueva edad: ");
                
        
                Actor nuevoActor = new Actor();
                nuevoActor.setNombre(nombreNuevo);
                nuevoActor.setEdad(edadNueva);
                this.actorService.agregarActor(nuevoActor);
            }
        
            case 2 -> {
                System.out.println("... EDITANDO ACTORES ");
                int idEditar = Util.getIntInput(">> Ingresa el id del Actor a editar: ");

                Optional<Actor> ActorOpcional = this.actorService.encontrarPorId(idEditar);
                
                ActorOpcional.ifPresentOrElse(
                        ActorEncontrado -> {
                            String nuevaNombre = Util.getStringInput(">> Digite el nueva Nombre del Actor: ");
                            ActorEncontrado.setNombre(nuevaNombre);
                            this.actorService.editarActor(ActorEncontrado);                            
                        }, 
                        () -> {
                            System.out.println("El Actor no ha sido encontrado");
                        }
                );
            }

                case 3 -> {
                    System.out.println("... ELIMINANDO ACTOR ");
                    int idEliminar = Util.getIntInput(">> Ingresa el id del Actor a editar: ");

                    Optional<Actor> ActorAEliminar = this.actorService.encontrarPorId(idEliminar);
                    
                    ActorAEliminar.ifPresentOrElse(
                            ActorEncontrado -> {
                                this.actorService.eliminarActor(idEliminar);
                            }, 
                            () -> {
                                System.out.println("El Actor no ha sido encontrado");
                            }
                    );
            }
                
                case 4 -> {
                    System.out.println("... LISTANDO ACTORES ");
                    System.out.println("----------> ACTORES DISPONIBLES <-------");
                   
                    List<Actor> ActorsEncontrados =  this.actorService.listarActores();

                    if (ActorsEncontrados.isEmpty()){
                        System.out.println(">> No hay ACTORES registrados ");
                    } else {
                        ActorsEncontrados.forEach(
                                Actor -> {System.out.println(Actor);}
                        );
                    }
            }
        }
    }
}
