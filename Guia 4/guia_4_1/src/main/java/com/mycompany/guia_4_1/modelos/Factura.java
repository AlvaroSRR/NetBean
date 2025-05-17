
package com.mycompany.guia_4_1.modelos;

import java.util.List;

public class Factura {
    private int nro;
    private Cliente cliente;
    private double total;
    
    public Factura(){}
    public Factura(int nro, Cliente cliente, double total){
        this.nro = nro;
        this.cliente = cliente;
        this.total = total;
    }

    public int getNro() {
        return nro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getTotal() {
        return total;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    //porque toString
    @Override
    public String toString(){
        return "Factura{" + "nro=" + nro + ", cliente=" + cliente + ", total=" + total + '}';
    }
    
    //porque public static
    public static int getCantidadFacturas(List<Factura> facturas, Cliente cliente){    
        int contador = 0;
        for (Factura f : facturas){
            if (f.getCliente().equals(cliente) && f.getTotal()>=15000){
                contador ++;
            }
        }
        return contador;
    }
}
