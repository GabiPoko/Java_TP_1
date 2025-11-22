package com.chadacademy.service.investigador;

import com.chadacademy.dominio.Investigador;
import java.util.List;

public interface IInvestigadorService {
    
    // para que llame el menu

    void guardarInvestigador(Investigador investigador);
    
    // lista completa de inv
    List<Investigador> buscarTodos();
    
    // revisar que mas se podria agregar aca  (que pide el probelma)
}