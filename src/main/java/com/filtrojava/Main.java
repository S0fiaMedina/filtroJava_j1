package com.filtrojava;

import com.filtrojava.console.Initializer;
import com.filtrojava.console.Util;
import com.filtrojava.formato.adapter.in.FormatoConsoleAdapter;
import com.filtrojava.genero.adapter.in.GeneroConsoleAdapter;
import com.filtrojava.pais.adapter.in.PaisConsoleAdapter;
import com.filtrojava.pelicula.adapter.in.PeliculaConsoleAdapter;
import com.filtrojava.tipoActor.adapter.in.TipoActorConsoleAdapter;

public class Main {
    public static void main(String[] args) {
        Initializer initializer = new Initializer();

        GeneroConsoleAdapter generoConsoleAdapter= initializer.startGeneroModule();
        TipoActorConsoleAdapter tipoActorConsoleAdapter = initializer.startTipoActorModule();
        PeliculaConsoleAdapter peliculaConsoleAdapter = initializer.startPeliculaModule();
        PaisConsoleAdapter paisConsoleAdapter = initializer.startPaisModulo();
        FormatoConsoleAdapter formatoConsoleAdapter = initializer.startFormatoModule();


        /*
         * root - clave
         * 123456 - clave
        */
        String[] opciones = {
            "1: Gestión de Actores",
           "2: Gestión de Películas",
           "3: Gestión de Formatos",
           "4: Asignación de Actores a Películas",
           "5: Gestión de Géneros",
           "6: Gestión de Países",
           "7: Gestión de Tipos de Actores",
           "8: Consulta de Información Detallada de una Película",
           "9: Listar Actores por Película ",
           "10. salir"
        };

        boolean breaker = true;
        while(breaker){
                System.out.println("------------> BIENVENIDO A CINE CAMPUS <-------------");
            for (String opcion : opciones){
                System.out.println(opcion);
            }
            int op = Util.validateOption(1, opciones.length);
            switch (op) {
                case 1:
                System.out.println("No implementado.");
                    
                break;
            
                case 2:
                    peliculaConsoleAdapter.start();
                break;

                case 3:
                    formatoConsoleAdapter.start();
                break;
        
                case 4:
                    System.out.println("No implementado.");
                break;

                case 5:
                    generoConsoleAdapter.start();
                break;
            
                case 6:
                    paisConsoleAdapter.start();
                break;
                
                case 7:
                    tipoActorConsoleAdapter.start();
                break;
        
                case 8:
                    System.out.println("No implementado.");

                break;

                case 9:
                    System.out.println("No implementado.");

                break;

                case 10:
                    breaker = false;
                break;
            }
        }
        
    }


}