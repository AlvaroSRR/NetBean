package com.mycompany.promedionotas;

import com.mycompany.promedionotas.controlador.ControladorNotas;
import com.mycompany.promedionotas.vista.VistaNotas;
import java.util.*;

public class PromedioNotas {

    public static void main(String[] args) {
        
        ControladorNotas controlador = new ControladorNotas();
        String link = "C:\\Users\\alvar\\OneDrive\\Documentos\\Programacion II\\NetBean\\Guia 5\\PromedioNotas\\src\\main\\java\\com\\mycompany\\promedionotas\\archivo\\notas.txt";
        controlador.leerDatos(link);
        controlador.listaAlumnos();
        controlador.calcularPromedio();
    }
}
