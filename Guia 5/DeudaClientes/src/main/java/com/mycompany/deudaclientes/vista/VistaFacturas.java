
package com.mycompany.deudaclientes.vista;

import com.mycompany.deudaclientes.modelo.Factura;
import java.util.*;

public class VistaFacturas {
    Scanner sc = new Scanner(System.in);
    public void mensaje(String msj){
        System.out.println(msj);
    }
    
    public void mostrarFacturas(List<Factura> facturas){
        System.out.println("--- Lista Facturas ---");
        for (Factura f : facturas){
            System.out.println(f.toString());
        }
    }
    public String pedirCliente(){
        System.out.print("Calcular deuda de Cliente: ");
        return sc.nextLine();
    }
}
