package com.mycompany.ejerciciojson2;

import java.util.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.ejerciciojson2.modelos.Categoria;
import com.mycompany.ejerciciojson2.modelos.Producto;
import java.io.File;

public class EjercicioJson2 {

    private Scanner sc = new Scanner(System.in);
    private ObjectMapper mapper = new ObjectMapper();
    private List<Producto> productos = new ArrayList<>();
    private List<Categoria> categorias = new ArrayList<>();

    private void menu() {
        cargar();
        int opcion = 0;
        do {
            sc.nextLine();
            System.out.println("------ MENU ------");
            System.out.println("opciones");
            System.out.print("opcion: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1 ->   //agregar categoria
                    agregarCategoria();
                case 2 ->    // modificar categoria
                    modificarCategoria();
                case 3 ->    //eliminar categoria
                    eliminarCategoria();
                case 4 ->    //agregar Producto
                    agregarProducto();
                case 5 ->    // modificar producto
                    modificarProducto();
                case 6 ->    //eliminar producto
                    eliminarProducto();
                case 7 ->    //listar categoria por Descripcion
                    listarCategoria();
                case 8 ->    // listar productos por stock (descendente)
                    listarProductoPorStock();
                case 9 ->    //listar productos por precio (ascendente)
                    listarProductoPorPrecio();
                case 10 ->  //guardar datos en JSON
                    guardar();

            }
        } while (opcion != 0);

    }

    private void agregarCategoria() {
        //int codigo, String descripcion
        sc.nextLine();
        System.out.print("Ingrese codigo: ");
        int codigo = sc.nextInt();
        sc.nextLine();
        System.out.print("Ingrese Descripcion: ");
        String descripcion = sc.nextLine();

        Categoria c = new Categoria(codigo, descripcion);
        categorias.add(c);
    }

    private void modificarCategoria() {

    }

    private void eliminarCategoria() {

    }

    private void agregarProducto() {
        //int codigo, String descripcion, Categoria categoria, double precio, int stock
        sc.nextLine();
        System.out.print("Codigo: ");
        int codigo = sc.nextInt();
        sc.nextLine();
        System.out.print("Descripcion: ");
        String descripcion = sc.nextLine();
        System.out.print("Precio: ");
        double precio = sc.nextDouble();
        sc.nextLine();
        System.out.print("Stock: ");
        int stock = sc.nextInt();
        sc.nextLine();
        printCategorias();
        System.out.println("Codigo Categoria: ");
        int codigoCategoria = sc.nextInt();
        for (Categoria c : categorias) {
            if (c.getCodigo() == codigoCategoria) {
                Producto p = new Producto(codigo, descripcion, c, precio, stock);
                productos.add(p);
                System.out.println("Producto Registrado");
            } else {
                System.out.println("Error de Categoria - Producto No Registrado");
            }
        }
    }

    private void modificarProducto() {

    }

    private void eliminarProducto() {

    }

    private void listarCategoria() {
        // lista ordenado por descripcion
        Map<String, Categoria> listaCategoria = new HashMap<>();
        for (Categoria c : categorias) {
            listaCategoria.put(c.getDescripcion(), c);
        }
        for (int i = 0; i < listaCategoria.size(); i++) {
            System.out.println(listaCategoria.get(i));
        }
    }

    private void listarProductoPorStock() {
        //lista productos ordenados por stock
        Map<Integer, Producto> listaProdStock = new HashMap<>();
        for (Producto p : productos) {
            listaProdStock.put(p.getStock(), p);
        }
        for (int i = 0; i < listaProdStock.size(); i++) {
            System.out.println(listaProdStock.get(i));
        }
    }

    private void listarProductoPorPrecio() {
        // listado ordenados por Precio
        // ver parametros del for para printear al revez
        Map<Double, Producto> listaProdStock = new HashMap<>();
        for (Producto p : productos) {
            listaProdStock.put(p.getPrecio(), p);
        }
        for (int i = listaProdStock.size()-1; i >=0 ; i--) {
            System.out.println(listaProdStock.get(i));
        }
    }

    private void guardar() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("G:\\UTN\\2º CUATRIMESTRE\\Programacion 2\\NetBean\\EjercicioJson2\\src\\main\\java\\com\\mycompany\\ejerciciojson2\\archivos\\Categorias.json"), categorias);
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("G:\\UTN\\2º CUATRIMESTRE\\Programacion 2\\NetBean\\EjercicioJson2\\src\\main\\java\\com\\mycompany\\ejerciciojson2\\archivos\\Productos.json"), productos);
            System.out.println("Datos guardados con Exito");
        } catch (Exception e) {
            System.out.println("Error al guardar - " + e.getMessage());
        }
    }

    private void cargar() {
        try {
            productos = mapper.readValue(new File("G:\\UTN\\2º CUATRIMESTRE\\Programacion 2\\NetBean\\EjercicioJson2\\src\\main\\java\\com\\mycompany\\ejerciciojson2\\archivos\\Productos.json"), new TypeReference<>() {
            });
            categorias = mapper.readValue(new File("G:\\UTN\\2º CUATRIMESTRE\\Programacion 2\\NetBean\\EjercicioJson2\\src\\main\\java\\com\\mycompany\\ejerciciojson2\\archivos\\Categorias.json"), new TypeReference<>() {
            });
            System.out.println("Datos cargados con Exito");
        } catch (Exception e) {
            System.out.println("Error al cargar - " + e);
        }
    }

    private void printCategorias() {
        for (Categoria c : categorias) {
            System.out.println(c);
        }
    }

    public static void main(String[] args) {
        new EjercicioJson2().menu();
    }
}
