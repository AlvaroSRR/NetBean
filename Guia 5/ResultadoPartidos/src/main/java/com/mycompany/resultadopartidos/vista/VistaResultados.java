
package com.mycompany.resultadopartidos.vista;

import com.mycompany.resultadopartidos.modelo.Partido;
import java.util.*;

public class VistaResultados {
    public void mostrarResultados(List<Partido> resultados){
        System.out.println("--- RESULTADOS ---");
        for(Partido p : resultados){
            System.out.println(p.toString());
        }
    }
    public void mensaje(String msj){
        System.out.println(msj);
    }
}
