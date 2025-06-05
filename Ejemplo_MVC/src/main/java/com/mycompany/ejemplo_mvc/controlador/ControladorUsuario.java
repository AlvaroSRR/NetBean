package com.mycompany.ejemplo_mvc.controlador;

import com.mycompany.ejemplo_mvc.modelo.Usuario;
import com.mycompany.ejemplo_mvc.vista.VistaUsuario;

public class ControladorUsuario {
    private VistaUsuario vista;
    private Usuario modelo;

    public ControladorUsuario(VistaUsuario vista) {
        this.vista = vista;
    }

    public void crearNuevoObjeto() {
        String nombre = vista.solicitarNombreUsuario();
        String correo = vista.solicitarCorreoUsuario();
        this.modelo = new Usuario(nombre, correo);
    }

    public void actualizarInformacion() {
        modelo.setNombre(vista.solicitarNombreUsuario());
        modelo.setCorreo(vista.solicitarCorreoUsuario());
    }

    public void mostrarInformacion() {
        String[] data = modelo.getInfoUsuario();
        vista.mostrarInformacion(data);
    }
}