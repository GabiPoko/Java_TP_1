package com.chadacademy.service.menu.impl;

import com.chadacademy.dominio.*;
import java.util.*;
import com.chadacademy.service.archivos.ArchivoInvestigadoresService;
import com.chadacademy.service.experimentos.IExperimentoService;
import com.chadacademy.service.investigador.IInvestigadorService;
import com.chadacademy.service.lector.ILectorService;
import com.chadacademy.utils.ConsolaUtils; 
import com.chadacademy.service.menu.IMenuService;

public class MenuServiceImpl implements IMenuService{
    private final IInvestigadorService investigadorService;
    private final IExperimentoService experimentoService;
    private final ArchivoInvestigadoresService archivoInvestigadoresService;
    private final ConsolaUtils consolaUtils;
    private final ILectorService lectorService;
    
    
    public MenuServiceImpl(
        IInvestigadorService investigadorService, 
        IExperimentoService experimentoService, 
        ArchivoInvestigadoresService archivoInvestigadoresService,
        ConsolaUtils consolaUtils,
        ILectorService lectorService) {
        this.investigadorService = investigadorService;
        this.experimentoService = experimentoService;
        this.archivoInvestigadoresService = archivoInvestigadoresService;
        this.consolaUtils = consolaUtils;
        this.lectorService = lectorService;
    }

    @Override
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
                case 1 -> lectorService.registrarInvestigador();
                case 2 -> lectorService.registrarExperimentoQuimico(); 
                case 3 -> lectorService.registrarExperimentoFisico(); 
                case 4 -> mostrarExperimentos(); 
                case 5 -> mostrarTotales();
                case 6 -> mostrarExperimentoMayorDuracion();
                case 7 -> exportarInvestigadoresCSV();
                case 0 -> System.out.println("Saliendo del sistema...");                
            }
        } while (opcion != 0);
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
    
    private void exportarInvestigadoresCSV() {
            archivoInvestigadoresService.exportarInvestigadoresCSV(investigadorService);
    }
}