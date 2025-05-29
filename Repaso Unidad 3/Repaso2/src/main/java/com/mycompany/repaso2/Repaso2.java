package com.mycompany.repaso2;

import com.mycompany.repaso2.modelos.Producto;
import com.mycompany.repaso2.modelos.ProductoDigital;
import com.mycompany.repaso2.modelos.ProductoFisico;
import com.mycompany.repaso2.modelos.ProductoVendido;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Repaso2 {

    private List<Producto> productos = new ArrayList<>();
    private List<ProductoVendido> venta = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    private void menu() {
        int opcion;
        do {

            System.out.println("--- MENU PRODUCTO ---");
            System.out.print("1. Registrar Producto \n2. Registrar Venta\n3. Calcular Total de Venta\n0. Salir\ncodigo: ");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1: {
                    registrarProducto();
                    break;
                }
                case 2: {
                    printProductos();
                    registrarVenta();
                    break;
                }
                case 3: {
                    printVentas();
                    
                    break;
                }
            }

        } while (opcion != 0);
    }

    private void registrarProducto() {
        System.out.print("Codigo Producto: ");
        int codigo = sc.nextInt();
        sc.nextLine();
        System.out.print("Nombre Producto: ");
        String nombre = sc.nextLine();
        System.out.print("Precio Producto: ");
        double precio = sc.nextDouble();
        sc.nextLine();
        System.out.print("Tipo Producto 0. Fisico - 1. Digital: ");
        int tipo = sc.nextInt();
        sc.nextLine();

        if (tipo == 0) {
            Producto p = new ProductoFisico(codigo, nombre, precio);
            productos.add(p);
            System.out.println("Producto Registrado con Exito");
        } else {
            if (tipo == 1) {
                Producto p = new ProductoDigital(codigo, nombre, precio);
                productos.add(p);
                System.out.println("Producto Registrado con Exito");
            }
        }
    }
// terminar de programar metodo venta

    private void registrarVenta() {
        System.out.print("Codigo Producto: ");
        int codigo = sc.nextInt();

        System.out.print("Cantidad: ");
        int cantidad = sc.nextInt();

        for (Producto p : productos) {
            if (p.getCodigo() == codigo) {
                double total = p.calcularTotal(cantidad);
                ProductoVendido v = new ProductoVendido(p, cantidad, total);
                venta.add(v);
                System.out.println("Venta Registrada");
            }
        }
    }

    private void printProductos() {
        for (Producto p : productos) {
            System.out.println(p);
        }
    }

    private void printVentas() {
        double total=0;
        System.out.println("--- PRODUCTOS VENDIDOS ---");
        for (ProductoVendido v : venta) {
            System.out.println(v);
            total += v.getTotal();
        }
        System.out.println("Total: "+total);
    }

    public static void main(String[] args) {
        System.out.println("--- GESTION DE PRODUCTOS ---");
        new Repaso2().menu();
    }
}
