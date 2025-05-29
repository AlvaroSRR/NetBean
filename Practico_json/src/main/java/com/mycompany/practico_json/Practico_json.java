package com.mycompany.practico_json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.modelos.Alumno;
import com.mycompany.modelos.Especialidad;
import java.io.*;
import java.util.*;

public class Practico_json {

    static Scanner sc = new Scanner(System.in);
    static List<Alumno> alumnos = new ArrayList<>();
    static List<Especialidad> especialidades = new ArrayList<>();
    static ObjectMapper mapper = new ObjectMapper();

    private void menu() {
        cargarDatos();
        int opt = 0;

        do {
            System.out.println("----  MENU  ----");
            System.out.println("1. Listar Cantidad de Alumnos por Especialidad");
            System.out.println("2. Listar Alumnos por Orden Alfabética \n3. Registrar Especialidad");
            System.out.println("4. Registrar Alumno \n5. Modificar Alumno \n6. Listar Alumnos Por Especialidad");
            System.out.println("7. Guardar");
            System.out.print("opcion: ");
            opt = sc.nextInt();
            switch (opt) {
                // Listar las especialidades, debe tener una columna con la cantidad de alumnos que tiene.
                case 1 ->
                    listarCantidadAlumnosPorEspecialidad();

                // Listar los alumnos por orden alfabético.
                case 2 ->
                    listarAlumnosOrdenados();

                //Agregar Especialidades
                case 3 ->
                    agregarEspecialidad();

                //Agregar Alumnos, por cada alumno nuevo hay que pedir la especialidad.
                case 4 ->
                    agregarAlumno();
                //Modificar Alumnos, por cada hay que pedir la especialidad.
                case 5 ->
                    modificarAlumno();
                //Pedir una especialidad y mostrar la lista de alumnos que tienen dicha especialidad
                case 6 ->
                    listarAlumnosPorEspecialidad();
                //Guardar los datos (los 2 objetos deben guardarse en formato JSON)
                case 7 ->
                    guardarDatos();
                default ->
                    System.out.println("Y donde esta carnero?");

            }
        } while (opt != 0);

    }

    static void cargarDatos() {
        try {
            alumnos = mapper.readValue(new File("G:\\UTN\\2º CUATRIMESTRE\\Programacion 2\\NetBean\\Practico_json\\src\\main\\java\\com\\mycompany\\archivos\\alumnos.json"), new TypeReference<>() {
            });
            especialidades = mapper.readValue(new File("G:\\UTN\\2º CUATRIMESTRE\\Programacion 2\\NetBean\\Practico_json\\src\\main\\java\\com\\mycompany\\archivos\\especialidades.json"), new TypeReference<>() {
            });
        } catch (Exception e) {
            System.out.println("Error al cargar archivos: " + e.getMessage());
        }
    }

    static void guardarDatos() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("G:\\UTN\\2º CUATRIMESTRE\\Programacion 2\\NetBean\\Practico_json\\src\\main\\java\\com\\mycompany\\archivos\\alumnos.json"), alumnos);
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("G:\\UTN\\2º CUATRIMESTRE\\Programacion 2\\NetBean\\Practico_json\\src\\main\\java\\com\\mycompany\\archivos\\especialidades.json"), especialidades);
        } catch (Exception e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }

    }

    static void listarAlumnosPorEspecialidad() {
        Especialidad especialidad = elegirEspecialidad();
        for (Alumno a : alumnos) {
            if (a.getEspecialidad().getCodigo().equals(especialidad.getCodigo())) {
                System.out.println(a);
            }
        }
    }

    static void modificarAlumno() {
        sc.nextLine();
        System.out.println("Ingrese DNI del alumno a modificar: ");
        int dni = Integer.parseInt(sc.nextLine());

        Alumno alumno = new Alumno();
        for (Alumno a : alumnos) {
            if (a.getDni() == dni) {
                alumno = a;
                break;
            }
        }
        if (alumno != null) {
            System.out.println("Nuevo Apellido: ");
            alumno.setApellido(sc.nextLine());
            System.out.println("Nuevo Nombre: ");
            alumno.setNombre(sc.nextLine());
            alumno.setEspecialidad(elegirEspecialidad());
            System.out.println("Alumno Modificada");
        } else {
            System.out.println("Alumno no Encontrado");
        }
    }

    private void listarCantidadAlumnosPorEspecialidad() {
        Map<String, Integer> contador = new HashMap<>();
        for (Especialidad e : especialidades) {
            contador.put(e.getDescripcion(), 0);
        }

        for (Alumno a : alumnos) {
            String descripcion = a.getEspecialidad().getDescripcion();
            contador.put(descripcion, contador.get(descripcion) + 1);
        }
        System.out.printf("%25s | %s\n", "Especialidad", "Cantidad de Alumnos");
        System.out.println("-------------------------------------------------------------");
        for (Especialidad e : especialidades) {
            System.out.printf("%25s | %s\n", e.getDescripcion(), contador.get(e.getDescripcion()));
        }
    }

    private void listarAlumnosOrdenados() {
        System.out.println("----- ALUMNOS -----");
        alumnos.stream()
                .sorted(Comparator.comparing(Alumno::getApellido).thenComparing(Alumno::getNombre))
                .forEach(System.out::println);
    }

    private void agregarEspecialidad() {
        sc.nextLine();
        System.out.print("Codigo Especialidad: ");
        String codigo = sc.nextLine();
        System.out.print("Descripcion: ");
        String descripcion = sc.nextLine();

        especialidades.add(new Especialidad(codigo, descripcion));
        System.out.println("Especialidad Agregada");
    }

    static void agregarAlumno() {
        sc.nextLine();
        System.out.print("DNI: ");
        int dni = sc.nextInt();
        sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Apellido: ");
        String apellido = sc.nextLine();

        Especialidad especialidad = elegirEspecialidad();
        if (especialidad != null) {
            alumnos.add(new Alumno(dni, nombre, apellido, especialidad));
            System.out.println("Alumno Agregado");
        }
    }

    static Especialidad elegirEspecialidad() {
        System.out.println("Elija Especialidad");
        for (int i = 0; i < especialidades.size(); i++) {
            System.out.println((i + 1) + ". " + especialidades.get(i));
        }
        sc.nextLine();
        System.out.println("Opcion: ");
        int opt = Integer.parseInt(sc.nextLine());
        if (opt > 0 && opt <= especialidades.size()) {
            return especialidades.get(opt - 1);
        } else {
            System.out.println("Opcion Invalida");
            return null;
        }
    }

    public static void main(String[] args) {
        new Practico_json().menu();
    }
}
