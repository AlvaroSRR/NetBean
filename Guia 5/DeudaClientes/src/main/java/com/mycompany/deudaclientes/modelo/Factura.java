
package com.mycompany.deudaclientes.modelo;

public class Factura {
    private int codCliente;
    private int codFactura;
    private double total;

    public Factura() {
    }

    public Factura(int codFactura, int codCliente, double total) {
        this.codCliente = codCliente;
        this.codFactura = codFactura;
        this.total = total;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public int getCodFactura() {
        return codFactura;
    }

    public double getTotal() {
        return total;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public void setCodFactura(int codFactura) {
        this.codFactura = codFactura;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Cliente: " + codCliente + " Factura: " + codFactura + " Total: $" + total;
    }
    
    
}
