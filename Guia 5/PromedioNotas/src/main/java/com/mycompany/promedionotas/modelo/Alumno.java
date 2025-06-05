
package com.mycompany.promedionotas.modelo;

import java.util.*;

public class Alumno {
    private String nombre;
    private List<Integer> notas= new ArrayList<>();

    public Alumno() {
    }

    public Alumno(String nombre,List<Integer> notas) {
        this.nombre = nombre;
        this.notas = notas;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Integer> getNotas() {
        return notas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNotas(List<Integer> notas) {
        this.notas = notas;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " notas: " + notas;
    }
    
}
