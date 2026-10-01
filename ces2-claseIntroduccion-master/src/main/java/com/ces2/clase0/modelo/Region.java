package com.ces2.clase0.modelo;

public class Region {
    private String nombre;
    private String clima;
    private Integer poblacion;

    public Region(String nombre, String clima, Integer poblacion) {
        this.nombre = nombre;
        this.clima = clima;
        this.poblacion = poblacion;
    }

    public String getNombre() { return nombre; }
    public String getClima() { return clima; }
    public Integer getPoblacion() { return poblacion; }
}

