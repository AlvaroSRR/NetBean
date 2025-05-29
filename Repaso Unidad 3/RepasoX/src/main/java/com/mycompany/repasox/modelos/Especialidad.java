
package com.mycompany.repasox.modelos;


public class Especialidad {
    private int codigo;
    private String nombre;

    public Especialidad(int codigo, String nombre) {
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
        return "Especialidad{" + "codigo=" + codigo + ", nombre=" + nombre + '}';
    }
    
}
