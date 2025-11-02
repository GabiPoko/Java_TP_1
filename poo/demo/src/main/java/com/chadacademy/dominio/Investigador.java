package com.chadacademy.dominio;

import java.util.ArrayList;
import java.util.List;

public class Investigador {
    private String nombre;
    private int edad;
    private List<AbstractExperimento> experimentos;

    public Investigador(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.experimentos = new ArrayList<>();
    }

    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public List<AbstractExperimento> getExperimentos() { return experimentos; }

    public void addExperimento(AbstractExperimento e) {
        if (e != null && !experimentos.contains(e)) {
            experimentos.add(e);
        }
    }

    @Override
    public String toString() {
        return nombre + " (" + edad + ") - " + experimentos.size() + " experimentos";
    }
}
