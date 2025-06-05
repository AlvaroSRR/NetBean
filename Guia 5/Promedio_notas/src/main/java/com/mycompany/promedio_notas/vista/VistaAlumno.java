package com.mycompany.promedio_notas.vista;


import java.util.Scanner;

public class VistaAlumno {
    private Scanner scanner = new Scanner(System.in);

    public String solicitarNombreAlumno() {
        System.out.print("Ingrese el nombre del alumno: ");
        return scanner.nextLine();
    }

    public void mostrarPromedio(String nombre, double promedio) {
        System.out.printf("El promedio de %s es: %.2f\n", nombre, promedio);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
