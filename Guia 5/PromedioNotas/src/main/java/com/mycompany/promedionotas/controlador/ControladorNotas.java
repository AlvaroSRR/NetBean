package com.mycompany.promedionotas.controlador;

import com.mycompany.promedionotas.modelo.Alumno;
import com.mycompany.promedionotas.vista.VistaNotas;
import java.io.*;
import java.util.*;

public class ControladorNotas {

    VistaNotas vista = new VistaNotas();
    List<Alumno> alumnos = new ArrayList<>();

    public void leerDatos(String direccion) {

        String link = direccion;
        try (FileReader fr = new FileReader(link); BufferedReader br = new BufferedReader(fr)) {
            String linea;
            while ((linea = br.readLine()) != null) {

                String[] dato = linea.split(",");
                String nombre = dato[0];
                List<Integer> notas = new ArrayList<>();
                for (int i = 1; i < dato.length; i++) {
                    notas.add(Integer.parseInt(dato[i]));
                }
                Alumno a = new Alumno(nombre, notas);
                alumnos.add(a);
            }
        } catch (Exception e) {
            String msj = "Error de lectura: " + e.getMessage();
            vista.mensaje(msj);
            //System.out.println("Error de lectura: " + e.getMessage());
        }
    }

    public void listaAlumnos() {
        vista.listaAlumnos(alumnos);

    }

    public void calcularPromedio() {
        String nombrePedido = vista.pedirNombre();
        if (nombrePedido != null) {
            for (Alumno a : alumnos) {
                if (a.getNombre().equalsIgnoreCase(nombrePedido)) {
                    double promedio = 0;
                    List<Integer> notas = a.getNotas();
                    for (int n : notas) {
                        promedio += n;
                    }
                    promedio = promedio / notas.size();
                    String nombre = a.getNombre();
                    vista.mostrarPromedio(promedio, nombre);
                    break;
                }
            }
        } else {
            vista.mensaje("Alumno no Encontrado");
        }

    }
}
