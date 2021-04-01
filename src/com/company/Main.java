package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static  Biblioteca Tolstoy;
    private static List<Thread> socios = new ArrayList<>();

    public static void main(String[] args) {

        Tolstoy = new Biblioteca();

        Tolstoy.entregar(new Libro("Harry Potter"),"Benefactor Anonimo");
        Tolstoy.entregar(new Libro("Sistemas Operativos - Tanembaum"),"Benefactor Anonimo");
        Tolstoy.entregar(new Libro("El Principito"),"Benefactor Anonimo");
        Tolstoy.entregar(new Libro("La Historia sin fin"),"Benefactor Anonimo");
        Tolstoy.entregar(new Libro("El Hobbit"),"Benefactor Anonimo");


        for (int i = 0; i < 10; i++){
            socios.add(new Thread(new Socio("Socio " + i,Tolstoy)));
            socios.get(i).start();
        }

    }
}
