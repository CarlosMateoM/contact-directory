package com.software.elector.model;

/**
 *
 * @author C.Mateo
 */
public class Direccion {
    private int id;
    private Barrio barrio;
    private String calle;
    private String carrera;
    private String numero;
    private String sobre;

    public Direccion() {
    }

    public Direccion(int id, String calle, String carrera, String numero, String sobre, Barrio barrio) {
        this.id = id;
        this.calle = calle;
        this.carrera = carrera;
        this.numero = numero;
        this.sobre = sobre;
        this.barrio = barrio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Barrio getBarrio() {
        return barrio;
    }

    public void setBarrio(Barrio barrio) {
        this.barrio = barrio;
    }
    
    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getSobre() {
        return sobre;
    }

    public void setSobre(String sobre) {
        this.sobre = sobre;
    }
    
    public boolean isValid() {
        return barrio != null &&
               !calle.isEmpty() &&
               !carrera.isEmpty() &&
               !numero.isEmpty() &&
               !sobre.isEmpty();
    }
    
}
