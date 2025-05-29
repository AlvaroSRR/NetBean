
package com.mycompany.repaso2.modelos;

public class ProductoDigital extends Producto{

    public ProductoDigital(int codigo, String nombre,double precio){
    super(codigo,nombre,precio);
    }
    
    public double calcularTotal(int cantidad){
        double total = cantidad*precio;
        if (cantidad >=10){
            total*=0.8;}
        return total;
    }
}