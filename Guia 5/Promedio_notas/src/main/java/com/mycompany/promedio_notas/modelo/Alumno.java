package com.mycompany.promedio_notas.modelo;

import java.util.List;

public class Alumno {
    private String nombre;
    private List<Integer> notas;

    public Alumno(String nombre, List<Integer> notas) {
        this.nombre = nombre;
        this.notas = notas;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Integer> getNotas() {
        return notas;
    }

    public double calcularPromedio() {
        if (notas == null || notas.isEmpty()) return 0.0;
        double suma = 0;
        for (int nota : notas) {
            suma += nota;
        }
        return suma / notas.size();
    }
}
