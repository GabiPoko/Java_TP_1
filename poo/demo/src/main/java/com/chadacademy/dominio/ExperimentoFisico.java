package com.chadacademy.dominio;

import java.util.List;


public class ExperimentoFisico extends AbstractExperimento {
    private String instrumento;
    private List<Investigador> investigadores; // 1...* investigadores 

    public ExperimentoFisico(String nombre, int duracion, boolean exitoso, String instrumento, List<Investigador> investigadores) {
        super(nombre, duracion, exitoso);
        if (investigadores == null || investigadores.isEmpty())
            throw new IllegalArgumentException("Físico requiere al menos 1 investigador");
        this.instrumento = instrumento;
        this.investigadores = investigadores;
    }

    public String getInstrumento() { return instrumento; }
    public List<Investigador> getInvestigadores() { return investigadores; }

    @Override
    public String getTipo() { return "Físico"; }
}


