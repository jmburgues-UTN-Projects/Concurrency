package com.company;

import java.util.Hashtable;
import java.util.Map;

public class Biblioteca {
    Map<Integer,Libro> coleccion;
    Boolean bibliotecaOcupada;

    public Biblioteca(){
        this.coleccion = new Hashtable<>();
    }

    public synchronized Libro solicitar(Integer idLibro, String nombreSocio){
        // Mientras que el libro no este, pongo al hilo a dormir
        while(!this.coleccion.containsKey(idLibro)){
            try {
                wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }

        Libro solicitado = this.coleccion.get(idLibro);
        this.coleccion.remove(idLibro);
        System.out.println(nombreSocio + " ** RETIRA ** el libro ID: " + solicitado.getId() + ", Titulo: " + solicitado.getTitulo());
        return solicitado;
    }

    public synchronized void entregar(Libro unLibro, String nombreSocio){
        this.coleccion.put(unLibro.getId(), unLibro);
        System.out.println(nombreSocio + " -- ENTREGA -- el libro ID: " + unLibro.getId() + ", Titulo: " + unLibro.getTitulo());
        notify();
    }

    public void mostrarColeccion(){
        this.coleccion.forEach((id,libro) ->
                System.out.println("ID: " + id + ", Titulo: " + libro.getTitulo()));
    }
}