
package com.mycompany.deudaclientes;

import com.mycompany.deudaclientes.controlador.ControladorFacturas;

public class DeudaClientes {

    public static void main(String[] args) {
        ControladorFacturas controlador = new ControladorFacturas();
        controlador.leerDatos("C:\\Users\\alvar\\OneDrive\\Documentos\\Programacion II\\NetBean\\Guia 5\\DeudaClientes\\src\\main\\java\\com\\mycompany\\deudaclientes\\archivo\\Facturas.txt");
        controlador.mostrarFacturas();
        controlador.calcularDeuda();
    }
}
