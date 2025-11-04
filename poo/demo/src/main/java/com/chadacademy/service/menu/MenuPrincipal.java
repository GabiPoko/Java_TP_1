package com.chadacademy.service.menu;

import com.chadacademy.dominio.*;
import com.chadacademy.service.experimentos.Impl.ExperimentoServiceImpl;
import java.util.*;

public class MenuPrincipal {
    private ExperimentoServiceImpl servicio = new ExperimentoServiceImpl();
    private Scanner scanner = new Scanner(System.in); 

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("===== LABORATORIO CHAD =====");
            System.out.println("1. Registrar experimento químico");
            System.out.println("2. Registrar experimento físico");
            System.out.println("3. Mostrar todos los experimentos");
            System.out.println("4. Mostrar experimento de mayor duración");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    registrarExperimentoQuimico();
                    break;
                case 2:
                    registrarExperimentoFisico();
                    break;
                case 3:
                    servicio.mostrarExperimentos();
                    break;
                case 4:
                    mostrarExperimentoMayorDuracion();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

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

        System.out.print("Nombre del investigador: ");
        String nombreInvestigador = scanner.nextLine();

        System.out.print("Edad del investigador: ");
        int edadInvestigador = scanner.nextInt();
        scanner.nextLine();

        Investigador investigador = new Investigador(nombreInvestigador, edadInvestigador);

        ExperimentoQuimico experimento = new ExperimentoQuimico(
                nombre, duracion, exitoso, reactivo, investigador
        );

        servicio.agregarExperimento(experimento);
        System.out.println("Experimento químico registrado con éxito.\n");
        servicio.mostrarExperimentos();
    }

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

        List<Investigador> investigadores = new ArrayList<>();
        System.out.print("¿Cuántos investigadores participaron?: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= cantidad; i++) {
            System.out.print("Nombre del investigador " + i + ": ");
            String nombreInv = scanner.nextLine();

            System.out.print("Edad del investigador " + i + ": ");
            int edadInv = scanner.nextInt();
            scanner.nextLine();

            investigadores.add(new Investigador(nombreInv, edadInv));
        }

        ExperimentoFisico experimento = new ExperimentoFisico(
                nombre, duracion, exitoso, instrumento, investigadores
        );

        servicio.agregarExperimento(experimento);
        System.out.println("Experimento físico registrado con éxito.\n");
        servicio.mostrarExperimentos();
    }

    private void mostrarExperimentoMayorDuracion() {
        AbstractExperimento mayor = servicio.experimentoMayorDuracion();
        if (mayor != null) {
            System.out.println("Experimento de mayor duración: " + mayor.getNombre() +
                    " (" + mayor.getDuracion() + " min)");
        } else {
            System.out.println("No hay experimentos registrados.");
        }
    }
}