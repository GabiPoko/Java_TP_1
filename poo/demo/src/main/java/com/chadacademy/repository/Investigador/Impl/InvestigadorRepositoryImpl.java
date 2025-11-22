package com.chadacademy.repository.Investigador.Impl;

import com.chadacademy.dominio.Investigador;
import com.chadacademy.repository.Investigador.InvestigadorRepository;
import java.util.ArrayList;
import java.util.List;

public class InvestigadorRepositoryImpl implements InvestigadorRepository {
    
    // lista para investigadores
    private static final List<Investigador> INVESTIGADORES = new ArrayList<>();

    @Override
    public void guardar(Investigador investigador) {
        INVESTIGADORES.add(investigador);
    }

    @Override
    public List<Investigador> buscarTodos() {
        return INVESTIGADORES;
    }
}