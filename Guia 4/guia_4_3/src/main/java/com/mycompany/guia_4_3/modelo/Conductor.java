package com.mycompany.guia_4_3.modelo;

public class Conductor {

    private int codigo;
    private String nombre;

    public Conductor() {
    }

    public Conductor(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return ("Codigo: " + codigo + " - Nombre: " + nombre);
    }
}
