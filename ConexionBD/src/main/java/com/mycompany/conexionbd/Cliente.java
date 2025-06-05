
package com.mycompany.conexionbd;

public class Cliente implements Comparable<Cliente> {
    private int codigo;
    private String nombre;
    private String apellido;

    public Cliente() {
    }

    public Cliente(int codigo, String nombre, String apellido) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido= apellido;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return apellido;
    }

    @Override
    public String toString() {
        return "Cliente: " + codigo + " - Nombre: " + nombre+ " - Apellido: "+apellido;
    }
    @Override
    public int compareTo(Cliente o){
        return this.getNombre().compareTo(o.getNombre());
    }
    
}
