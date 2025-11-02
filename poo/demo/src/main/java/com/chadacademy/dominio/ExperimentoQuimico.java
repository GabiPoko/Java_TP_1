package com.chadacademy.dominio;

public class ExperimentoQuimico extends AbstractExperimento {

    private String tipoReactivo;
    private Investigador investigador; // 1 Solo investigador

    public ExperimentoQuimico(String nombre, int duracion, boolean exitoso, String tipoReactivo, Investigador investigador) {
        super(nombre, duracion, exitoso);
        if (investigador == null) throw new IllegalArgumentException("Químico necesita 1 investigador");
        this.tipoReactivo = tipoReactivo;
        this.investigador = investigador;
    }

    public String getTipoReactivo() { return tipoReactivo; }
    public Investigador getInvestigador() { return investigador; }

    @Override
    public String getTipo() { return "Químico"; }
}


