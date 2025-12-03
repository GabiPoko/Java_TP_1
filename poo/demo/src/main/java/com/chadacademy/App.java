package com.chadacademy;

import com.chadacademy.service.menu.MenuPrincipal;
import com.chadacademy.repository.Experimento.Impl.ExperimentoRepositoryImpl;
import com.chadacademy.repository.Investigador.Impl.InvestigadorRepositoryImpl;
import com.chadacademy.service.experimentos.Impl.ExperimentoServiceImpl;
import com.chadacademy.service.investigador.impl.InvestigadorServiceImpl;
import com.chadacademy.service.archivos.Impl.ArchivoInvestigadoresServiceImpl;
import com.chadacademy.utils.ConsolaUtils; 
import java.util.Scanner; 


public class App {
    public static void main(String[] args) {
        
        InvestigadorRepositoryImpl investigadorRepo = new InvestigadorRepositoryImpl();
        ExperimentoRepositoryImpl experimentoRepo = new ExperimentoRepositoryImpl();

        ArchivoInvestigadoresServiceImpl archivoService = new ArchivoInvestigadoresServiceImpl();        
        InvestigadorServiceImpl invService = new InvestigadorServiceImpl(investigadorRepo);
        ExperimentoServiceImpl expService = new ExperimentoServiceImpl(experimentoRepo);

        Scanner scanner = new Scanner(System.in); 
        ConsolaUtils consolaUtils = new ConsolaUtils(scanner);
        
        MenuPrincipal menu = new MenuPrincipal(invService, expService, archivoService, consolaUtils);
        
        System.out.println("Sistema listo. Iniciando menú...");
        menu.mostrarMenu();
    }
}
