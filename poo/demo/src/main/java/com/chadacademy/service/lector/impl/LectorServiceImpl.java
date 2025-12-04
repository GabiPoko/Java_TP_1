package com.chadacademy.service.lector.impl;

import java.util.ArrayList;
import java.util.List;

import com.chadacademy.dominio.Investigador;
import com.chadacademy.service.experimentos.IExperimentoService;
import com.chadacademy.service.investigador.IInvestigadorService;
import com.chadacademy.service.lector.ILectorService;
import com.chadacademy.utils.ConsolaUtils;

public class LectorServiceImpl implements ILectorService {
    private final ConsolaUtils consolaUtils;
    private final IInvestigadorService investigadorService;
    private final IExperimentoService experimentoService;

    public LectorServiceImpl(
        ConsolaUtils consolaUtils, 
        IInvestigadorService investigadorService, 
        IExperimentoService experimentoService) 
    {
        this.consolaUtils = consolaUtils;
        this.investigadorService = investigadorService;
        this.experimentoService = experimentoService;
    }

    @Override
    public void mostrarInvestigadores(List<Investigador> investigadores) {
        if (investigadores.isEmpty()) {
            System.out.println("No hay investigadores registrados.");
            return;
        }
        int i = 1;
        for (Investigador inv : investigadores) {
            System.out.println(i++ + ". " + inv.getNombre() + " (" + inv.getEdad() + " años)");
        }
    }
        
    @Override
    public void registrarExperimentoFisico() {
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
        this.mostrarInvestigadores(investigadoresDisponibles); 
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
    

    @Override
    public void registrarExperimentoQuimico() {
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
        this.mostrarInvestigadores(investigadoresDisponibles); 
            
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

    @Override
    public void registrarInvestigador() {
        String nombre = consolaUtils.leerString("Nombre del investigador: "); 
        int edad = consolaUtils.leerEntero("Edad del investigador: ");

        try {
            investigadorService.registrarInvestigador(nombre, edad); 
            System.out.println("Investigador registrado correctamente.\n");
        } catch (IllegalArgumentException e) {
            System.out.println("Error al registrar investigador: " + e.getMessage());
        }
    }
        
    }
