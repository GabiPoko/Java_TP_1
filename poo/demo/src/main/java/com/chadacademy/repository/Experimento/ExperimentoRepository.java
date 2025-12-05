package com.chadacademy.repository.Experimento;

import com.chadacademy.dominio.AbstractExperimento;
import java.util.List;

public interface ExperimentoRepository {
    
    void guardar(AbstractExperimento experimento);
    
    List<AbstractExperimento> buscarTodos();
    
    
}
