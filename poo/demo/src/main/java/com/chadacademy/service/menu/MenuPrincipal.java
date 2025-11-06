package com.chadacademy.service.menu;

import com.chadacademy.dominio.*;
import java.util.*;
import com.chadacademy.service.archivos.ArchivoInvestigadoresService;
import com.chadacademy.service.archivos.Impl.ArchivoInvestigadoresServiceImpl;

public class MenuPrincipal {
    private List<Investigador> investigadores = new ArrayList<>();
    private List<AbstractExperimento> experimentos = new ArrayList<>();
    private ArchivoInvestigadoresService archivoInvestigadoresService = new ArchivoInvestigadoresServiceImpl();
    private Scanner scanner = new Scanner(System.in);

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
            opcion = scanner.nextInt();
            scanner.nextLine(); //----------

            switch (opcion) {
                case 1 -> registrarInvestigador();
                case 2 -> registrarExperimentoQuimico();
                case 3 -> registrarExperimentoFisico();
                case 4 -> mostrarExperimentos();
                case 5 -> mostrarTotales();
                case 6 -> mostrarExperimentoMayorDuracion();
                case 7 -> exportarInvestigadoresCSV();
                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    // ------------------ OPCIÓN 1 
    private void registrarInvestigador() {
        System.out.print("Nombre del investigador: ");
        String nombre = scanner.nextLine();

        System.out.print("Edad del investigador: ");
        int edad = scanner.nextInt();
        scanner.nextLine();

        Investigador inv = new Investigador(nombre, edad);
        investigadores.add(inv);
        System.out.println("Investigador registrado correctamente.\n");
    }

    // ------------ OPCIÓN 2 
    private void registrarExperimentoQuimico() {
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
        mostrarInvestigadores();
        System.out.print("Ingrese el número del investigador: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        Investigador investigador = (index >= 0 && index < investigadores.size())
                ? investigadores.get(index)
                : null;

        if (investigador == null) {
            System.out.println("Investigador no válido. Debe registrar uno primero.");
            return;
        }

        ExperimentoQuimico exp = new ExperimentoQuimico(nombre, duracion, exitoso, reactivo, investigador);
        experimentos.add(exp);
        System.out.println("Experimento químico registrado con éxito.\n");
    }

    // ----- OPCIÓN 3
    private void registrarExperimentoFisico() {
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
        mostrarInvestigadores();
        System.out.print("Ejemplo: 1,2 -> ");
        String entrada = scanner.nextLine();
        String[] indices = entrada.split(",");

        for (String s : indices) {
            try {
                int i = Integer.parseInt(s.trim()) - 1;
                if (i >= 0 && i < investigadores.size()) {
                    listaInv.add(investigadores.get(i));
                }
            } catch (NumberFormatException e) {
                System.out.println("Número inválido: " + s);
            }
        }

        if (listaInv.isEmpty()) {
            System.out.println("No se seleccionaron investigadores válidos.");
            return;
        }

        ExperimentoFisico exp = new ExperimentoFisico(nombre, duracion, exitoso, instrumento, listaInv);
        experimentos.add(exp);
        System.out.println("Experimento físico registrado con éxito.\n");
    }

    //  ------- OPCIÓN 4 
    private void mostrarExperimentos() {
        if (experimentos.isEmpty()) {
            System.out.println("No hay experimentos registrados.");
            return;
        }

        System.out.println("\n=== LISTA DE EXPERIMENTOS ===");
        for (AbstractExperimento e : experimentos) {
            String tipo = (e instanceof ExperimentoQuimico) ? "Químico" : "Físico";
            System.out.println("- " + e.getNombre() + " | Tipo: " + tipo +
                    " | Duración: " + e.getDuracion() + " min | Exitoso: " + e.isExitoso());
        }
    }

    // ------ OPCIÓN 5 
    private void mostrarTotales() {
        long exitosos = experimentos.stream().filter(AbstractExperimento::isExitoso).count();
        long fallidos = experimentos.size() - exitosos;

        System.out.println("Total de experimentos exitosos: " + exitosos);
        System.out.println("Total de experimentos fallidos: " + fallidos);
    }

    // ------ OPCIÓN 6 
    private void mostrarExperimentoMayorDuracion() {
        if (experimentos.isEmpty()) {
            System.out.println("No hay experimentos registrados.");
            return;
        }

        AbstractExperimento mayor = Collections.max(experimentos, Comparator.comparingInt(AbstractExperimento::getDuracion));
        System.out.println("Experimento de mayor duración: " + mayor.getNombre() +
                " (" + mayor.getDuracion() + " min)");
    }

    private void mostrarInvestigadores() {
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
    if (investigadores == null || investigadores.isEmpty()) {
        System.out.println("⚠️ No hay investigadores registrados para exportar.");
        return;
    }
    archivoInvestigadoresService.exportarInvestigadoresCSV(investigadores);
}
    
}