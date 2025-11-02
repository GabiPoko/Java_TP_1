package com.chadacademy.dominio;

public abstract class AbstractExperimento {

    private String nombre;
    private int duracion;
    private boolean exitoso;


    public AbstractExperimento(String nombre, int duracionMinutos, boolean exitoso) {
        this.nombre = nombre;
        this.duracion = duracionMinutos;
        this.exitoso = exitoso;
    }

    public String getNombre() { return nombre; }
    public int getDuracion() { return duracion; }
    public boolean isExitoso() { return exitoso; }

    public abstract String getTipo(); 


    
}
