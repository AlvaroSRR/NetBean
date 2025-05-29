
package com.mycompany.modelos;

public class HabitacionEstandar extends Habitacion{
    
    public HabitacionEstandar(int numero,double precio){
        super(numero,"Estandar",precio);
    }
    @Override
    public double calcularCostoTotal(int noches){
        return precioPorNoche* noches;
    }
    
}
