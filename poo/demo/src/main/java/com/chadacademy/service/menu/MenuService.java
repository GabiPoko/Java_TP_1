package com.chadacademy.service.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.chadacademy.dominio.AbstractExperimento;
import com.chadacademy.dominio.ExperimentoFisico;
import com.chadacademy.dominio.ExperimentoQuimico;
import com.chadacademy.dominio.Investigador;
import com.chadacademy.service.experimentos.IExperimentoService;
import com.chadacademy.service.experimentos.Impl.ExperimentoServiceImpl;

public class MenuService {

    private Scanner sc = new Scanner(System.in);
    private IExperimentoService experimentoService = new ExperimentoServiceImpl();

    public void iniciar() {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1 -> registrarExperimentoQuimico();
                case 2 -> registrarExperimentoFisico();
                case 3 -> experimentoService.mostrarExperimentos();
                case 4 -> mostrarExperimentoMayorDuracion();
                case 0 -> System.out.println("👋 Saliendo del sistema...");
                default -> System.out.println("❌ Opción inválida.");
            }
        } while (opcion != 0);
    }

    private void mostrarMenu() {
        System.out.println("\n===== MENÚ LABORATORIO CHAD =====");
        System.out.println("1. Registrar experimento químico");
        System.out.println("2. Registrar experimento físico");
        System.out.println("3. Mostrar todos los experimentos");
        System.out.println("4. Mostrar experimento de mayor duración");
        System.out.println("0. Salir");
    }

    private void registrarExperimentoQuimico() {
        System.out.println("\n--- Registro de experimento químico ---");
        String nombre = leerTexto("Nombre: ");
        int duracion = leerEntero("Duración (minutos): ");
        boolean exitoso = leerBoolean("¿Fue exitoso (true/false)? ");
        String reactivo = leerTexto("Tipo de reactivo: ");

        Investigador inv = new Investigador("Juan Pérez", 30);
        AbstractExperimento eq = new ExperimentoQuimico(nombre, duracion, exitoso, reactivo, inv);
        experimentoService.agregarExperimento(eq);
        System.out.println("✅ Experimento químico agregado.");
    }

    private void registrarExperimentoFisico() {
        System.out.println("\n--- Registro de experimento físico ---");
        String nombre = leerTexto("Nombre: ");
        int duracion = leerEntero("Duración (minutos): ");
        boolean exitoso = leerBoolean("¿Fue exitoso (true/false)? ");
        String instrumento = leerTexto("Instrumento utilizado: ");

        List<Investigador> investigadores = new ArrayList<>();
        investigadores.add(new Investigador("Ana Torres", 28));

        AbstractExperimento ef = new ExperimentoFisico(nombre, duracion, exitoso, instrumento, investigadores);
        experimentoService.agregarExperimento(ef);
        System.out.println("✅ Experimento físico agregado.");
    }

    private void mostrarExperimentoMayorDuracion() {
        AbstractExperimento mayor = experimentoService.experimentoMayorDuracion();
        if (mayor != null)
            System.out.println("⏱ Experimento más largo: " + mayor.getNombre() + " (" + mayor.getDuracion() + " min)");
        else
            System.out.println("⚠ No hay experimentos registrados.");
    }

    // ------------------------
    // Métodos auxiliares
    // ------------------------
    private String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine();
    }

    private int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!sc.hasNextInt()) {
            System.out.print("Por favor ingrese un número válido: ");
            sc.next();
        }
        int num = sc.nextInt();
        sc.nextLine();
        return num;
    }

    private boolean leerBoolean(String mensaje) {
        System.out.print(mensaje);
        while (!sc.hasNextBoolean()) {
            System.out.print("Ingrese true o false: ");
            sc.next();
        }
        boolean b = sc.nextBoolean();
        sc.nextLine();
        return b;
    }

}
