package com.chadacademy.service.investigador;

import com.chadacademy.dominio.Investigador;
import java.util.List;

public interface IInvestigadorService {

    //void guardarInvestigador(Investigador investigador);

    void registrarInvestigador(String nombre, int edad);
    
    List<Investigador> buscarTodos();
    
}