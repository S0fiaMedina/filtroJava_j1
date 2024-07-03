package com.filtrojava.pais.adapter.in;

import java.util.List;
import java.util.Optional;

import com.filtrojava.console.Util;
import com.filtrojava.pais.application.PaisService;
import com.filtrojava.pais.domain.Pais;

public class PaisConsoleAdapter {
    private final PaisService paisService;

    public PaisConsoleAdapter(PaisService paisService) {
        this.paisService = paisService;
    }

    String[] opciones = {
        "1. Agregar Pais",
        "2. editar Pais",
        "3. Eliminar Pais",
        "4. Listar Pais"

    };

    

    public void start(){
        System.out.println("----------------> MENU DE PAIS <---------------");
        for (String opcion : opciones){
            System.out.println(opcion);
        }
        int op = Util.validateOption(1, opciones.length);

        switch (op) {
            case 1 -> {
                System.out.println("... AGREGANDO PAIS ");
                String nombreNuevo = Util.getStringInput(">> Digite la descripcion del Pais: ");
                
                
                Pais nuevoPais = new Pais();
                nuevoPais.setDescripcion(nombreNuevo);
                this.paisService.agregarPais(nuevoPais);
            }
        
            case 2 -> {
                System.out.println("... EDITANDO PAIS ");
                int idEditar = Util.getIntInput(">> Ingresa el id del Pais a editar: ");

                Optional<Pais> PaisOpcional = this.paisService.encontrarPorId(idEditar);
                
                PaisOpcional.ifPresentOrElse(
                        PaisEncontrado -> {
                            String nuevaDescripcion = Util.getStringInput(">> Digite la nueva descripcion del Pais: ");
                            
                            
                            PaisEncontrado.setDescripcion(nuevaDescripcion);
                            this.paisService.editarPais(PaisEncontrado);
                            
                            
                        }, 
                        () -> {
                            System.out.println("El Pais no ha sido encontrado");
                        }
                );
            }

                case 3 -> {
                    System.out.println("... ELIMINANDO PAIS ");
                    int idEliminar = Util.getIntInput(">> Ingresa el id del Pais a editar: ");

                    Optional<Pais> PaisAEliminar = this.paisService.encontrarPorId(idEliminar);
                    
                    PaisAEliminar.ifPresentOrElse(
                            PaisEncontrado -> {
                                this.paisService.eliminarPais(idEliminar);
                            }, 
                            () -> {
                                System.out.println("El Pais no ha sido encontrado");
                            }
                    );
            }
                
                case 4 -> {
                    System.out.println("... LISTANDO PAISES ");
                    System.out.println("----------> PAISES DISPONIBLES <-------");
                   
                    List<Pais> paisesEncontrados =  this.paisService.listarPaiss();

                    if (paisesEncontrados.isEmpty()){
                        System.out.println(">> No hay Paiss registrados ");
                    } else {
                        paisesEncontrados.forEach(
                                Pais -> {System.out.println(Pais);}
                        );
                    }
            }
        }
    }
}
