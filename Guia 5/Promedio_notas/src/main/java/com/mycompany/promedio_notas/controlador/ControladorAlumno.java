package com.mycompany.promedio_notas.controlador;

import com.mycompany.promedio_notas.modelo.Alumno;
import com.mycompany.promedio_notas.vista.VistaAlumno;
import java.io.*;
import java.util.*;

public class ControladorAlumno {

    private VistaAlumno vista;
    private List<Alumno> alumnos = new ArrayList<>();

    public ControladorAlumno(VistaAlumno vista) {
        this.vista = vista;
    }

    public void cargarDatosDesdeArchivo(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                String nombre = partes[0];
                List<Integer> notas = new ArrayList<>();
                for (int i = 1; i < partes.length; i++) {
                    notas.add(Integer.parseInt(partes[i]));
                }
                alumnos.add(new Alumno(nombre, notas));
            }
        } catch (IOException e) {
            vista.mostrarMensaje("Error al leer el archivo: " + e.getMessage());
        }
    }

    public void calcularYMostrarPromedio() {
        String nombreBuscado = vista.solicitarNombreAlumno();
        Alumno alumnoEncontrado = null;

        // Buscar al alumno manualmente
        for (Alumno alumno : alumnos) {
            if (alumno.getNombre().equalsIgnoreCase(nombreBuscado)) {
                alumnoEncontrado = alumno;
                break;
            }
        }

        // Mostrar el resultado
        if (alumnoEncontrado != null) {
            double promedio = alumnoEncontrado.calcularPromedio();
            vista.mostrarPromedio(alumnoEncontrado.getNombre(), promedio);
        } else {
            vista.mostrarMensaje("Alumno no encontrado.");
        }
    }
}
