
package com.mycompany.repaso2.modelos;


public class ProductoVendido {
    private Producto producto;
    private int cantidad;
    private double precioTotal;
    public ProductoVendido(Producto producto,int cantidad,double precioTotal){
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioTotal = precioTotal;
    }

    public ProductoVendido() {
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }
    public double getTotal(){
        return precioTotal;
    }

    @Override
    public String toString() {
        return producto + "\n cantidad: " + cantidad +"\ntotal: "+precioTotal;
    }
    
    
}
