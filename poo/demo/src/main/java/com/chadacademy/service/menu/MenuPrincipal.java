package com.chadacademy.service.menu;

import com.chadacademy.dominio.*;
import java.util.*;
import com.chadacademy.service.archivos.ArchivoInvestigadoresService;
import com.chadacademy.service.experimentos.IExperimentoService;
import com.chadacademy.service.investigador.IInvestigadorService; 

public class MenuPrincipal {
    
    // interfaces
    private final IInvestigadorService investigadorService;
    private final IExperimentoService experimentoService;
    private final ArchivoInvestigadoresService archivoInvestigadoresService;
    private final Scanner scanner = new Scanner(System.in);

    // constructor
    public MenuPrincipal(
        IInvestigadorService investigadorService, 
        IExperimentoService experimentoService, 
        ArchivoInvestigadoresService archivoInvestigadoresService) {
        this.investigadorService = investigadorService;
        this.experimentoService = experimentoService;
        this.archivoInvestigadoresService = archivoInvestigadoresService;
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
            System.out.print("Seleccione una opción: ");
            
            // Manejo de la entrada del usuario
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); 
            } else {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                scanner.nextLine(); // !!!!
                opcion = -1; // Opción inválida
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
                default -> {
                    if (opcion != -1) { 
                        System.out.println("Opción no válida.");
                    }
                }
            }
        } while (opcion != 0);
    }

    // OPCIÓN 1 (DELEGACIÓN AL SERVICE)
    private void registrarInvestigador() {
        System.out.print("Nombre del investigador: ");
        String nombre = scanner.nextLine();

        System.out.print("Edad del investigador: ");
        
        int edad = 0;
        if (scanner.hasNextInt()) {
            edad = scanner.nextInt();
            scanner.nextLine();
        } else {
            System.out.println("Edad no válida. Registro cancelado.");
            scanner.nextLine();
            return;
        }

        Investigador inv = new Investigador(nombre, edad);
        
        investigadorService.guardarInvestigador(inv); 
        System.out.println("Investigador registrado correctamente.\n");
    }

    // ------------ OPCIÓN 2 (DELEGACIÓN AL SERVICE)
    private void registrarExperimentoQuimico() {
        List<Investigador> investigadoresDisponibles = investigadorService.buscarTodos();

        if (investigadoresDisponibles.isEmpty()) {
            System.out.println("⚠️ Debe registrar al menos un investigador primero.");
            return;
        }

        System.out.print("Nombre del experimento: ");
        String nombre = scanner.nextLine();

        System.out.print("Duración (minutos): ");
        int duracion = scanner.nextInt();
        scanner.nextLine();

        System.out.print("¿Fue exitoso? (true/false): ");
        boolean exitoso = scanner.nextBoolean();
        scanner.nextLine();

        System.out.print("Tipo de reactivo: ");
        String reactivo = scanner.nextLine();

        System.out.println("Seleccione un investigador existente:");
        mostrarInvestigadores(investigadoresDisponibles); // list inv
        System.out.print("Ingrese el número del investigador: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        Investigador investigador = (index >= 0 && index < investigadoresDisponibles.size())
            ? investigadoresDisponibles.get(index)
            : null;

        if (investigador == null) {
            System.out.println("Investigador no válido o índice fuera de rango.");
            return;
        }

        try {
            ExperimentoQuimico exp = new ExperimentoQuimico(nombre, duracion, exitoso, reactivo, investigador);
            experimentoService.agregarExperimento(exp);
            System.out.println("Experimento químico registrado con éxito.\n");
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear experimento: " + e.getMessage());
        }
    }
    
    // ----- OPCIÓN 3 (DELEGACIÓN AL SERVICE)
    private void registrarExperimentoFisico() {
        List<Investigador> investigadoresDisponibles = investigadorService.buscarTodos();

        if (investigadoresDisponibles.size() < 1) { 
            System.out.println("⚠️ Debe registrar al menos un investigador primero.");
            return;
        }
        
        System.out.print("Nombre del experimento: ");
        String nombre = scanner.nextLine();

        System.out.print("Duración (minutos): ");
        int duracion = scanner.nextInt();
        scanner.nextLine();

        System.out.print("¿Fue exitoso? (true/false): ");
        boolean exitoso = scanner.nextBoolean();
        scanner.nextLine();

        System.out.print("Instrumento utilizado: ");
        String instrumento = scanner.nextLine();

        List<Investigador> listaInv = new ArrayList<>();
        System.out.println("Seleccione investigadores (números separados por coma):");
        mostrarInvestigadores(investigadoresDisponibles); 
        System.out.print("Ejemplo: 1,2 -> ");
        String entrada = scanner.nextLine();
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
            ExperimentoFisico exp = new ExperimentoFisico(nombre, duracion, exitoso, instrumento, listaInv);
            // !!!!
            experimentoService.agregarExperimento(exp);
            System.out.println("Experimento físico registrado con éxito.\n");
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear experimento: " + e.getMessage());
        }
    }

    // ------- OPCIÓN 4 (DELEGACIÓN AL SERVICE)
    private void mostrarExperimentos() {
        
        experimentoService.mostrarExperimentos();
    }

    // ------ OPCIÓN 5 (LÓGICA CON DATOS)
    private void mostrarTotales() {
        // Pedimos la lista al Servicio para hacer el cálculo de la I.U.
        List<AbstractExperimento> experimentos = experimentoService.buscarTodos();

        if (experimentos.isEmpty()) {
            System.out.println("No hay experimentos registrados.");
            return;
        }

        long exitosos = experimentos.stream().filter(AbstractExperimento::isExitoso).count();
        long fallidos = experimentos.size() - exitosos;

        System.out.println("Total de experimentos exitosos: " + exitosos);
        System.out.println("Total de experimentos fallidos: " + fallidos);
    }

    // ------ OPCIÓN 6 (DELEGACIÓN AL SERVICE)
    private void mostrarExperimentoMayorDuracion() {
        // Delegamos el cálculo al Servicio
        AbstractExperimento mayor = experimentoService.experimentoMayorDuracion();
        
        if (mayor == null) {
            System.out.println("No hay experimentos registrados.");
            return;
        }
        
        System.out.println("Experimento de mayor duración: " + mayor.getNombre() +
             " (" + mayor.getDuracion() + " min)");
    }

    // Método auxiliar para mostrar investigadores (usa la lista pasada)
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
    
    private void mostrarInvestigadores() {
        List<Investigador> investigadoresDisponibles = investigadorService.buscarTodos();
        mostrarInvestigadores(investigadoresDisponibles);
    }
    
    private void exportarInvestigadoresCSV() {
        // Pedimos la lista al Servicio de Investigadores
        List<Investigador> investigadoresDisponibles = investigadorService.buscarTodos();
        if (investigadoresDisponibles == null || investigadoresDisponibles.isEmpty()) {
            System.out.println("⚠️ No hay investigadores registrados para exportar.");
            return;
        }
        // Delegamos el trabajo de E/S de archivos al servicio ArchivoInvestigadoresService
        archivoInvestigadoresService.exportarInvestigadoresCSV(investigadoresDisponibles);
    }
}