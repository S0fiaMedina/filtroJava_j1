package com.filtrojava.pelicula.domain;

public class Pelicula {
    private int id;
    private String codigoInterno;
    String nombre;
    String duracion;
    String sinopsis;

    

    public Pelicula() {
    }


    

    
    public Pelicula(int id, String codigoInterno, String nombre, String duracion, String sinopsis) {
        this.id = id;
        this.codigoInterno = codigoInterno;
        this.nombre = nombre;
        this.duracion = duracion;
        this.sinopsis = sinopsis;
    }





    public int getId() {
        return id;
    }





    public void setId(int id) {
        this.id = id;
    }





    public String getCodigoInterno() {
        return codigoInterno;
    }





    public void setCodigoInterno(String codigoInterno) {
        this.codigoInterno = codigoInterno;
    }





    public String getNombre() {
        return nombre;
    }





    public void setNombre(String nombre) {
        this.nombre = nombre;
    }





    public String getDuracion() {
        return duracion;
    }





    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }





    public String getSinopsis() {
        return sinopsis;
    }





    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }





    @Override
    public String toString() {
        return "Id: " + this.id  + ", Nombre: " + this.nombre + ", duracion: " + this.duracion + ", sinopsis: " + this.sinopsis;
    }
    
}
