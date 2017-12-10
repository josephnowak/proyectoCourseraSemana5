package com.example.josep.mascotascoursera.POJO;

import java.io.Serializable;

/**
 * Created by josep on 25/11/2017.
 */

public class InfoMascota implements Serializable
{
    private int foto , pata , patamg , id;
    private String nombre;
    private String rating;
    private boolean a;

    public InfoMascota(int id ,int foto, int patamg , int pata, String nombre, String rating, boolean a)
    {
        this.id = id;
        this.pata = pata;
        this.patamg = patamg;
        this.foto = foto;
        this.nombre = nombre;
        this.rating = rating;
        this.a = a;
    }
    public int getPata() {
        return pata;
    }

    public void setPata(int pata) {
        this.pata = pata;
    }

    public int getPatamg() {
        return patamg;
    }

    public void setPatamg(int estrella) {
        this.patamg = estrella;
    }
    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String  getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public boolean isA() {
        return a;
    }

    public void setA(boolean a) {
        this.a = a;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
