package com.chadacademy.service.experimentos.Impl;


import java.util.List;

import com.chadacademy.dominio.AbstractExperimento;
import com.chadacademy.service.experimentos.*;
import com.chadacademy.repository.Experimento.ExperimentoRepository;

public class ExperimentoServiceImpl implements IExperimentoService {

    
    private final ExperimentoRepository experimentoRepository; 

    
    public ExperimentoServiceImpl(ExperimentoRepository experimentoRepository) {
        this.experimentoRepository = experimentoRepository;
    }

    @Override
    public void agregarExperimento(AbstractExperimento experimento) {
        
        experimentoRepository.guardar(experimento); 
    }

    
    @Override
    public void mostrarExperimentos() {
        
        List<AbstractExperimento> experimentos = experimentoRepository.buscarTodos(); 
        
        for (AbstractExperimento e : experimentos) {
            System.out.println(e.getNombre() + " - Duración: " + e.getDuracion());
        }
    }

    @Override
    public AbstractExperimento experimentoMayorDuracion() {
        
        List<AbstractExperimento> experimentos = experimentoRepository.buscarTodos();
        
        if (experimentos.isEmpty()) return null;

        // logica exp de mayor duracion
        AbstractExperimento mayor = experimentos.get(0);
        for (AbstractExperimento e : experimentos) {
            if (e.getDuracion() > mayor.getDuracion()) {
                mayor = e;
            }
        }
        return mayor;
    }

    @Override
    public List<AbstractExperimento> buscarTodos() {
        return experimentoRepository.buscarTodos();
    }
}