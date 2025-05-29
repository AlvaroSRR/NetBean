
package com.mycompany.modelos;

public class HabitacionLujo extends Habitacion {
    
    public HabitacionLujo(int numero,double precio){
        super(numero,"Lujo",precio);
    }
    @Override
    public double calcularCostoTotal(int noches){
        
        double costo = precioPorNoche*noches;
        /*if (noches>=5){
            return costo*0.85;
        }else{
        return costo;}*/
        if (noches>=5){
            costo *=0.85;
        }
        return costo;
    }
}
