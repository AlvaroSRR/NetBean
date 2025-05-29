package com.mycompany.modelos;
//en clase abstracta no se declaran setters
public abstract class Habitacion {

    protected int numero;
    protected String tipo;
    protected double precioPorNoche;

    //constructores
    public Habitacion(int numero, String tipo, double precioPorNoche) {
        this.numero = numero;
        this.precioPorNoche = precioPorNoche;
        this.tipo = tipo;
    }

    public Habitacion() {
    }

    //metodos
    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }
    public abstract double calcularCostoTotal(int noches); //se tiene que sobre escribir en cada hijo
    
    @Override
    public String toString(){
        return "Numero: "+numero+" - Tipo: "+tipo+" - Precio por Noche: "+precioPorNoche;
    }

}
