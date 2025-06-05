package com.mycompany.ejerciciomvc;

import com.mycompany.ejerciciomvc.controlador.ControladorAlumno;
import com.mycompany.ejerciciomvc.vista.VistaAlumno;

public class EjercicioMVC {
    public static void ejerciciosMvc (String [] args){
        
        //  C:\\Users\\alvar\\OneDrive\\Documentos\\Programacion II\\NetBean\\EjercicioMVC\\src\\main\\java\\com\\mycompany\\ejerciciomvc\\archivos\\Notas.txt
    }

    public static void main(String[] args) {
        ControladorAlumno controlador= new ControladorAlumno();
        VistaAlumno vista = new VistaAlumno();
        controlador.leerTxt("C:\\Users\\alvar\\OneDrive\\Documentos\\Programacion II\\NetBean\\Guia 5\\EjercicioMVC\\src\\main\\java\\com\\mycompany\\ejerciciomvc\\archivos\\Notas.txt");
        controlador.listaAlumnos();
    }
}
