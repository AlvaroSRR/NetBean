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
                //control para ver si carga el Map
                System.out.println(conductores.values());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }//Vehiculos
        try (FileReader fr = new FileReader("G:\\UTN\\2º CUATRIMESTRE\\Programacion 2\\NetBean\\Guia 4\\guia_4_3\\src\\main\\java\\com\\mycompany\\guia_4_3\\archivo\\Vehiculos.txt"); BufferedReader br = new BufferedReader(fr)) {
            br.readLine(); // lee una linea, la que tiene los titulos
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] parte = linea.split(";"); // codigo;patente;estado;conductor
                
                for(conductores.keySet().equals(Integer.parseInt(parte[3])){}
                for Conductor cv : conductores.values() != null
                Conductor cv= new Conductor(parte[3])
                
                        
                        Vehiculo v = new Vehiculo(Integer.parseInt(parte[0]), parte[1],Integer.parseInt(parte[2]),"conductor");
                int codigo = Integer.parseInt(parte[0]);
                conductores.put(codigo, c);
                //control para ver si carga el Map
                System.out.println(conductores.values());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
