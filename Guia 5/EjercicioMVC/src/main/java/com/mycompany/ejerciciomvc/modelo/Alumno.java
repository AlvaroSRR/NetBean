package com.mycompany.ejerciciomvc.modelo;

public class Alumno {
    private String Nombre;
    private String Apellido;
    private int[] Nota;

    public Alumno(String nombre, String apellido, int[] nota) {
        this.Nombre = nombre;
        this.Apellido = apellido;
        this.Nota = nota;
            
    }

    public Alumno() {
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public int[] getNota() {
        return Nota;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public void setNota(int[] Nota) {
        this.Nota = Nota;
    }

    @Override
    public String toString() {
        return "Nombre: " + Nombre + " Apellido: " + Apellido + " Notas: " + Nota.toString();
    }
    
    
    
}
