package com.mgaj.act2.models.dto;

public class Equipo 
{
    private String nombre,pais;
    private int copasGanadas;

    public Equipo () {}

    public Equipo (String nombre, String pais, int copasGanadas)
    {
        this.nombre = nombre;
        this.pais = pais;
        this.copasGanadas = copasGanadas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getCopasGanadas() {
        return copasGanadas;
    }

    public void setCopasGanadas(int copasGanadas) {
        this.copasGanadas = copasGanadas;
    }

    
}
