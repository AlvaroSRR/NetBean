package com.mycompany.repaso2.modelos;

public abstract class Producto {

    protected int codigo;
    protected String nombre;
    protected double precio;

    public Producto(int codigo, String nombre, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Producto() {
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + '}';
    }
    
    public abstract double calcularTotal(int cantidad);

}
