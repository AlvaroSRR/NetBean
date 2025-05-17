package com.mycompany.guia_4_2.modelos;

public class Producto {

    private int codigo;
    private String nombre;
    private double precio;
    private String tipoDolar;

    //constructores
    public Producto() {
    }

    public Producto(int codigo, String nombre, double precio, String tipoDolar) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.tipoDolar = tipoDolar;
    }
    // metodos

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getTipoDolar() {
        return tipoDolar;
    }

    // ver esta parte del codigo
    @Override
    public String toString() {
        return ("Codigo: " + codigo + " nombre: " + nombre + " precio USD: " + precio + " tipoDolar: " + tipoDolar);
    }

}
