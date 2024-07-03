package com.filtrojava.genero.adapter.in;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.filtrojava.genero.application.GeneroService;
import com.filtrojava.genero.domain.Genero;

public class GeneroConsoleAdapter {
    private GeneroService generoService;
    
    

    

    public GeneroConsoleAdapter(GeneroService generoService) {
        this.generoService = generoService;
    }

    String[] opciones = {
        "1. Agregar genero",
        "2. editar genero",
        "3. Eliminar genero",
        "4. Listar genero"

    };

    public int validateOption(){
        while (true) {
            try {
                int op = sc.nextInt(); 
                if (op >= 1 || op <= opciones.length){
                    return op;
                } else{
                    System.out.println(">> Ingrese una opcion valida");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero entero: ");
            }
        }
    }

    public void start(){
        System.out.println("----------------> MENU DE GENEROS <---------------");
        for (String opcion : opciones){
            System.out.println(opcion);
        }
        System.out.println(">> Ingrese la opcion de su preferencia: ");
        int op = this.validateOption();

        switch (op) {
            case 1:
                
                System.out.println("... AGREGANDO GENEROS ");
                System.out.println(">> Digite la descripcion del genero: ");
                String nombreNuevo = sc.nextLine();

                Genero nuevoGenero = new Genero();
                nuevoGenero.setDescripcion(nombreNuevo);
                this.generoService.agregarGenero(nuevoGenero);
                break;
        
            case 2:
                System.out.println("... EDITANDO GENEROS ");
                System.out.println(">> Digite el id del genero: ");
                int idEditar = sc.nextInt();

                Optional<Genero> generoOpcional = this.generoService.encontrarPorId(idEditar);
                
                generoOpcional.ifPresentOrElse(
                    generoEncontrado -> {
                        System.out.println(">> Digite la  nueva descripcion del genero: ");
                        String nuevaDescripcion = sc.nextLine();
                        
                        generoEncontrado.setDescripcion(nuevaDescripcion);
                        this.generoService.editarGenero(generoEncontrado);


                    }, 
                        () -> {
                            System.out.println("El genero no ha sido encontrado");
                        }
                    );
               
                break;
                
                case 4: 

                    System.out.println("... LISTANDO GENEROS ");
                    System.out.println("----------> GENEROS DISPONIBLES <-------");
                   
                    List<Genero> generosEncontrados =  this.generoService.listarGeneros();

                    if (generosEncontrados.isEmpty() || generosEncontrados == null){
                        System.out.println(">> No hay generos registrados ");
                    } else {
                        generosEncontrados.forEach(
                            genero -> {System.out.println(genero);}
                        );
                    }
                    
            
                break;
        }
    }
}
