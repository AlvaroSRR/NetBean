
package com.mycompany.resultadopartidos;

import com.mycompany.resultadopartidos.controlador.ControladorResultados;

public class ResultadoPartidos {

    public static void main(String[] args) {
        ControladorResultados controlador = new ControladorResultados();
        controlador.leerDatos("C:\\Users\\alvar\\OneDrive\\Documentos\\Programacion II\\NetBean\\Guia 5\\ResultadoPartidos\\src\\main\\java\\com\\mycompany\\resultadopartidos\\archivo\\Resultados.txt");
    }
}
