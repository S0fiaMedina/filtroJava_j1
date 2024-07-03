package com.filtrojava;

import com.filtrojava.console.Initializer;
import com.filtrojava.console.Util;
import com.filtrojava.genero.adapter.in.GeneroConsoleAdapter;
import com.filtrojava.tipoActor.adapter.in.TipoActorConsoleAdapter;

public class Main {
    public static void main(String[] args) {
        Initializer initializer = new Initializer();

        GeneroConsoleAdapter generoConsoleAdapter= initializer.startGeneroModule();
        TipoActorConsoleAdapter tipoActorConsoleAdapter = initializer.startTipoActorModule();

        String[] opciones = {
            "1: Gestión de Actores",
           " 2: Gestión de Películas",
           " 3: Gestión de Formatos",
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
                    
                break;
            
                case 2:
                
                break;

                case 3:
                    
                break;
        
                case 4:
                
                break;

                case 5:
                    generoConsoleAdapter.start();
                break;
            
                case 6:
                    
                break;
                
                case 7:
                    tipoActorConsoleAdapter.start();
                break;
        
                case 8:
                
                break;

                case 9:
                
                break;

                case 10:
                    breaker = false;
                break;
            }
        }
        
    }


}