package com.chadacademy.service.menu;

import com.chadacademy.dominio.*;
import java.util.*;
import com.chadacademy.service.archivos.ArchivoInvestigadoresService;
import com.chadacademy.service.experimentos.IExperimentoService;
import com.chadacademy.service.investigador.IInvestigadorService;
import com.chadacademy.utils.ConsolaUtils; 

public class MenuPrincipal {
    private final IInvestigadorService investigadorService;
    private final IExperimentoService experimentoService;
    private final ArchivoInvestigadoresService archivoInvestigadoresService;
    private final ConsolaUtils consolaUtils;
    
    public MenuPrincipal(
        IInvestigadorService investigadorService, 
        IExperimentoService experimentoService, 
        ArchivoInvestigadoresService archivoInvestigadoresService,
        ConsolaUtils consolaUtils) {
        this.investigadorService = investigadorService;
        this.experimentoService = experimentoService;
        this.archivoInvestigadoresService = archivoInvestigadoresService;
        this.consolaUtils = consolaUtils;
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n===== LABORATORIO CHAD =====");
            System.out.println("1. Registrar investigador");
            System.out.println("2. Registrar experimento químico");
            System.out.println("3. Registrar experimento físico");
            System.out.println("4. Mostrar todos los experimentos");
            System.out.println("5. Mostrar total de experimentos exitosos y fallidos");
            System.out.println("6. Mostrar experimento de mayor duración");
            System.out.println("7. Exportar investigadores a CSV");
            System.out.println("0. Salir");
            
            opcion = consolaUtils.leerEntero("Seleccione una opción: ");
        
            if (opcion < 0 || opcion > 7) { 
                System.out.println("Opción no válida.");
                continue;
        }   
            switch (opcion) {
                case 1 -> registrarInvestigador();
                case 2 -> registrarExperimentoQuimico();
                case 3 -> registrarExperimentoFisico();
                case 4 -> mostrarExperimentos();
                case 5 -> mostrarTotales();
                case 6 -> mostrarExperimentoMayorDuracion();
                case 7 -> exportarInvestigadoresCSV();
                case 0 -> System.out.println("Saliendo del sistema...");                
            }
        } while (opcion != 0);
    }

    private void registrarInvestigador() {
        String nombre = consolaUtils.leerString("Nombre del investigador: ");   
        int edad = consolaUtils.leerEntero("Edad del investigador: ");

        if (edad <= 0) {
            System.out.println("Error: La edad debe ser un número positivo.");
            return;
        }

        Investigador inv = new Investigador(nombre, edad);
        
        investigadorService.guardarInvestigador(inv); 
        System.out.println("Investigador registrado correctamente.\n");
    }

    private void registrarExperimentoQuimico() {
    List<Investigador> investigadoresDisponibles = investigadorService.buscarTodos();

    if (investigadoresDisponibles.isEmpty()) {
        System.out.println("Debe registrar al menos un investigador primero.");
        return;
    }

    String nombre = consolaUtils.leerString("Nombre del experimento: "); 
    int duracion = consolaUtils.leerEntero("Duración (minutos): ");  
    boolean exitoso = consolaUtils.leerBoolean("¿Fue exitoso? (true/false): ");
    String reactivo = consolaUtils.leerString("Tipo de reactivo: ");

    System.out.println("Seleccione un investigador existente:");
    mostrarInvestigadores(investigadoresDisponibles); 
        
    int index = consolaUtils.leerEntero("Ingrese el número del investigador: ") - 1; 

    Investigador investigador = (index >= 0 && index < investigadoresDisponibles.size())
        ? investigadoresDisponibles.get(index)
        : null;

    if (investigador == null) {
        System.out.println("Investigador no válido o índice fuera de rango.");
        return;
    }

    try {
        experimentoService.registrarExperimentoQuimico(nombre, duracion, exitoso, reactivo, investigador);
        System.out.println("Experimento químico registrado con éxito.\n");
    } catch (IllegalArgumentException e) {
        System.out.println("Error al crear experimento: " + e.getMessage());
    }
}
    
    private void registrarExperimentoFisico() {
        List<Investigador> investigadoresDisponibles = investigadorService.buscarTodos();

        if (investigadoresDisponibles.size() < 1) { 
            System.out.println("Debe registrar al menos un investigador primero.");
            return;
        }

        String nombre = consolaUtils.leerString("Nombre del experimento: ");
        int duracion = consolaUtils.leerEntero("Duración (minutos): ");
        boolean exitoso = consolaUtils.leerBoolean("¿Fue exitoso? (true/false): ");
        String instrumento = consolaUtils.leerString("Instrumento utilizado: ");

        List<Investigador> listaInv = new ArrayList<>();
        System.out.println("Seleccione investigadores (números separados por coma):");
        mostrarInvestigadores(investigadoresDisponibles); 
        String entrada = consolaUtils.leerString("Ejemplo: 1,2 -> ");
        String[] indices = entrada.split(",");

        for (String s : indices) {
            try {
                int i = Integer.parseInt(s.trim()) - 1;
                if (i >= 0 && i < investigadoresDisponibles.size()) {
                    listaInv.add(investigadoresDisponibles.get(i));
                }
            } catch (NumberFormatException e) {
                System.out.println("Número inválido ignorado: " + s);
            }
        }

        if (listaInv.isEmpty()) {
            System.out.println("No se seleccionaron investigadores válidos.");
            return;
        }

        try {
            experimentoService.registrarExperimentoFisico(nombre, duracion, exitoso, instrumento, listaInv);
            System.out.println("Experimento físico registrado con éxito.\n");
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear experimento: " + e.getMessage());
        }
    }

    private void mostrarExperimentos() {
        List<AbstractExperimento> experimentos = experimentoService.buscarTodos();

        if (experimentos.isEmpty()) {
            System.out.println("No hay experimentos registrados.");
            return;
    }

        System.out.println("\n===== LISTA DE EXPERIMENTOS =====");    
    
        for (AbstractExperimento e : experimentos) {
            System.out.println(e.getNombre() + " - Duración: " + e.getDuracion() + " min");
        }
        System.out.println("---------------------------------");
}

    private void mostrarTotales() {
        List<AbstractExperimento> experimentos = experimentoService.buscarTodos();

        if (experimentos.isEmpty()) {
            System.out.println("No hay experimentos registrados.");
            return;
        }
        
        long exitosos = experimentoService.contarExperimentosExitosos();
        long fallidos = experimentoService.contarExperimentosFallidos();
        
        System.out.println("Total de experimentos exitosos: " + exitosos);
        System.out.println("Total de experimentos fallidos: " + fallidos);
    }

    private void mostrarExperimentoMayorDuracion() {

        AbstractExperimento mayor = experimentoService.experimentoMayorDuracion();
        
        if (mayor == null) {
            System.out.println("No hay experimentos registrados.");
            return;
        }
        
        System.out.println("Experimento de mayor duración: " + mayor.getNombre() +
             " (" + mayor.getDuracion() + " min)");
    }
    
    private void mostrarInvestigadores(List<Investigador> investigadores) {
        if (investigadores.isEmpty()) {
            System.out.println("No hay investigadores registrados.");
            return;
        }
        int i = 1;
        for (Investigador inv : investigadores) {
            System.out.println(i++ + ". " + inv.getNombre() + " (" + inv.getEdad() + " años)");
        }
    }
    
    private void exportarInvestigadoresCSV() {
            archivoInvestigadoresService.exportarInvestigadoresCSV(investigadorService);
    }
}