package com.chadacademy.service.experimentos;

import java.util.List;

import com.chadacademy.dominio.AbstractExperimento;


public interface IExperimentoService {

    void agregarExperimento(AbstractExperimento experimento);
    void mostrarExperimentos();
    AbstractExperimento experimentoMayorDuracion();

    List<AbstractExperimento> buscarTodos();

}