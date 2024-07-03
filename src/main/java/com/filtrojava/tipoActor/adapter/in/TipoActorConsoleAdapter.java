package com.filtrojava.tipoActor.adapter.in;

import java.util.List;
import java.util.Optional;

import com.filtrojava.console.Util;
import com.filtrojava.tipoActor.application.TipoActorService;
import com.filtrojava.tipoActor.domain.TipoActor;


public class TipoActorConsoleAdapter {
    private TipoActorService tipoActorService;
    
    

    

    public TipoActorConsoleAdapter(TipoActorService tipoActorService) {
        this.tipoActorService = tipoActorService;
    }

    String[] opciones = {
        "1. Agregar tipo de actor",
        "2. editar tipo de actor",
        "3. Eliminar tipo de actor",
        "4. Listar tipo de actor",
        "5. Salir"

    };

    

    public void start(){
        System.out.println("----------------> MENU DE TIPOS DE ACTORES <---------------");
        for (String opcion : opciones){
            System.out.println(opcion);
        }
        int op = Util.validateOption(1, opciones.length);

        switch (op) {
            case 1:
                
                System.out.println("... AGREGANDO TIPOS DE ACTORES ");
                String nombreNuevo = Util.getStringInput(">> Digite la descripcion del tipoActor: ");


                TipoActor nuevoTipoActor = new TipoActor();
                nuevoTipoActor.setDescripcion(nombreNuevo);
                this.tipoActorService.agregarTipoActor(nuevoTipoActor);
                break;
        
            case 2:
                System.out.println("... EDITANDO TIPOS DE ACTORES ");
                int idEditar = Util.getIntInput(">> Ingresa el id del tipoActor a editar: ");

                Optional<TipoActor> tipoActorOpcional = this.tipoActorService.encontrarPorId(idEditar);
                
                tipoActorOpcional.ifPresentOrElse(
                    tipoActorEncontrado -> {
                        String nuevaDescripcion = Util.getStringInput(">> Digite la nueva descripcion del tipo de actor: ");

                        
                        tipoActorEncontrado.setDescripcion(nuevaDescripcion);
                        this.tipoActorService.editarTipoActor(tipoActorEncontrado);


                    }, 
                        () -> {
                            System.out.println("El tipoActor no ha sido encontrado");
                        }
                    );
               
                break;

                case 3:
                    System.out.println("... ELIMINANDO TIPOS DE ACTORES ");
                    int idEliminar = Util.getIntInput(">> Ingresa el id del tipo de actor a editar: ");

                    Optional<TipoActor> tipoActorAEliminar = this.tipoActorService.encontrarPorId(idEliminar);
                    
                    tipoActorAEliminar.ifPresentOrElse(
                        tipoActorEncontrado -> {
                            this.tipoActorService.eliminarTipoActor(idEliminar);
                        }, 
                            () -> {
                                System.out.println("El tipoActor no ha sido encontrado");
                            }
                        );
                break;
                
                case 4: 

                    System.out.println("... LISTANDO TIPOS DE ACTORES ");
                    System.out.println("----------> TIPOS DE ACTORES DISPONIBLES <-------");
                   
                    List<TipoActor> tipoActorsEncontrados =  this.tipoActorService.listarTipoActores();

                    if (tipoActorsEncontrados.isEmpty() || tipoActorsEncontrados == null){
                        System.out.println(">> No hay tipos de actores registrados ");
                    } else {
                        tipoActorsEncontrados.forEach(
                            tipoActor -> {System.out.println(tipoActor);}
                        );
                    }
                    
            
                break;

                case 5:
                break;
        }
    }
}
