package com.mycompany.guia_4_1;

import com.mycompany.guia_4_1.modelos.Cliente;
import com.mycompany.guia_4_1.modelos.Factura;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Guia_4_1 {

    public static void main(String[] args) {
        Map<Integer, Cliente> clientes = new HashMap<>();
        List<Factura> facturas = new ArrayList<>();

        // Leemos el archivo Clientes.txt y lo almacenamos en el HashMap
        try (FileReader fr = new FileReader("G:\\UTN\\2º CUATRIMESTRE\\Programacion 2\\netbean\\guia_4_1\\src\\main\\java\\com\\mycompany\\guia_4_1\\archivos\\Cliente.txt"); 
            BufferedReader br = new BufferedReader(fr)) {
            // try (BufferedReader br = new BufferedReader(new FileReader("Clientes.txt")))
            String linea;
            br.readLine();
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                int codigo = Integer.parseInt(partes[0]);
                String nombre = partes[1];
                String apellido = partes[2];
                int estado = Integer.parseInt(partes[3]);
                Cliente cliente = new Cliente(codigo, nombre, apellido, estado);
                clientes.put(codigo, cliente);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Leemos el archivo Facturas.txt y lo almacenamos en el ArrayList
        try (BufferedReader br = new BufferedReader(new FileReader("G:\\UTN\\2º CUATRIMESTRE\\Programacion 2\\netbean\\guia_4_1\\src\\main\\java\\com\\mycompany\\guia_4_1\\archivos\\Factura.txt"))) {
            String linea;
            br.readLine();
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                int nro = Integer.parseInt(partes[0]);
                int codCliente = Integer.parseInt(partes[1]);
                double total = Double.parseDouble(partes[2]);

                Cliente cliente = clientes.get(codCliente);
                if (cliente != null) {
                    Factura factura = new Factura(nro, cliente, total);
                    facturas.add(factura);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Clientes regulares:");
        for (Cliente cliente : clientes.values()) {
            
            if (cliente.isActivo()) {
                int cantidad = Factura.getCantidadFacturas(facturas, cliente);
                // ver que valor devuelve el metodo
                //System.out.println(cantidad);
                if (cantidad >= 5) {
                    System.out.println(cliente + " | Facturas: " + cantidad);
                }
            }
        }

    }
}
