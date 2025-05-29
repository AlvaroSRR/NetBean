package com.mycompany.lista;

import java.util.*;

public class Lista {

    private List<Integer> numero = new ArrayList<>(); //se utiliza el nombre entero para indicar el tipo de valor de la lista
    private List<String> palabra = new ArrayList<>();

    //LLENAR LISTA CON NUMEROS RANDOM
    private void llenarLista() {
        System.out.println("--- LLENAR LISTA ---");
        for (int i = 0; i < 50; i++) {

            int num = (int) (Math.random() * 100); // valores random entre 0 y 99
            numero.add(num);
        }
        System.out.println(numero);
    }

    private void ordenar() {

        List<Integer> od = new ArrayList<>(numero);
        od.sort(Comparator.reverseOrder());
        System.out.println("--- ORDENAR DESCENDIENTE");
        System.out.println(od);
        System.out.println("--- ORDENAR ASCENDIENTE");
        od.sort(Comparator.naturalOrder());
        System.out.println(od);
        /*for (int n : od) {
            System.out.println(n);
        }*/
    }

    private void llenarString() {
        System.out.println("--- LLENAR STRING ---");
        palabra.add("ALVARO");
        palabra.add("XANDER");
        palabra.add("OTTO");
        palabra.add("RONALDO");
        palabra.add("LUIS");
        palabra.add("BALDU");
        palabra.add("CARRITO MONTERO");
        palabra.add("NICOLAS");
        palabra.add("NANO");
        palabra.add("JUAN PEREZ");
        palabra.add("TOMAS");
        palabra.add("SANSO");
        System.out.println(palabra);
    }

    private void ordenarPalabra() {
        System.out.println("--- ORDENAR ASCENDIENTE ---");
        List<String> pO = new ArrayList<>(palabra);
        pO.sort(Comparator.naturalOrder());
        System.out.println(pO);
        System.out.println("--- ORDENAR DESCENDIENTE ---");
        pO.sort(Comparator.reverseOrder());
        System.out.println(pO);
    }

    public static void main(String[] args) {
        Lista lista = new Lista();

        lista.llenarLista();
        lista.ordenar();
        lista.llenarString();
        lista.ordenarPalabra();

    }
}
