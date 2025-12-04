package com.chadacademy.service.experimentos.Impl;


import java.util.List;
import com.chadacademy.dominio.*;
import com.chadacademy.service.experimentos.*;
import com.chadacademy.repository.Experimento.ExperimentoRepository;

public class ExperimentoServiceImpl implements IExperimentoService {

    
    private final ExperimentoRepository experimentoRepository; 

    
    public ExperimentoServiceImpl(ExperimentoRepository experimentoRepository) {
        this.experimentoRepository = experimentoRepository;
    }

    @Override
    public void registrarExperimentoQuimico(
        String nombre, 
        int duracion, 
        boolean exitoso, 
        String tipoReactivo, 
        Investigador investigador) {
        
        
        if (investigador == null) {
            throw new IllegalArgumentException("El experimento químico requiere un investigador válido.");
        }
        

        ExperimentoQuimico exp = new ExperimentoQuimico(nombre, duracion, exitoso, tipoReactivo, investigador);
        
        
        experimentoRepository.guardar(exp);
    }

    @Override
    public void registrarExperimentoFisico(
        String nombre, 
        int duracion, 
        boolean exitoso, 
        String instrumento, 
        List<Investigador> investigadores) {
        
        if (investigadores == null || investigadores.isEmpty()) {
            throw new IllegalArgumentException("El experimento físico requiere al menos un investigador.");
        }
        
        ExperimentoFisico exp = new ExperimentoFisico(nombre, duracion, exitoso, instrumento, investigadores);
        
        experimentoRepository.guardar(exp);
    }

    @Override
    public AbstractExperimento experimentoMayorDuracion() {
        
        List<AbstractExperimento> experimentos = experimentoRepository.buscarTodos();
        
        if (experimentos.isEmpty()) return null;

        AbstractExperimento mayor = experimentos.get(0);
        for (AbstractExperimento e : experimentos) {
            if (e.getDuracion() > mayor.getDuracion()) {
                mayor = e;
            }
        }
        return mayor;
    }

    @Override
    public List<AbstractExperimento> buscarTodos() {
        return experimentoRepository.buscarTodos();
    }


@Override
public long contarExperimentosExitosos() {
    
    List<AbstractExperimento> experimentos = experimentoRepository.buscarTodos();
    
    return experimentos.stream()
            .filter(AbstractExperimento::isExitoso)
            .count();
}
@Override
public long contarExperimentosFallidos() {
    List<AbstractExperimento> experimentos = experimentoRepository.buscarTodos();
    
    return experimentos.stream()
            .filter(e -> !e.isExitoso()) 
            .count();
    }
}
