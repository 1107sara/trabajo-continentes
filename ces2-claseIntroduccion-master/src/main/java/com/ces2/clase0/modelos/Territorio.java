package com.ces2.clase0.modelos;

import java.util.ArrayDeque;
import java.util.Deque;

public class Territorio {
    private String nombre;
    private EnumRegion enumRegion;
    private Categoria categoria;
    private Deque<Region> regiones;

    // Constructor vacío
    public Territorio() {
        this.regiones = new ArrayDeque<>();
    }

    // Constructor con atributos incluyendo los dos Enums
    public Territorio(String nombre, EnumRegion enumRegion, Categoria categoria) {
        this.nombre = nombre;
        this.enumRegion = enumRegion;
        this.categoria = categoria;
        this.regiones = new ArrayDeque<>();
    }

    // Método para agregar objetos Region al Deque de regiones
    public void agregarRegion(Region region) {
        this.regiones.add(region);
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public EnumRegion getEnumRegion() {
        return enumRegion;
    }

    public void setEnumRegion(EnumRegion enumRegion) {
        this.enumRegion = enumRegion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Deque<Region> getRegiones() {
        return regiones;
    }

    public void setRegiones(Deque<Region> regiones) {
        this.regiones = regiones;
    }
}