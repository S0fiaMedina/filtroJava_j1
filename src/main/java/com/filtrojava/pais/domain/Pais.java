package com.filtrojava.pais.domain;

public class Pais {
    private int id;
    private String descripcion;

    

    public Pais() {
    }


    public Pais(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    @Override
    public String toString() {
        return "Id: " + this.id  + ", Nombre: " + this.descripcion;
    }
    
}
