package com.ces2.clase0.modelos;

import java.util.Stack;

public class Region {
    private String nombre;
    private int numeroPaises;
    private double poblacionMillones;
    private EnumRegion enumRegion;
    private Categoria categoria;
    private Stack<Integer> conteo;

    // Constructor vacío
    public Region() {
        this.conteo = new Stack<>();
    }

    // Constructor con todos los atributos e incluyendo los dos Enums
    public Region(String nombre, int numeroPaises, double poblacionMillones, EnumRegion enumRegion, Categoria categoria) {
        this.nombre = nombre;
        this.numeroPaises = numeroPaises;
        this.poblacionMillones = poblacionMillones;
        this.enumRegion = enumRegion;
        this.categoria = categoria;
        this.conteo = new Stack<>();
    }

    // Método para agregar datos al Stack de números conteo
    public void agregarConteo(int valor) {
        this.conteo.push(valor);
    }

    // Método verTotales para el PUNTO 5 del trabajo
    public int verTotales(java.util.function.Function<Region, Integer> funcionSuma) {
        return funcionSuma.apply(this);
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroPaises() {
        return numeroPaises;
    }

    public void setNumeroPaises(int numeroPaises) {
        this.numeroPaises = numeroPaises;
    }

    public double getPoblacionMillones() {
        return poblacionMillones;
    }

    public void setPoblacionMillones(double poblacionMillones) {
        this.poblacionMillones = poblacionMillones;
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

    public Stack<Integer> getConteo() {
        return conteo;
    }

    public void setConteo(Stack<Integer> conteo) {
        this.conteo = conteo;
    }
}