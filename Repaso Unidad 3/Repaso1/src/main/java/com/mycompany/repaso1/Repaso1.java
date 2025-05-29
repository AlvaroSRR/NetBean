package com.mycompany.repaso1;

import com.mycompany.modelos.Habitacion;
import com.mycompany.modelos.HabitacionEstandar;
import com.mycompany.modelos.HabitacionLujo;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Repaso1 {

    private List<Habitacion> habitaciones = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    private void menu() {
        int opcion;
        do {
            System.out.println("--- MENU HOTEL ---");
            System.out.print("1. Registrar Habitacion \n2. Ver Habitaciones Disponibles\n3. Calcular costo de Estadia \n0. Salir \nOpcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1: {
                    registrarHabitacion();
                    break;
                }
                case 2: {
                    mostrarHabitaciones();
                    break;
                }
                case 3:{
                    calcularCosto();
                    break;
                }
            }
        } while (opcion != 0);
    }

    private void registrarHabitacion() {
        System.out.print("Numero de Habitacion: ");
        int numHabitacion = scanner.nextInt();
        System.out.print("Tipo: 1. Standar - 2. Lujo : ");
        int tipo = scanner.nextInt();
        System.out.println("Precio por Noche: ");
        double precio = scanner.nextInt();

        if (tipo == 1) {
            Habitacion he = new HabitacionEstandar(numHabitacion, precio);
            habitaciones.add(he);
        } else {
            Habitacion hl = new HabitacionLujo(numHabitacion, precio);
            habitaciones.add(hl);
        }
    }

    private void mostrarHabitaciones() {
        if (habitaciones.size() == 0) {
            System.out.println("No hay habitaciones registradas");
            return;
        }
        for (Habitacion h : habitaciones) {
            //System.out.println(h.toString());// ver si anda
            System.out.println(h);//opcion 1
        }
    }

    // return ademas de devolver un metodo, corta la ejecucion, lo que esta despues del return, nunca se va a ejecutar
    private Habitacion buscarHabitacion(int numero) {
        for (Habitacion h : habitaciones) {
            if (h.getNumero() == numero) {
                return h;
            }
        }
        return null;
    }

    private void calcularCosto() {
        System.out.print("Ingrese Numero de habitacion: ");
        int num = scanner.nextInt();
        Habitacion h = buscarHabitacion(num);
        if (h == null) {
            System.out.println("Habitacion no encontrada");
            return;
        }
        System.out.print("Cantidad de Noches: ");
        int noches = scanner.nextInt();
        double total = h.calcularCostoTotal(noches);
        System.out.println("Total: $" + total);

    }

    public static void main(String[] args) {
        System.out.println("--- GESTOR HABITACIONES ---");
        new Repaso1().menu();
    }
}
