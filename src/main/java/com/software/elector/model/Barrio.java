package com.software.elector.model;

/**
 *
 * @author C.Mateo
 */
public class Barrio {
    private int id;
    private String nombre;
    private Comuna comuna;

    public Barrio() {
        id = -1;
        nombre = "";
        comuna = null;
    }

    public Barrio(int id, String nombre, Comuna comuna) {
        this.id = id;
        this.nombre = nombre;
        this.comuna = comuna;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Comuna getComuna() {
        return comuna;
    }

    public void setComuna(Comuna comuna) {
        this.comuna = comuna;
    }
    
    @Override
    public String toString() {
        return getNombre();
    }
   
}
