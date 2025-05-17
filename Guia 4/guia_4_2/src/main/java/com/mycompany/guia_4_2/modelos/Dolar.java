package com.mycompany.guia_4_2.modelos;

public class Dolar {

    // definir variables
    private double dolarOficial;
    private double dolarBlue;
    private double dolarMarca;

    //constructores
    public Dolar() {
    }

    public Dolar(double dolarOficial, double dolarBlue, double dolarMarca) {
        this.dolarOficial = dolarOficial;
        this.dolarBlue = dolarBlue;
        this.dolarMarca = dolarMarca;
    }

    //metodos
    public double getDolarOficial() {
        return dolarOficial;
    }

    public double getDolarBlue() {
        return dolarBlue;
    }

    public double getDolarMarca() {
        return dolarMarca;
    }

    public double getConvertirDolarOficial(double precioProducto) {
        return (precioProducto * dolarOficial);
    }

    public double getConvertirDolarBlue(double precioProducto) {
        return precioProducto * dolarBlue;
    }

    public double getConvertirDolarMarca(double precioProducto) {
        return precioProducto * dolarMarca;
    }

    @Override
    public String toString() {
        return "Dolar{" + "dolarOficial=" + dolarOficial + ", dolarBlue=" + dolarBlue + ", dolarMarca=" + dolarMarca + '}';
    }
}
