
package com.mycompany.repaso2.modelos;

import java.util.Scanner;

public class ProductoFisico extends Producto{

    public ProductoFisico(int codigo, String nombre,double precio){
    super(codigo,nombre,precio);
    }
    
    public double calcularTotal(int cantidad){
        return cantidad*precio;
    }
}
