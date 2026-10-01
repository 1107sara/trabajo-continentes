package com.ces2.clase0.modelo;
import java.util.List;

public class Oceania implements IContinente {
    private String nombre;
    private List<Region> regiones;

    public Oceania(String nombre, List<Region> regiones) {
        this.nombre = nombre;
        this.regiones = regiones;
    }

    @Override
    public String getNombre() { return nombre; }

    @Override
    public List<Region> getRegiones() { return regiones; }

    @Override
    public String obtenerNombre(List<Region> r) {
        return "Continente Oceanía (" + nombre + ") con " + r.size() + " regiones.";
    }

    @Override
    public String describirClima(List<Region> r) {
        return "Clima insular en las regiones de " + nombre;
    }

    @Override
    public String mencionarCuriosidad(List<Region> r) {
        return "Dato curioso sobre " + nombre;
    }
}