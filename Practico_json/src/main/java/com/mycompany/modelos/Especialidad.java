
package com.mycompany.modelos;

public class Especialidad {
    private String codigo;
    private String descripcion;

    public Especialidad(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public Especialidad() {
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "codigo: " + codigo + " - descripcion: " + descripcion;
    }
    
    
}
