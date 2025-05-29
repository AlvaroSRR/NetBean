
package com.mycompany.repaso3.modelos;

import static java.lang.Math.random;
import java.util.Random;

public abstract class Sensor {
    private int numSensor;
    private String ubicacion;
    private int estado; // activo / inactivo
    private int contadorDetecciones;
    
    public Sensor(int codigo,String ubicacion,int estado){
        this.numSensor = codigo;
        this.ubicacion = ubicacion;
        this.estado = estado;
        this.contadorDetecciones = (int)(Math.random()*100);
    }

    public int getNumSensor() {
        return numSensor;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public int getEstado() {
        return estado;
    }

    public int getContadorDetecciones() {
        return contadorDetecciones;
    }
    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        String pe;
        if (estado == 0){
            pe = "Inactivo";
        }else{pe="Activo";}
        return "Numero de Sensor: " + numSensor + " - ubicacion: " + ubicacion + " - estado: " + pe + " - contadorDetecciones: " + contadorDetecciones;
    }
    
    
}
