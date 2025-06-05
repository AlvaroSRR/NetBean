package com.mycompany.ejemplo_mvc;

import com.mycompany.ejemplo_mvc.controlador.ControladorUsuario;
import com.mycompany.ejemplo_mvc.vista.VistaUsuario;

public class Main {

    public static void main(String[] args) {
        llamadaControladorUsuario();
    }

    public static void llamadaControladorUsuario() {
        ControladorUsuario controlador = new ControladorUsuario(new VistaUsuario());
        controlador.crearNuevoObjeto();
        controlador.mostrarInformacion();
        controlador.actualizarInformacion();
        controlador.mostrarInformacion();
    }
}
