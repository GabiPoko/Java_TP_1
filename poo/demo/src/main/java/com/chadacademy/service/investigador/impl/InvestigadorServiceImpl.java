package com.chadacademy.service.investigador.impl;

import com.chadacademy.dominio.Investigador;
import com.chadacademy.service.investigador.IInvestigadorService;
import com.chadacademy.repository.Investigador.InvestigadorRepository;
import java.util.List;


public class InvestigadorServiceImpl implements IInvestigadorService {
    
    
    private final InvestigadorRepository investigadorRepository;

    public InvestigadorServiceImpl(InvestigadorRepository investigadorRepository) {
        this.investigadorRepository = investigadorRepository;
    }
    

    @Override
    public void registrarInvestigador(String nombre, int edad) {
        if (edad <= 0) {
        throw new IllegalArgumentException("La edad debe ser un número positivo.");
    }
    
    Investigador inv = new Investigador(nombre, edad);
    
    this.investigadorRepository.guardar(inv); 
}    



    @Override
    public List<Investigador> buscarTodos() {

        return investigadorRepository.buscarTodos();
    }
}




