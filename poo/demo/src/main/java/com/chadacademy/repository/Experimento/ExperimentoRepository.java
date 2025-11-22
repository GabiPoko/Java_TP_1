package com.chadacademy.repository.Experimento;

import com.chadacademy.dominio.AbstractExperimento;
import java.util.List;

public interface ExperimentoRepository {
    
    // guardar (añadir) un experimento.
    void guardar(AbstractExperimento experimento);
    
    // obtener todos los experimentos guardados.
    List<AbstractExperimento> buscarTodos();
    
    
}
