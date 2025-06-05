package com.mycompany.resultadopartidos.controlador;

import com.mycompany.resultadopartidos.modelo.Partido;
import com.mycompany.resultadopartidos.vista.VistaResultados;
import java.io.*;
import java.util.*;

public class ControladorResultados {
    VistaResultados vista = new VistaResultados();
    List<Partido> partidos = new ArrayList();
    public void leerDatos(String msj) {
        
        try(FileReader fr = new FileReader(msj); BufferedReader br = new BufferedReader(fr)){
            String linea;
            while ((linea= br.readLine()) != null){
                String[] dato = linea.split(",");
                String equipo1 = dato[0];
                String equipo2 = dato[2];
                int resultado1 = Integer.parseInt(dato[1]);
                int resultado2 = Integer.parseInt(dato[3]);
                Partido p = new Partido(equipo1,equipo2,resultado1,resultado2);
                partidos.add(p);
            }
            mostrarResultados();
        }catch(Exception e){
            vista.mensaje("Error de Lectura: "+e);
        }
    }

    public void mostrarResultados() {
        vista.mostrarResultados(partidos);
    }
}
