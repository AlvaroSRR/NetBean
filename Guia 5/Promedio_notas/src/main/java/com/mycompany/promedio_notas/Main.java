package com.mycompany.promedio_notas;

import com.mycompany.promedio_notas.controlador.ControladorAlumno;
import com.mycompany.promedio_notas.vista.VistaAlumno;

public class Main {

    public static void main(String[] args) {
        ControladorAlumno controlador = new ControladorAlumno(new VistaAlumno());

        controlador.cargarDatosDesdeArchivo("E:\\Usuario\\Mis documentos\\NetBeansProjects\\Promedio_notas\\src\\main\\java\\com\\mycompany\\promedio_notas\\archivos\\notas.txt");
        controlador.calcularYMostrarPromedio();
    }
}
