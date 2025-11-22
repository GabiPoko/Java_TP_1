package com.chadacademy.repository.Investigador;

import com.chadacademy.dominio.Investigador;
import java.util.List;

public interface InvestigadorRepository {
    
    void guardar(Investigador investigador);
    
    List<Investigador> buscarTodos();
    
}
