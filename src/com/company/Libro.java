package com.company;

import java.util.Random;
import java.util.UUID;

public class Libro {
    private static Integer cant = 0;
    private Integer id;
    private String titulo;

    public Libro(String titulo) {
        this.id = this.cant +1;
        this.cant++;
        this.titulo = titulo;
    }

    public Integer getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}
