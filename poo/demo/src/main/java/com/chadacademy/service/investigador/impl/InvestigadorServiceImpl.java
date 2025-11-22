package com.chadacademy.service.investigador.impl;

import com.chadacademy.dominio.Investigador;
import com.chadacademy.service.investigador.IInvestigadorService;
import com.chadacademy.repository.Investigador.InvestigadorRepository;
import java.util.List;

// La clase implementa la interfaz (el contrato)
public class InvestigadorServiceImpl implements IInvestigadorService {
    
    // DEPENDENCIA: Usamos la interfaz del Repositorio para buscar y guardar
    private final InvestigadorRepository investigadorRepository;

    // CONSTRUCTOR: El Repositorio es inyectado aquí.
    public InvestigadorServiceImpl(InvestigadorRepository investigadorRepository) {
        this.investigadorRepository = investigadorRepository;
    }

    @Override
    public void guardarInvestigador(Investigador investigador) {
        // DELEGACIÓN: El Servicio le pide al Repositorio que haga el trabajo de guardar.
        investigadorRepository.guardar(investigador);
    }

    @Override
    public List<Investigador> buscarTodos() {
        // DELEGACIÓN: El Servicio le pide al Repositorio la lista.
        return investigadorRepository.buscarTodos();
    }
}




