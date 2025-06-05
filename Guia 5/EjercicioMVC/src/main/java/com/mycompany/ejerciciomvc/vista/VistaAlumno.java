package com.mycompany.ejerciciomvc.vista;

import com.mycompany.ejerciciomvc.controlador.ControladorAlumno;
import com.mycompany.ejerciciomvc.modelo.Alumno;
import java.util.*;

public class VistaAlumno {
    private ControladorAlumno controlador;
    public void elegirAlumno(){
        Scanner sc = new Scanner(System.in);
        controlador.listaAlumnos();
        
    }
    public void listarAlumnos(List<Alumno> lista){
        System.out.println("LISTA DE ALUMNOS");
        for(Alumno a : lista){
            System.out.println(a.toString());
        }
    }
    
}
