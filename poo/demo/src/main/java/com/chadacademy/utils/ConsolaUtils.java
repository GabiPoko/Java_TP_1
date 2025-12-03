package com.chadacademy.utils;

import java.util.Scanner;

public class ConsolaUtils {

    private final Scanner scanner;

    public ConsolaUtils(Scanner scanner) {
        this.scanner = scanner;
    }

    public String leerString(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public int leerEntero(String mensaje) {
        int valor = -1;
        boolean entradaValida = false;
        
        while (!entradaValida) {
            System.out.print(mensaje);
            if (scanner.hasNextInt()) {
                valor = scanner.nextInt();
                entradaValida = true;
            } else {
                System.out.println("Error: Debe ingresar un número entero válido.");
            }
        
            scanner.nextLine(); 
        }
        return valor;
    }

    
    public boolean leerBoolean(String mensaje) {
        boolean valor = false;
        boolean entradaValida = false;
        
        while (!entradaValida) {
            System.out.print(mensaje + " (true/false): ");
            if (scanner.hasNextBoolean()) {
                valor = scanner.nextBoolean();
                entradaValida = true;
            } else {
                System.out.println("Error: Debe ingresar 'true' o 'false'.");
            }
            
            scanner.nextLine(); 
        }
        return valor;
    }
    
    
}