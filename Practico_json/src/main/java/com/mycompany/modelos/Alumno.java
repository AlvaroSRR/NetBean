package com.mycompany.modelos;

public class Alumno {

    private int dni;
    private String nombre;
    private String apellido;
    private Especialidad especialidad;

    public Alumno(int dni, String nombre, String apellido, Especialidad especialidad) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
    }

    public Alumno() {
    }

    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "dni: " + dni + " - Apellido: " + apellido + " - Nombre: " + nombre + " - especialidad: " + especialidad.getDescripcion();
    }

}
