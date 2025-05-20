package com.mycompany.guia_4_3;

import com.mycompany.guia_4_3.modelo.Conductor;
import com.mycompany.guia_4_3.modelo.Vehiculo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Guia_4_3 {

    public static void main(String[] args) {
        Map<Integer, Conductor> conductores = new HashMap<>();
        List<Vehiculo> vehiculos = new ArrayList<>();
        //lectura conductores
        try (FileReader fr = new FileReader("G:\\UTN\\2º CUATRIMESTRE\\Programacion 2\\NetBean\\Guia 4\\guia_4_3\\src\\main\\java\\com\\mycompany\\guia_4_3\\archivo\\Conductores.txt"); BufferedReader br = new BufferedReader(fr)) {
            br.readLine(); // lee una linea, la que tiene los titulos
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] parte = linea.split(";");
                Conductor c = new Conductor(Integer.parseInt(parte[0]), parte[1]);
                int codigo = Integer.parseInt(parte[0]);
                conductores.put(codigo, c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //print contenido Map conductores
        for (int i = 1; conductores.get(i) != null; i++) {
            System.out.println(conductores.get(i));
        }
        //Vehiculos
        try (FileReader fr = new FileReader("G:\\UTN\\2º CUATRIMESTRE\\Programacion 2\\NetBean\\Guia 4\\guia_4_3\\src\\main\\java\\com\\mycompany\\guia_4_3\\archivo\\Vehiculos.txt"); BufferedReader br = new BufferedReader(fr)) {
            br.readLine(); // lee una linea, la que tiene los titulos
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] parte = linea.split(";"); // codigo;patente;estado;conductor
                int codVehiculo = Integer.parseInt(parte[0]);
                String patente = parte[1];
                int estado = Integer.parseInt(parte[2]);
                Conductor c;
                if (parte.length == 3) {
                    c = new Conductor();
                } else {
                    int id = Integer.parseInt(parte[3]);
                    c = conductores.get(id);
                }

                Vehiculo v = new Vehiculo(codVehiculo, patente, estado, c);
                vehiculos.add(v);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //control para ver si carga el Map
        for (Vehiculo v : vehiculos) {
            System.out.println(v);
        }
        /*
        *Agregar Conductores y Vehiculos
            - Scanner para pedir datos
            - Agregarlo al txt verificando que no se repita el codigo
        *Cambiar estado de Vehiculos
            - Scanner para captar que estado quiere asignar
            - metodo setEstado para modificarlo
        *Cambiar Conductor de Vehiculo
            - Scanner para captar que conductor quiere asignar
            - metodo setConductor para modificarlo
        */
    }
}
