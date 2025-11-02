package com.chadacademy.service.experimentos.Impl;

import java.util.ArrayList;
import java.util.List;

import com.chadacademy.dominio.AbstractExperimento;
import com.chadacademy.service.experimentos.*;

public class ExperimentoServiceImpl implements IExperimentoService {

    private List<AbstractExperimento> experimentos = new ArrayList<>();

    @Override
    public void agregarExperimento(AbstractExperimento experimento) {
        experimentos.add(experimento);
    }

    @Override
    public void mostrarExperimentos() {
        for (AbstractExperimento e : experimentos) {
            System.out.println(e.getNombre() + " - Duración: " + e.getDuracion());
        }
    }

    @Override
    public AbstractExperimento experimentoMayorDuracion() {
        if (experimentos.isEmpty()) return null;

        AbstractExperimento mayor = experimentos.get(0);
        for (AbstractExperimento e : experimentos) {
            if (e.getDuracion() > mayor.getDuracion()) {
                mayor = e;
            }
        }
        return mayor;
    }
}

