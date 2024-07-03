package com.filtrojava.console;

import java.util.Scanner;

@SuppressWarnings("resource")
public class Util {
    public static String getStringInput(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        while(true){
            String input = scanner.nextLine().trim();
            if (input.equals("")){
                System.out.println(">> No se aceptan cadenas vacias");
            } else{
                return input;
            }

        }
    }

    public static int getIntInput(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        while(true){
            String input = scanner.nextLine().trim();
            try {
                int num = Integer.parseInt(input);
                if (num  > 0){
                    return num;
                } else {
                    System.out.println(">> No se aceptan numeros negativos");
                }

            } catch (NumberFormatException e) {
                System.out.println(">> Ingresa un numero entero");
            }
        }
    }

    public static int validateOption(int min, int max){
        System.out.println(">> Seleccione una opcion: ");
        Scanner scanner = new Scanner(System.in);
        while(true){
            String input = scanner.nextLine().trim();
            try {
                int num = Integer.parseInt(input);
                if (num >= min || num<= max){
                    return num;
                } else {
                    System.out.println(">> Ingresa un numero dentro del rango");
                }

            } catch (NumberFormatException e) {
                System.out.println(">> Ingresa un numero entero");
            }
        }
    }
}
