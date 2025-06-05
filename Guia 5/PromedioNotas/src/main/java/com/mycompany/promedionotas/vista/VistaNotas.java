package com.mycompany.promedionotas.vista;

import com.mycompany.promedionotas.modelo.Alumno;
import java.util.*;

public class VistaNotas {

    Scanner sc = new Scanner(System.in);

    public void listaAlumnos(List<Alumno> datos) {
        System.out.println("---- ALUMNOS Y NOTAS ----");
        for (Alumno a : datos) {
            System.out.println(a.toString());
        }
    }

    public void mostrarPromedio(double promedio, String nombre) {
        System.out.println("--- PROMEDIO ---");
        System.out.println("Alumno: " + nombre + " Promedio: " + promedio);
    }

    public String pedirNombre() {
            System.out.print("Calcular Promedio del Alumno: ");
            return sc.nextLine();
    }
    public void mensaje(String msj){
        System.out.println(msj);
    }
}
