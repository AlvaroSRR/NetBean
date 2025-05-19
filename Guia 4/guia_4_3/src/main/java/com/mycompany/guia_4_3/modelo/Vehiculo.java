package com.mycompany.guia_4_3.modelo;

public class Vehiculo {

    private int codigo;
    private String patente;
    private int estado; // 0= disponible 1= mantenimiento
    private Conductor conductor;

    public Vehiculo() {
    }

    public Vehiculo(int codigo, String patente, int estado, Conductor conductor) {
        this.codigo = codigo;
        this.patente = patente;
        this.estado = estado;
        this.conductor = conductor;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getPatente() {
        return patente;
    }

    public int getEstado() {
        return estado;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "codigo=" + codigo + ", patente=" + patente + ", estado=" + estado + ", conductor=" + conductor + '}';
    }
}
