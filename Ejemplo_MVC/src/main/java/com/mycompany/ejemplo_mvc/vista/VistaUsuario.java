package com.mycompany.ejemplo_mvc.vista;

import java.util.Scanner;

public class VistaUsuario {
    private Scanner scanner = new Scanner(System.in);

    public String solicitarNombreUsuario() {
        System.out.print("Ingrese el nombre del usuario: ");
        return scanner.nextLine();
    }

    public String solicitarCorreoUsuario() {
        System.out.print("Ingrese el correo del usuario: ");
        return scanner.nextLine();
    }

    public void mostrarInformacion(String[] data) {
        System.out.println("INFORMACION DEL USUARIO");
        System.out.println("Nombre: " + data[0] + " - Correo: " + data[1]);
    }
}