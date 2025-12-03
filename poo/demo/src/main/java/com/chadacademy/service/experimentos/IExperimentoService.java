package com.chadacademy.service.experimentos;

import java.util.List;
import com.chadacademy.dominio.AbstractExperimento;
import com.chadacademy.dominio.Investigador;


public interface IExperimentoService {


    void registrarExperimentoQuimico(String nombre, int duracion, boolean exitoso, String tipoReactivo, Investigador investigador);
    void registrarExperimentoFisico(String nombre, int duracion, boolean exitoso, String instrumento, List<Investigador> investigadores);
    AbstractExperimento experimentoMayorDuracion();
    List<AbstractExperimento> buscarTodos();
    long contarExperimentosExitosos();
    long contarExperimentosFallidos();

}