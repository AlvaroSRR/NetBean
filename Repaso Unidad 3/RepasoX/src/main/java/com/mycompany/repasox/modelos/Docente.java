
package com.mycompany.repasox.modelos;

import java.util.*;

public class Docente {
    private int numLegajo;
    private String nombre;
    private Especialidad especialidad;
    private List<Materia> materias = new ArrayList<>();

    public Docente(int numLegajo, String nombre, Especialidad especialidad) {
        this.numLegajo = numLegajo;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public int getNumLegajo() {
        return numLegajo;
    }

    public String getNombre() {
        return nombre;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setNumLegajo(int numLegajo) {
        this.numLegajo = numLegajo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public void setMaterias(Materia materia) {
        this.materias.add(materia);
    }

    @Override
    public String toString() {
        return "Docente{" + "numLegajo=" + numLegajo + ", nombre=" + nombre + ", especialidad=" + especialidad + ", materias=" + materias + '}';
    }
    
}
