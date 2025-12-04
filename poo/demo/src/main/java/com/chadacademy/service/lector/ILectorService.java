package com.chadacademy.service.lector;

import java.util.List;

import com.chadacademy.dominio.Investigador;

public interface ILectorService {

    void registrarInvestigador(); 
    void registrarExperimentoQuimico();
    void registrarExperimentoFisico();
    void mostrarInvestigadores(List<Investigador> investigadores);
}

