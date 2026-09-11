package com.ces2.clase0.modelos;

public class Region {
    private String nombre;
    private String clima;
    private String detalle;

    public Region(String nombre, String clima, String detalle) {
        this.nombre = nombre;
        this.clima = clima;
        this.detalle = detalle;
    }
    public String getNombre() { return nombre; }
    public String getClima() { return clima; }
    public String getDetalle() { return detalle; }
}