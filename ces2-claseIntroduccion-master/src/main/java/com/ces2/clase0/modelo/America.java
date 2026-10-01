package com.ces2.clase0.modelo;
import java.util.List;

public class America implements IContinente {
    private String nombre;
    private List<Region> regiones;

    public America(String nombre, List<Region> regiones) {
        this.nombre = nombre;
        this.regiones = regiones;
    }

    @Override
    public String getNombre() { return nombre; }

    @Override
    public List<Region> getRegiones() { return regiones; }

    @Override
    public String obtenerNombre(List<Region> r) {
        return "Continente América (" + nombre + ") con " + r.size() + " regiones.";
    }

    @Override
    public String describirClima(List<Region> r) {
        return "Climas variados en las regiones de " + nombre;
    }

    @Override
    public String mencionarCuriosidad(List<Region> r) {
        return "Dato curioso sobre " + nombre;
    }
}