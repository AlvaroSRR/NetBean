package com.mycompany.deudaclientes.controlador;

import com.mycompany.deudaclientes.modelo.Factura;
import com.mycompany.deudaclientes.vista.VistaFacturas;
import java.io.*;
import java.util.*;

public class ControladorFacturas {

    List<Factura> facturas = new ArrayList<>();
    VistaFacturas vista = new VistaFacturas();

    public void leerDatos(String link) {

        try (FileReader fr = new FileReader(link); BufferedReader br = new BufferedReader(fr)) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                int codFactura = Integer.parseInt(datos[0]);
                int codCliente = Integer.parseInt(datos[1]);
                double total = Double.parseDouble(datos[2]);
                Factura f = new Factura(codFactura, codCliente, total);
                facturas.add(f);
            }
        } catch (Exception e) {
            vista.mensaje("Error de Lectura: " + e);
        }
    }

    public void mostrarFacturas() {
        vista.mostrarFacturas(facturas);
    }

    public void calcularDeuda() {
        String codCliente = vista.pedirCliente();
        double total = 0;
        boolean esta = false;
        if (codCliente != null) {
            int cliente = Integer.parseInt(codCliente);
            for (Factura f : facturas) {
                if (f.getCodCliente() == cliente) {
                    total += f.getTotal();
                    esta = true;
                }
            }
            if (esta) {
                vista.mensaje("Cliente: " + codCliente + " Total: " + total);
            }
        }
        if (codCliente == null || esta == false) {
            vista.mensaje("Codigo de Cliente invalido");
        }
    }
}
