package com.chadacademy.repository.Experimento.Impl;

import com.chadacademy.dominio.AbstractExperimento;
import com.chadacademy.repository.Experimento.ExperimentoRepository;
import java.util.ArrayList;
import java.util.List;

public class ExperimentoRepositoryImpl implements ExperimentoRepository {
    
    
    private static final List<AbstractExperimento> EXPERIMENTOS = new ArrayList<>();

    @Override
    public void guardar(AbstractExperimento experimento) {
        
        EXPERIMENTOS.add(experimento);
    }

    @Override
    public List<AbstractExperimento> buscarTodos() {
        
        return EXPERIMENTOS;
    }
}
