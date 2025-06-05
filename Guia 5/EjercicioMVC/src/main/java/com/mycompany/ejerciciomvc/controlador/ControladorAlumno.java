package com.mycompany.ejerciciomvc.controlador;

import com.mycompany.ejerciciomvc.modelo.Alumno;
import com.mycompany.ejerciciomvc.vista.VistaAlumno;
import java.io.*;
import java.util.*;

public class ControladorAlumno {

    private VistaAlumno vista;
    private List<Alumno> listaAlumnos = new ArrayList<>();

    public void leerTxt(String ruta) {
        try (FileReader fr = new FileReader(ruta); BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] partes = line.split(",");
                String nombre = partes[0];
                String apellido = partes[1];
                int[] notas = new int[partes.length -2];
                for (int i = 2; i < partes.length; i++) {
                    notas[i - 2] = Integer.parseInt(partes[i]);
                    System.out.println( (i-2) + "  "+notas[i-2]);
                }
                Alumno a = new Alumno(nombre, apellido, notas);
                listaAlumnos.add(a);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(listaAlumnos.toString());
    }
    // leer archivo
    //metodos

    public void listaAlumnos() {
        vista.listarAlumnos(listaAlumnos);
    }
}
