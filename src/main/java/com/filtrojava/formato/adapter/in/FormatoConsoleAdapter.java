package com.filtrojava.formato.adapter.in;

import java.util.List;
import java.util.Optional;

import com.filtrojava.console.Util;
import com.filtrojava.formato.application.FormatoService;
import com.filtrojava.formato.domain.Formato;

public class FormatoConsoleAdapter {
    private final FormatoService FormatoService;
    
    public FormatoConsoleAdapter(FormatoService FormatoService) {
        this.FormatoService = FormatoService;
    }

    String[] opciones = {
        "1. Agregar Formato",
        "2. editar Formato",
        "3. Eliminar Formato",
        "4. Listar Formato"

    };

    public void start(){
        System.out.println("----------------> MENU DE FORMATOS <---------------");
        for (String opcion : opciones){
            System.out.println(opcion);
        }
        int op = Util.validateOption(1, opciones.length);

        switch (op) {
            case 1 -> {
                System.out.println("... AGREGANDO FORMATOS ");
                String nombreNuevo = Util.getStringInput(">> Digite la descripcion del Formato: ");
                
                
                Formato nuevoFormato = new Formato();
                nuevoFormato.setDescripcion(nombreNuevo);
                this.FormatoService.agregarFormato(nuevoFormato);
            }
        
            case 2 -> {
                System.out.println("... EDITANDO FORMATOS ");
                int idEditar = Util.getIntInput(">> Ingresa el id del Formato a editar: ");

                Optional<Formato> FormatoOpcional = this.FormatoService.encontrarPorId(idEditar);
                
                FormatoOpcional.ifPresentOrElse(
                        FormatoEncontrado -> {
                            String nuevaDescripcion = Util.getStringInput(">> Digite la nueva descripcion del Formato: ");
                            FormatoEncontrado.setDescripcion(nuevaDescripcion);
                            this.FormatoService.editarFormato(FormatoEncontrado);                            
                        }, 
                        () -> {
                            System.out.println("El Formato no ha sido encontrado");
                        }
                );
            }

                case 3 -> {
                    System.out.println("... ELIMINANDO FORMATOS ");
                    int idEliminar = Util.getIntInput(">> Ingresa el id del Formato a editar: ");

                    Optional<Formato> FormatoAEliminar = this.FormatoService.encontrarPorId(idEliminar);
                    
                    FormatoAEliminar.ifPresentOrElse(
                            FormatoEncontrado -> {
                                this.FormatoService.eliminarFormato(idEliminar);
                            }, 
                            () -> {
                                System.out.println("El Formato no ha sido encontrado");
                            }
                    );
            }
                
                case 4 -> {
                    System.out.println("... LISTANDO FORMATOS ");
                    System.out.println("----------> FORMATOS DISPONIBLES <-------");
                   
                    List<Formato> FormatosEncontrados =  this.FormatoService.listarFormatos();

                    if (FormatosEncontrados.isEmpty()){
                        System.out.println(">> No hay Formatos registrados ");
                    } else {
                        FormatosEncontrados.forEach(
                                Formato -> {System.out.println(Formato);}
                        );
                    }
            }
        }
    }
}
