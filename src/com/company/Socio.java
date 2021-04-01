package com.company;

import java.util.concurrent.TimeUnit;

public class Socio implements Runnable {
    private String nombre;
    private Biblioteca biblioteca;

    public Socio(String nombre,Biblioteca unaBiblioteca){
        this.nombre = nombre;
        this.biblioteca = unaBiblioteca;
    }

    public void run(){
        while(true){

            Integer idLibroRandom = (int) ((Math.random() * (6 - 1)) + 1);
            Libro libroSolicitado = this.biblioteca.solicitar(idLibroRandom, this.nombre);

            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.biblioteca.entregar(libroSolicitado, this.nombre);
        }
    }


}
