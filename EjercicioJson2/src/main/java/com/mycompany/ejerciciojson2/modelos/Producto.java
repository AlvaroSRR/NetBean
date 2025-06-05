
package com.mycompany.ejerciciojson2.modelos;

public class Producto {
    private int codigo;
    private String descripcion;
    private Categoria categoria;
    private double precio;
    private int stock;

    public Producto() {
    }

    public Producto(int codigo, String descripcion, Categoria categoria, double precio, int stock) {
            // ver categoria si se la pido despues
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", descripcion=" + descripcion + ", categoria=" + categoria + ", precio=" + precio + ", stock=" + stock + '}';
    }
    
    
    
}
