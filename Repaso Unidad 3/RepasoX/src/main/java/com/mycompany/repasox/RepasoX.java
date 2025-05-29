package com.mycompany.repasox;

import com.mycompany.repasox.modelos.Docente;
import com.mycompany.repasox.modelos.Especialidad;
import com.mycompany.repasox.modelos.Materia;
import java.util.*;

public class RepasoX {

    private Scanner sc = new Scanner(System.in);
    private List<Docente> docentes = new ArrayList<>();
    private List<Materia> materias = new ArrayList<>();
    private List<Especialidad> especialidades = new ArrayList<>();

    private void menu() {
        int opcion;
        do {
            System.out.println("-- MENU --");
            System.out.print("1. Registrar Docente \n2. Registrar Materia \n3. Registrar Espcialidad \n4. Asignar Materias \n 5. Informe de Materias por Docente \n6. Informe de Especialidad \n7. Informe de Docentes \n8. Ranking de Docentes por Materias \n0. Salir \nOpcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1: {
                    registrarDocente();
                    break;
                }
                case 2: {
                    registrarMateria();
                    break;
                }
                case 3: {
                    registrarEspecialidad();
                    break;
                }
                case 4: {
                    asignarMateria();
                    break;
                }
                case 5: {
                    listaMateriasPorDocente();
                    break;
                }
                case 6: {
                    docentesPorEspecialidad(); //ordenar Especialidades por nombre
                    break;
                }
                case 7: {
                    listaDocentesOrdenado(); //ordenar Docentes por nombre
                    break;
                }
                case 8: {
                    rankingDocentes();// ordenar por cantidad de materias
                    break;
                }

            }
        } while (opcion != 0);
    }

    private void docentesPorEspecialidad() {
        System.out.println("--- ESPECIALIDADES ---");
        printEspecialidades();
        System.out.print("Codigo: ");
        int codigo = sc.nextInt();
        int cont = 0;
        String nombEsp = "";
        for (Docente d : docentes) {
            if (d.getEspecialidad().getCodigo() == codigo) {
                cont++;
                nombEsp = d.getEspecialidad().getNombre();
            }
        }
        System.out.println("Especialidad: " + nombEsp + "Cantidad Docentes: " + cont);
    }

    private void listaMateriasPorDocente() {
        for (Docente d : docentes) {
            System.out.println("Docente: " + d.getNombre() + d.getMaterias());
        }
    }

    private void registrarDocente() {
        System.out.print("Numero de Legajo: ");
        int numLegajo = sc.nextInt();
        sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese Codigo de Especialidad");
        printEspecialidades();
        System.out.print("codigo: ");
        int codEspe = sc.nextInt();
        for (Especialidad e : especialidades) {
            if (e.getCodigo() == codEspe) {
                Docente d = new Docente(numLegajo, nombre, e);
                docentes.add(d);
                System.out.println("Registrado con Exito");
            }
        }
    }

    private void registrarEspecialidad() {
        System.out.print("Codigo de Especialidad: ");
        int codigo = sc.nextInt();
        sc.nextLine();
        System.out.print("Nombre Especialidad: ");
        String nombre = sc.nextLine();
        Especialidad e = new Especialidad(codigo, nombre);
        especialidades.add(e);
        System.out.println("Especialidad Registrada");
    }

    private void registrarMateria() {
        System.out.print("Codigo de Materia: ");
        int codigo = sc.nextInt();
        sc.nextLine();
        System.out.print("Nombre de Materia: ");
        String nombre = sc.nextLine();
        Materia m = new Materia(codigo, nombre);
        materias.add(m);
        System.out.println("Materia Registrada");
    }

    private void printEspecialidades() {
        //ORDENA LA LISTA POR NOMBRE
        List<Especialidad> ordenadas = new ArrayList<>(especialidades);
        ordenadas.sort(Comparator.comparing(Especialidad::getNombre));
        
        for (Especialidad e : ordenadas) {
            System.out.println(e.toString());
        }
    }

    private void asignarMateria() {
        System.out.println("-- PROFESORES --");
        listaDocentes();
        int cd = sc.nextInt();
        System.out.println("-- MATERIAS --");
        listarMaterias();
        System.out.print("codigo: ");
        int cm = sc.nextInt();
        for (Materia m : materias) {
            if (m.getCodigo() == cm) {
                for (Docente d : docentes) {
                    if (d.getNumLegajo() == cd) {
                        d.setMaterias(m);
                        System.out.println("Materia Asignada");
                    }

                }
            }
        }

    }

    private void rankingDocentes() {
        //docentes ordenados por cantidad de materias
         List<Docente> ordenadas = new ArrayList<>(docentes);
        ordenadas.sort(Comparator.comparing((Docente d) -> d.getMaterias().size()));
        for (Docente d : ordenadas) {
            System.out.println("nombre: " + d.getNombre() + "cant. materias: " + d.getMaterias().size());
        }
    }

    private void listaDocentes() {
        for (Docente d : docentes) {
            System.out.println(d);
        }
    }

    private void listaDocentesOrdenado() {
        //ORDENA LA LISTA POR NOMBRE
        List<Docente> ordenadas = new ArrayList<>(docentes);
        ordenadas.sort(Comparator.comparing(Docente::getNombre));
        for (Docente d : ordenadas) {
            System.out.println("nombre: " + d.getNombre() + "especialidad: " + d.getEspecialidad().getNombre() + "cantidad de materias: " + d.getMaterias().size());
        }
    }

    private void listarMaterias() {
        for (Materia m : materias) {
            System.out.println(m);
        }
    }

    public static void main(String[] args) {
        new RepasoX().menu();
    }
}
