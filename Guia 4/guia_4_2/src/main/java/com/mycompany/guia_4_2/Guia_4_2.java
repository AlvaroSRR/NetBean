package com.mycompany.guia_4_2;

import com.mycompany.guia_4_2.modelos.Dolar;
import com.mycompany.guia_4_2.modelos.Producto;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//menu principal
public class Guia_4_2 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        //variables
        Dolar dolar;
        double[] dolarHoy = new double[3];
        List<Producto> listaProductos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        // ingreso de precio dolares
        System.out.print("Ingrese valor dolar oficial: ");
        dolarHoy[0] = scanner.nextDouble();
        System.out.print("Ingrese valor dolar blue: ");
        dolarHoy[1] = scanner.nextDouble();
        System.out.print("Ingrese valor dolar marca: ");
        dolarHoy[2] = scanner.nextDouble();
        dolar = new Dolar(dolarHoy[0], dolarHoy[1], dolarHoy[2]);
        //cargamos la lista
        try (BufferedReader br = new BufferedReader(new FileReader("G:\\UTN\\2º CUATRIMESTRE\\Programacion 2\\netbean\\guia_4_2\\src\\main\\java\\com\\mycompany\\guia_4_2\\archivos\\Productos.txt"))) {
            String linea;
            br.readLine();
            while ((linea = br.readLine()) != null) {
                String[] tupla = linea.split(";");
                Producto p = new Producto(Integer.parseInt(tupla[0]), tupla[1], Double.parseDouble(tupla[2]), tupla[3]);
                listaProductos.add(p);
            }
            for (Producto lp : listaProductos) {
                System.out.println("Id: " + lp.getCodigo() + " - Nombre: " + lp.getNombre() + " - USD: $" + lp.getPrecio());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Elección producto
        boolean compra = false;
        System.out.print("Quiere comprar algun producto? S/N? :");
        String comprar;
        comprar = scanner.next().toUpperCase();
        if (comprar.equals("S")) {
            compra = true;
        }
        while (compra) {
            System.out.print("Ingrese Id de producto: ");
            int id;
            id = scanner.nextInt();
            double precioPeso = 0;
            double cotizacion = 0;
            for (Producto p : listaProductos) {
                if (p.getCodigo() == id) {

                    switch (p.getTipoDolar()) {
                        case "blue" -> {
                            precioPeso = dolar.getConvertirDolarBlue(p.getPrecio());
                            cotizacion = dolar.getDolarBlue();
                        }
                        case "oficial" -> {
                            precioPeso = dolar.getConvertirDolarOficial(p.getPrecio());
                            cotizacion = dolar.getDolarOficial();
                        }
                        case "marca" -> {
                            precioPeso = dolar.getConvertirDolarMarca(p.getPrecio());
                            cotizacion = dolar.getDolarMarca();
                        }
                    }
                    System.out.println("Id: " + p.getCodigo() + " - Nombre: " + p.getNombre() + " - USD: $" + p.getPrecio() + " - Pesos: $" + String.format("%.2f", precioPeso));
                }
            }
            System.out.print("Comprar producto? S/N");
            String comprarProd;
            comprarProd = scanner.next().toUpperCase();
            if (comprarProd.equals("S")) {

                //guardar en Compra.txt
                //Guardar en txt;
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("G:\\UTN\\2º CUATRIMESTRE\\Programacion 2\\netbean\\guia_4_2\\src\\main\\java\\com\\mycompany\\guia_4_2\\archivos\\Compras.txt", true))) {
                    for (Producto p : listaProductos) {
                        if (id == (p.getCodigo())) {
                            // Ver formato
                            bw.write("Producto: " + p.getNombre() + "Precio En Dólares: $" + p.getPrecio() + "Tipo Dólar: " + p.getTipoDolar() + "Cotización: " + cotizacion + "Valor en pesos: $" + String.format("%.2f", precioPeso));
                            bw.newLine();
                            System.out.println("Compra registrada con exito.");
                        }
                    }

                } catch (IOException e) {
                    System.out.println("Error al registrar la compra.");
                }
            }

            System.out.print("Seguir comprando? S/N: ");
            String seguirComprando;
            seguirComprando = scanner.next().toUpperCase();
            if (seguirComprando.equals("N")) {
                compra = false;
                /* Printear Lista de compra
                try (BufferedReader br = new BufferedReader(new FileReader("G:\\UTN\\2º CUATRIMESTRE\\Programacion 2\\netbean\\guia_4_2\\src\\main\\java\\com\\mycompany\\guia_4_2\\archivos\\Compras.txt"))) {
                    String linea;
                    br.readLine();
                    while ((linea = br.readLine()) != null) {
                        String[] tupla = linea.split(";");
                        Producto p = new Producto(Integer.parseInt(tupla[0]), tupla[1], Double.parseDouble(tupla[2]), tupla[3]);
                        listaProductos.add(p);
                    }
                    for (Producto lp : listaProductos) {
                        System.out.println("Id: " + lp.getCodigo() + " - Nombre: " + lp.getNombre() + " - USD: $" + lp.getPrecio());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }*/
            }
        }

    }
}
