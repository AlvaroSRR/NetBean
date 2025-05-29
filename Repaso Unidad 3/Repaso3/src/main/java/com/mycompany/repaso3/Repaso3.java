package com.mycompany.repaso3;

import com.mycompany.repaso3.modelos.Sensor;
import com.mycompany.repaso3.modelos.SensorAcaro;
import com.mycompany.repaso3.modelos.SensorAve;
import com.mycompany.repaso3.modelos.SensorInsecto;
import com.mycompany.repaso3.modelos.SensorRoedor;
import java.util.*;

public class Repaso3 {

    private List<Sensor> sensores = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    private void menu() {
        int opcion;
        do {
            System.out.println("-- MENU --");
            System.out.print("1. Registrar Sendor \n2. Modificar Estado \n3. Listar Sensores Inactivos \n Opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1: {
                    registrarSensor();
                    break;
                }
                case 2: {
                    System.out.println("--- Sensores ---");
                    printSensores();
                    modificarEstadoSensor();
                    break;
                }
                case 3: {
                    System.out.println("--- Sensores Inactivos ---");
                    printSensoresInactivos();
                    break;
                }
            }
        } while (opcion != 0);
    }

    private void registrarSensor() {
        int opcion;
        System.out.print("Codigo de Sensor: ");
        int codigo = sc.nextInt();
        sc.nextLine();
        System.out.print("Ubicacion: ");
        String ubicacion = sc.nextLine();
        System.out.print("Estado:\n0. Inactivo \n1. Activo \nOpcion: ");
        int estado = sc.nextInt();
        System.out.print("Tipo de Sensor:\n 1.Insectos \n2. Acaros \n3. Roedores \n4. Aves \n Opcion:");

        opcion = sc.nextInt();

        switch (opcion) {
            case 1: {
                Sensor s = new SensorInsecto(codigo, ubicacion, estado);
                sensores.add(s);
                System.out.println("Sensor Registrado");
                break;
            }
            case 2: {
                Sensor s = new SensorAcaro(codigo, ubicacion, estado);
                sensores.add(s);
                System.out.println("Sensor Registrado");
                break;
            }
            case 3: {
                Sensor s = new SensorRoedor(codigo, ubicacion, estado);
                sensores.add(s);
                System.out.println("Sensor Registrado");
                break;
            }
            case 4: {
                Sensor s = new SensorAve(codigo, ubicacion, estado);
                sensores.add(s);
                System.out.println("Sensor Registrado");
                break;
            }
            default:{
                System.out.println("Valor fuera de rango");
                // controlar con un Do while
            }
        }
    }

    private void printSensores() {
        for (Sensor s : sensores) {
            System.out.println(s);
        }
    }

    private void modificarEstadoSensor() {
        System.out.println("Codigo de Sensor:");
        int e = sc.nextInt();
        for (Sensor s : sensores){ 
            if (s.getNumSensor()==e) {
                if (s.getEstado() == 0) {
                    s.setEstado(1);
                } else {
                    s.setEstado(0);
                }
            }
        }
        System.out.println("Cambio de estado Exitoso");
    }

    private void printSensoresInactivos() {
        for (Sensor s : sensores) {
            if (s.getEstado() == 0) {
                System.out.println(s.toString());
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("--- GESTION DE SENSORES ---");
        new Repaso3().menu();
    }
}
