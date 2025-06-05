
package com.mycompany.ejerciciojson2.modelos;

public class Categoria {
    private int codigo;
    private String descripcion;

    public Categoria() {
    }

    public Categoria(int codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Codigo: " + codigo + " - Descripcion: " + descripcion;
    }
    
    
}
